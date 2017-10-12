var mongoose = require('mongoose');
var Schema = mongoose.Schema;
var filmSchema = new Schema(
    {
        imdbTtNumber: {type: Number, required: true, unique: true},
        title: {type: String, required: true},
        publicationDate: {type: Date, required: true},
        filmLength: {type: Number, required: true},
        director: {type: String, required: true},
        description: {type: String, required: true}
    });

module.exports = mongoose.model('film', filmSchema);