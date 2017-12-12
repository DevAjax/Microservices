'use strict';
module.exports = function (app) {
    var cors = require('cors');
    var authapi = require('../controllers/controller');

    // authapi Routes
    app.route('/authorization')
        .post(authapi.authorization_post);
    app.route('/adduser')
        .post(authapi.add_user);
    app.use(cors({origin: 'http://localhost:63342'}));
};
