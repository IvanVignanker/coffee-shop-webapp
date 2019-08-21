const json = require('jsonfile');

exports.getProductList = function (request, response) {
  const file = '../customer-ui/server/api/mock/jsons/productList.json';

  json.readFile(file, function (err, obj) {
    if (err) {
      console.error(err);
    }
    response.send(obj);
  });
};
