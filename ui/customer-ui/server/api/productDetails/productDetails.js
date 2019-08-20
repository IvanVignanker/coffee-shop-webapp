const json = require('jsonfile');
let rest = require('restler');
let configuration = require('../../config/backend-config');

exports.getProductDetails = function (request, response) {
  const file = '../customer-ui/server/api/mock/jsons/productDetails.json';
  let id = request.params.id;

  //from file
  json.readFile(file, function (err, obj) {
    if (err) {
      err.status(500);
      console.error(err);
    }
    response.status(200).send(obj);
  });

  //spring
  // rest.get(configuration.perEnvironment.backendUrl + '/customer/products/' + id)
  //   .on('success', (backendResponseBody, backendResponseMeta) => {
  //     response.writeHead(200, {'Content-Type': 'application/json'}).json(backendResponseBody).end();
  //   })
  //   .on('fail', (backendResponseBody, backendResponseMeta) => {
  //     response.status(backendResponseMeta.statusCode).send(backendResponseBody);
  //   });
};
