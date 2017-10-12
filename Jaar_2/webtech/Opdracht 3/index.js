var express = require("express");
var bodyParser = require("body-parser");
var validator = require('express-validator');

var app = express();

app.set('private-key', 'alwaysLookOnTheBrightSideOfLifeTuduTudutudutudu');

var mongoose = require('mongoose');
mongoose.connect('127.0.0.1');

var users = require('./resources/users.js');
var films = require('./resources/movies.js');
var ratings = require('./resources/ratings.js');

app.use(bodyParser.urlencoded({extended: false}));
app.use(bodyParser.json());

app.use('/users', users);
app.use('/movies', films);
app.use('/ratings', ratings);

app.get('/filldatabase', function (req, res) {
    console.log('Filling database!');

    var Movie = require('./model/moviesModel.js');
    new Movie({
        imdbTtNumber: 1,
        title: 'Banana: The Movie',
        publicationDate: '2010-05-30',
        filmLength: 112,
        director: 'Michael Bay',
        description: 'gr8, i r8 8 out of 8'
    }).save();

    new Movie({
        imdbTtNumber: 2,
        title: 'Banana: The Movie Part II',
        publicationDate: '2014-05-30',
        filmLength: 123,
        director: 'Michael Bay',
        description: 'also gr8, i r8 8 out of 8'
    }).save();

    res.status(200).json({result: 'ok'});
});

app.listen(3000, function () {
    console.log('Example app listening on port 3000!');
});