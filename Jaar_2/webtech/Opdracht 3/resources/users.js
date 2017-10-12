var express = require("express");
var app = express();

var jwt = require('jsonwebtoken');
app.set('private-key', 'alwaysLookOnTheBrightSideOfLifeTuduTudutudutudu');

var mongoose = require('mongoose');
var usersModel = require('../model/usersModel.js');

app.post('/register', function (req, res) {
    var userName        = req.body.username;
    var password        = req.body.password;
    var firstname       = req.body.firstname;
    var lastnamePrefix  = req.body.lastnamePrefix;
    var lastname        = req.body.lastname;

    var newUser = new usersModel({
        username: userName,
        password: password,
        firstname: firstname,
        lastnamePrefix: lastnamePrefix,
        lastname: lastname
    });

    newUser.save(function (err, result) {
        if (err) {
            res.status(500).json({'error': err.message});
        }
        else {
            res.status(200).json({status: 'registered successfully'});
        }

    });
});

app.post('/login', function (req, res) {
    var username = req.body.username;
    var password = req.body.password;

    usersModel.find({username: username}, '-__v -username -firstname -lastnamePrefix -lastname' , function (err, results){
        if(err) {
            res.status(500).json({error: err.message});
        }

        //json omgooien naar object
        var jsonArray = JSON.parse(JSON.stringify(results));

        if(results == ""){
            res.status(401).json({error: 'username or password incorrect'});
        }
        else {
            if (password == jsonArray[0].password) { //passwords komen overeen

                var profile = {
                    username: username,
                    _id: jsonArray[0]._id
                };

                var token = jwt.sign(profile, app.get('private-key'), {
                    expiresIn: '1440m' // expires in 24 hours
                });

                res.status(200).json({token: token});
            } else {
                res.status(401).json({error: 'username or password incorrect'});
            }
        }
    });
});

app.get('/getusers', function (req, res) {
    var token = req.headers['authorization'];

    jwt.verify(token, app.get('private-key'), function(err, decoded) {
        if(err){
            res.status(403).json({error : 'not logged in!'});
        }
        else {
            usersModel.find({}, '-_id -password -username -__v', function (err, results) {
                if (err) {
                    res.status(500).json({'error': 'no users found'});
                }

                res.status(200).json(results);
            });
        }
    });
});

app.get('/getuser', function (req, res) {
    var token = req.headers['authorization'];

    jwt.verify(token, app.get('private-key'), function(err, decoded) {
        if(err){
            res.status(403).json({error : 'not logged in!'});
        }
        else {

            var username = req.query.username;
            if (username == null) {
                res.status(500).json({error: 'invalid request'});
            }
            else {
                usersModel.find({username: username}, '-_id -__v -password', function (err, result) {
                    if (err) {
                        res.status(500).json({error: 'internal server error'});
                    } else {
                        console.log(result);
                        console.log("BAAA");
                        res.status(200).json(result);
                    }
                });
            }
        }
    })
});

module.exports = app;