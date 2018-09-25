const express = require('express');
const hbs = require('hbs');
const bodyParser = require('body-parser');
var mcache = require('memory-cache');
const products = require('./app/products');
const support = require('./app/support');
const mainAPIs = require('./app/mainAPIs');
const fs = require('fs');


var cache = (duration) => {
  return (req, res, next) => {
    let key = '__express__' + req.originalUrl || req.url
    let cachedBody = mcache.get(key)
    if (cachedBody) {
      res.send(cachedBody)
      return
    } else {
      res.sendResponse = res.send
      res.send = (body) => {
        mcache.put(key, body, duration * 1000);
        res.sendResponse(body)
      }
      next()
    }
  }
}

const port = process.env.PORT || 5000;
var app = express();
app.use(bodyParser.json());
app.use(bodyParser.urlencoded({
  extended: true
}));

hbs.registerPartials(__dirname + '/views/partials');
app.set('view engine', 'hbs');
app.use(express.static(__dirname + '/public'));




// cache(duration). Here after duration is completed the cache item will be deleted and will again added when rqst to that item is made.
// change duration to persist the cache for long.

app.get('/', cache(2000), mainAPIs.getHomePage);
app.get('/about', cache(2000), mainAPIs.getAboutPage);
app.get('/product', cache(2000), mainAPIs.getProductPage);
app.get('/support', cache(2000), mainAPIs.getSupportPage);
app.get('/faq', cache(2000), mainAPIs.getFaqPage);
app.get('/signup', cache(2000), mainAPIs.getSignUpPage);
app.get('/Smart-home', cache(2000), mainAPIs.getSmartHomePgae);
app.get('/home-security', cache(2000), mainAPIs.getHomeSecurityPage);
// Use of MiddleWare here: products.getProductmd1 is a MiddleWare. Just to learn the use of MiddleWare.
app.get('/product/:productName', cache(2000), products.getProductmd1, products.getProduct);
app.get("/support/pdf/:fileName", cache(2000), support.getPdfFile);
app.get('/test', cache(2000), (req, res) => {
  res.render('test');
})


app.get('/getAPIdata', (req, res) => {
  var data = fs.readFileSync('./data_files/hub-data.json');
  res.setHeader('Content-Type', 'application/json');
  // res.send(JSON.stringify(data, null, 3));
  res.json(JSON.parse(data));
});


//this route is for get-a-demo form. ReCaptcha validation and saving data to database.
app.post('/getDemoData', (req, res) => {
  // console.log(req.body.name);

  if (req.body['g-recaptcha-response'] === undefined || req.body['g-recaptcha-response'] === '' || req.body['g-recaptcha-response'] === null) {
    return res.json({
      "responseCode": 1,
      "responseDesc": "Please select captcha"
    });
  }
  // Put your secret key here.
  var secretKey = "6LfrZWcUAAAAAIXmC9erzcAjbMDFAR1m3R1zDWji";
  // req.connection.remoteAddress will provide IP address of connected user.
  var verificationUrl = "https://www.google.com/recaptcha/api/siteverify?secret=" + secretKey + "&response=" + req.body['g-recaptcha-response'] + "&remoteip=" + req.connection.remoteAddress;
  // Hitting GET request to the URL, Google will respond with success or error scenario.
  request(verificationUrl, function(error, response, body) {
    body = JSON.parse(body);
    // Success will be true or false depending upon captcha validation.
    if (body.success !== undefined && !body.success) {
      return res.json({
        "responseCode": 1,
        "responseDesc": "Failed captcha verification"
      });
    }
    res.redirect('/signup'); // this is the response to be sent
  });
});

app.get('*', (req, res) => {
  res.sendFile(__dirname + '/public/errorPage.html');
});


app.listen(port, (err) => {
  if (err) throw err;
  console.log("Server started at: " + port);
});
