const fs = require('fs');


// This JS file includes endpoints related to Support section only.
// Make sure the file name of pdf should be same as of what is passed in the url or API.
// example: API => /support/pdf/eglu then filename should be eglu.pdf
// example: API => /support/pdf/main-brochure then filename should be main-brochure.pdf


getPdfFile = (req, res) => {
  var pdfName = req.params.fileName;
  var pdfs = ["eglu", "eglu1"];
  if (pdfs.includes(pdfName)) {
    var data = fs.readFileSync(`data_files/pdf_files/${pdfName}.pdf`);
    res.contentType("application/pdf");
    res.send(data);
  } else {
    res.send("PDF Not Found");
  }
};


module.exports = {
  getPdfFile
};
