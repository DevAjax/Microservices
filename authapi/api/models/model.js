'use strict';
var mongoose = require('mongoose');
var Schema = mongoose.Schema;



var UserSchema = new Schema({
    login: {
        type: String,
        required: 'Enter login'
    },
    password: {
        type: String,
        required: 'Enter password'
    },
    userIdentifier:{
        type: String
    }
});

module.exports = mongoose.model('Users', UserSchema);