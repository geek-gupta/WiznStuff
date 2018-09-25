const fs = require('fs');
const hbs = require('hbs');

// This JS file included all the main endpoints { APIs } od our website.
// Do not add generic endpoints or APIs here.
// For content of any page refer to data_files.


var data = "";

getHomePage = (req, res) => {
  data = fs.readFileSync('data_files/indexPageData.json');
  res.render('index', JSON.parse(data));
}


getAboutPage = (req, res) => {
  res.render('about');
}


getProductPage = (req, res) => {
  data = fs.readFileSync('data_files/productPageData.json');
  res.render('product', JSON.parse(data));
}

getSupportPage = (req, res) => {
  data = fs.readFileSync('data_files/supportData.json');
  res.render('support', JSON.parse(data));
}


getFaqPage = (req, res) => {
  data = fs.readFileSync('data_files/faqData.json');
  res.render('faq', JSON.parse(data));
}


getSignUpPage = (req, res) => {
  res.render('signup');
}


getSmartHomePgae = (req, res) => {
  res.render('smartHome');
}

getHomeSecurityPage = (req, res) => {
  res.render('homeSecurity');
}

module.exports = {
  getHomePage,
  getAboutPage,
  getFaqPage,
  getSignUpPage,
  getSupportPage,
  getProductPage,
  getSmartHomePgae,
  getHomeSecurityPage
};
