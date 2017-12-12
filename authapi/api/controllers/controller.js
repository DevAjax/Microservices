'use strict';


var mongoose = require('mongoose'),
    User = mongoose.model('Users');



exports.add_user = function (req, res) {
    var newUser = new User(req.body);
    newUser.save(function (err, user) {
        if (err) {
            res.send(err);
        }
        res.json(user);
    });
};

const request = require("request");
exports.authorization_post = function (req, res1) {
    User.findOne({login: req.body.login, password: req.body.password}, function (err, user) {
        if (err) {
            console.log(err);
        }
        if (user) {
            request.get({
                url: "http://localhost:8080/userset/userdata",
                qs: {"userIdentifier": user.userIdentifier}
            }, function (err, response, body) {
                res1.setHeader('Access-Control-Allow-Origin', 'http://localhost:63342');
                res1.setHeader('Access-Control-Allow-Methods', 'GET, POST, OPTIONS, PUT, PATCH, DELETE');
                res1.setHeader('Access-Control-Allow-Headers', 'X-Requested-With,content-type');
                res1.setHeader('Access-Control-Allow-Credentials', true);
                res1.json(body);
            });
        } else {
            res1.status(500).json({ error: 'something went wrong' });
        }
    })
};
