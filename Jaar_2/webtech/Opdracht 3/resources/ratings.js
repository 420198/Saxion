var express = require("express");
var app = express();

var jwt = require('jsonwebtoken');

var ratingsModel = require('../model/ratingsModel.js');

app.post('/add', function (req, res) {
    var token = req.headers['authorization'];

    jwt.verify(token, app.get('private-key'), function (err, decoded) {
        if (err) {
            res.status(403).json({error : 'not logged in!'});
        }
        else {
            var username = decoded.username;
            var imdbNumber = req.body.imdbTtNumber;

            ratingsModel.count({username: username, imdbTtNumber: imdbNumber}, function (err, results) {
                if (err) {
                    res.status(500).json({error: 'internal server error'});
                }
                else {

                    console.log('Rated : ' + results + ' times');

                    if (results > 0) {
                        res.status(500).json({status: 'already rated'});
                    }
                    else {
                        var ratingNumber = round(req.body.ratingNumber, 0.5);

                        var addRating = new ratingsModel(
                            {
                                ratingNumber: ratingNumber,
                                imdbTtNumber: imdbNumber,
                                username: username
                            });

                        addRating.save(function (err, result) {
                            if (err) {
                                res.status(500).json({error: 'internal server error'});
                            }
                            res.status(200).json({status: 'success'});
                        });
                    }
                }
            });
        }
    });
});

app.get('/get', function (req, res) {
    var token = req.headers['authorization'];

    jwt.verify(token, app.get('private-key'), function (err, decoded) {
        if (err) {
            res.status(403).json({error : 'not logged in!'});
        }
        else {

            var imdbTtNumber = req.query.id;

            console.log('Movie ID : ' + imdbTtNumber);

            ratingsModel.find({imdbTtNumber: imdbTtNumber}, '-_id -__v -imdbTtNumber', function (err, results) {
                if (err) {
                    res.status(500).json({'error': 'boem'});
                }
                else {

                    if (req.query.average == 1) {

                        //declare variables
                        var average = 0;
                        var jsonArray = JSON.parse(JSON.stringify(results));
                        var i;

                        for (i = 0; i < jsonArray.length; i++) {
                            average += jsonArray[i].ratingNumber;
                        }

                        res.status(200).json({'average': average / i})
                    }
                    else {
                        console.log(results);
                        res.status(200).json(results);
                    }
                }
            });
        }
    });
});

app.put('/update', function (req, res) {
    //authorization
    var token = req.headers['authorization'];

    jwt.verify(token, app.get('private-key'), function (err, decoded) {
        if (err) {
            res.status(403).json({error : 'not logged in!'});
        }
        else {
            var imdbNumber = req.body.imdbTtNumber;
            var username = decoded.username;

            ratingsModel.find({username: username, imdbTtNumber: imdbNumber}, function (err, results) {
                if (err) {
                    res.status(500).json({error: 'internal server error'});
                }
                else {
                    if (results != "") { //we can change the rating now!
                        var ratingNumber = round(req.body.ratingNumber, 0.5);

                        ratingsModel.findOneAndUpdate({username: username, imdbTtNumber: imdbNumber},
                            {$set: {ratingNumber: ratingNumber}}, function (err, result) {
                                if (err) {
                                    return res.send(500, {error: err})
                                } else {
                                    return res.status(200).json({status: 'success'});
                                }
                            });
                    }
                    else {
                        res.status(500).json({error: 'not rated yet'});
                    }
                }
            });
        }
    });
});

app.get('/myratings', function (req, res) {
    //authorization
    var token = req.headers['authorization'];

    jwt.verify(token, app.get('private-key'), function (err, decoded) {
        if (err) {
            res.status(403).json({error: 'not logged in!'});
        }
        else {
            var username = decoded.username;

            ratingsModel.find({username: username},'-_id -__v', function (err, results) {
                if (err) {
                    return res.send(500, {error: err});
                }
                else {
                    res.status(200).json(results);
                }
            });
        }
    });
});

function round(value, step) {
    if(value > 5){
        return 5;
    } else if(value < 0) {
        return 0;
    }

    step || (step = 1.0);
    var inv = 1.0 / step;
    return Math.round(value * inv) / inv;
}

module.exports = app;