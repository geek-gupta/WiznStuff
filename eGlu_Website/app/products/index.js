const hbs = require('hbs');
const fs = require('fs');


// This JS file includes endpoints, related to Products only.
// While adding products to the main page, add the product name to the products array.
// Also make a separate product Json data file for the same.
// Make sure that file name should be:     product name + "-data.json"
// Make sure that name passed in endpoints of specific product should match the filename, like following:
// /product/hub : filename => hub-data.json
// /product/in-wall-switch => in-wall-switch-data.json


getProductmd1 = (req, res, next) => {
  console.log(`I am ${req.params.productName}`);
  next();
}

getProduct = ( req, res) => {
   var productName = req.params.productName;
   var products = ["hub", "motion-sensor", "in-wall-switch", "tag", "smart-plug-6a", "smart-plug-16a", "panic-alarm"];
   if (products.includes(productName)) {
     var data = fs.readFileSync(`data_files/${productName}-data.json`);
     res.render('product-item-template', JSON.parse(data));
   } else {
     res.sendFile('/home/gaurav/Desktop/website2.0/eGlu_Website/public/errorPage.html');
   }
}

// Here getProductmd1 is a middleWware, just to log the product name.Learning purpose.

module.exports = {
  getProduct,
  getProductmd1
};
