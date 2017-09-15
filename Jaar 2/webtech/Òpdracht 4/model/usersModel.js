var mongoose = require('mongoose');
var Schema = mongoose.Schema;
var userSchema = new Schema(
    {
        username: {type: String, required: true, index: { unique: true }},
        password: {type: String, required: true},
        firstname: {type: String, required: true},
        lastnamePrefix: {type: String},
        lastname: {type: String, required: true}
    });

module.exports = mongoose.model('user', userSchema);