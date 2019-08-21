const json = require('jsonfile');

exports.getProductDetails = function (request, response) {
  const file = '../customer-ui/server/api/mock/jsons/productDetails.json';
  let id = request.params.id;

  json.readFile(file, function (err, obj) {
    if (err) {
      console.error(err);
    }
    response.send(obj);
  });
};
