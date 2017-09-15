var supertest = require('supertest');
var server = supertest.agent("http://localhost:3000");

describe("Fill the database", function () {
    it("should add movies to the database", function (done) {
        server.get("/filldatabase")
            .expect("Content-type", /json/)
            .expect(200)
            .end(function (err, res) {
                done(err);
            });
    });
});

describe("Get single movie", function () {
    it("should return a single movie", function (done) {
        server.get("/movies/moviewithid?id=1")
            .expect("Content-type", /json/)
            .expect(200)
            .end(function (err, res) {
                done(err);
            });
    });

    it("should not return a movie cause the id doesn't exist", function (done) {
        server.get("/movies/moviewithid?id=30")
            .expect("Content-type", /json/)
            .expect(400)
            .end(function (err, res) {
                done(err);
            });
    });
});

describe("All movies", function () {
    it("should return all movies", function (done) {
        server.get("/movies/allmovies")
            .expect("Content-type", /json/)
            .expect(200)
            .end(function (err, res) {
                done(err);
            });
    });
});