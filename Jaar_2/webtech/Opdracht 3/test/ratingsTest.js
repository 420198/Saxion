var supertest = require('supertest');
var should = require('should');
var server = supertest.agent("http://localhost:3000");
var token;

describe("Add a rating", function () {
    before(function (done) {
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

    it("should add a rating", function (done) {
        server.post("/ratings/add")
            .set({"authorization": token})
            .send({"ratingNumber": 3.5, "imdbTtNumber": 2})
            .expect("Content-type", /json/)
            .expect(200)
            .end(function (err, res) {
                should(res.body.status).be.a.String("success");
                done(err);
            });
    });

    it("should not add a rating without authorization", function (done) {
        server.post("/ratings/add")
            .set({"authorization": 'blabla'})
            .send({"ratingNumber": 3.5, "imdbTtNumber": 2})
            .expect("Content-type", /json/)
            .expect(403)
            .end(function (err, res) {
                should(res.body.error).be.a.String("not logged in!");
                done(err);
            });
    });
});

describe("Get my ratings", function () {
    it("should get a users own ratings", function (done) {
        server.get("/ratings/myratings")
            .set({"authorization": token})
            .expect("Content-type", /json/)
            .expect(200)
            .end(function (err, res) {
                done(err);
            });
    });
});

describe("Update a rating", function () {
    it("should update my own rating", function (done) {
        server.put("/ratings/update")
            .send({"ratingNumber" : 2, "imdbTtNumber" : 2})
            .set({"authorization": token})
            .expect("Content-type", /json/)
            .expect(200)
            .end(function (err, res) {
                done(err);
            });
    });
});