let rest = require('restler');
let configuration = require('../../config/backend-config');

exports.getProductDetails = function (request, response) {
  let id = request.params.id;

  rest.get(configuration.perEnvironment.backendUrl + '/customer/products/' + id)
    .on('success', (backendResponseBody, backendResponseMeta) => {
    response.json(backendResponseBody);
})
.on('fail', (backendResponseBody, backendResponseMeta) => {
    response.status(backendResponseMeta.statusCode).send(backendResponseBody);
});
};
