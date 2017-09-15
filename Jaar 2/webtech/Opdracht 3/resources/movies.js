var express = require("express");
var app = express();

var movieModel = require('../model/moviesModel.js');

app.get('/allmovies', function (req, res) {
    movieModel.find({}, '-_id -__v', function (err, results) {
        if (err) {
            res.status(500).json({error: 'internal server error'});
        }
        res.status(200).json(results);
    });
});

app.get('/moviewithid', function (req, res) {
    var imdbTtNumber = req.query.id;

    movieModel.find({imdbTtNumber: imdbTtNumber}, '-_id -__v', function (err, results) {
        if (err) {
            res.status(500).json({error: 'internal server error'});
        }

        console.log(results);

        if (results == "") {
            res.status(400).json({error: 'movie not found'});
        } else {
            res.status(200).json(results);
        }
    });
});

module.exports = app;