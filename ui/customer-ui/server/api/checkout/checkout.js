const json = require('jsonfile');
let rest = require('restler');
let configuration = require('../../config/backend-config');

exports.getCheckout = function (request, response) {
  const file = '../customer-ui/server/api/mock/jsons/checkout.json';

  //from file
  json.readFile(file, function (err, obj) {
    if (err) {
      console.error(err);
    }
    response.send(obj);
  });

  //for spring
  let body = request.body;

  rest.postJson(configuration.perEnvironment.backendUrl + '/customer/checkout', body)
    .on('success', (backendResponseBody, backendResponseMeta) => {
      response.json(backendResponseBody);
    })
    .on('fail', (backendResponseBody, backendResponseMeta) => {
      response.status(backendResponseMeta.statusCode).send(backendResponseBody);
    });
};
