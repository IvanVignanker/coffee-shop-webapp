let rest = require('restler');
let configuration = require('../../config/backend-config');
let path = require("path");

exports.getImagesById = function (request, response) {
  let dir = path.join(__dirname, '../mock/images/black-coffee-bean-seed-shape-600w-1273417555.jpg');
  response.sendFile(dir);
};
