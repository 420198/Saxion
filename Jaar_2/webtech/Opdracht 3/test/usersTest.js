var supertest = require('supertest');
var should = require('should');
var server = supertest.agent("http://localhost:3000");
var token;

describe("Register the user", function () {

    it("should register a user", function (done) {
        server.post("/users/register")
            .send({
                "username" : "frankgr",
                "password" : "test",
                "firstname" : "frank",
                "lastnamePrefix" : "",
                "lastname" : "grevelink"
            })
            .expect("Content-type", /json/)
            .expect(200)
            .end(function (err, res) {
                done(err);
            });
    });

    it("should not register a user with the same username and give status 500", function (done) {
        server.post("/users/register")
            .send({
                "username": "frankgr",
                "password": "test",
                "firstname": "frank",
                "lastnamePrefix": "",
                "lastname": "grevelink"
            })
            .expect("Content-type", /json/)
            .expect(500)
            .end(function (err, res) {
                done(err);
            });
    });
});

describe("Get token to authorize", function () {
    it("should log in and get a token", function (done) {
        server.post("/users/login")
            .send({"username": "frankgr", "password": "test"})
            .expect("Content-type", /json/)
            .expect(200)
            .end(function (err, res) {
                token = res.body.token;
                should(token).be.a.String();
                done(err);
            });
    });
});

describe("Get users", function () {
    it("should get a list of users", function (done) {
        server.get("/users/getusers")
            .set({"authorization": token})
            .expect("Content-type", /json/)
            .expect(200)
            .end(function (err, res) {
                done(err);
            });
    });

    it("should give an error without proper authorization", function (done) {
        server.get("/users/getusers")
            .set({"authorization": "bla"})
            .expect("Content-type", /json/)
            .expect(403)
            .end(function (err, res) {
                done(err);
            });
    });

    it("should get a single user", function (done) {
        server.get("/users/getuser?username=frankgr")
            .set({"authorization": token})
            .expect("Content-type", /json/)
            .expect(200)
            .end(function (err, res) {
                done(err);
            });
    });

    it("should give an error without proper authorization", function (done) {
        server.get("/users/getuser?username=frankgr")
            .set({"authorization": "bla"})
            .expect("Content-type", /json/)
            .expect(403)
            .end(function (err, res) {
                done(err);
            });
    });

    it("should give an error without a username argument", function (done) {
        server.get("/users/getuser")
            .set({"authorization": token})
            .expect("Content-type", /json/)
            .expect(500)
            .end(function (err, res) {
                should(res.body.error).be.a.String("invalid request");
                done(err);
            });
    });

});