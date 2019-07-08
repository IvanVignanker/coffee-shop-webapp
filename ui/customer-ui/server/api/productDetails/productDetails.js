const json = require('jsonfile');

exports.getProductDetails = function (request, response) {
  const file = '../customer-ui/server/api/mock/jsons/productDetails.json';

  json.readFile(file, function (err,  obj) {
    response.send(obj);
  })
};
