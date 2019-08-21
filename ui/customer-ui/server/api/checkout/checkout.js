const json = require('jsonfile');

exports.getCheckout = function (request, response) {
  const file = '../customer-ui/server/api/mock/jsons/checkout.json';

  json.readFile(file, function (err, obj) {
    if (err) {
      console.error(err);
    }
    response.send(obj);
  });
};
