var mongoose = require('mongoose');
var Schema = mongoose.Schema;
var ratingSchema = new Schema(
    {
        ratingNumber: {type: Number, required: true},
        username: {type: String, required: true},
        imdbTtNumber: {type: Number, required: true}
    });

module.exports = mongoose.model('rating', ratingSchema);