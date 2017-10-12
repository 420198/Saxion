$(function () {
    var token = localStorage.getItem('token');
    var $ratings = $('#ratings');
    var $body = $('body');

    $.ajax({
        type: 'GET',
        beforeSend: function (request) {
            request.setRequestHeader("authorization", token);
        },
        url: '/ratings/myratings',
        success: function (ratings) {
            $.each(ratings, function (i, ratings) { //index item

                var imdbTtNumber = ratings.imdbTtNumber;

                $.ajax({
                    type: 'GET',
                    url: '/movies/id?id=' + imdbTtNumber,
                    success: function (movie) {
                        movie = movie[0];

                        $ratings.append(
                            '<div class="col-md-4">' +
                            '<h3>' + movie.title + '</h3>' +
                            '<a href="/movie.html?id=' + imdbTtNumber + '">' +
                            '<img src="images/movies/movie%20(' + movie.imdbTtNumber + ').jpg" class="img-responsive img-rounded"/>' +
                            '<span class="text-red">Rated ' + ratings.ratingNumber + ' out of 5</span>' +
                            '</a>' +
                            '</div>'
                        );
                    }
                });


            });
        }
    });
});