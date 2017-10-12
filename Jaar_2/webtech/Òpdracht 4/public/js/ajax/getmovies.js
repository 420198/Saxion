$(function(){
    var $movies = $('#movies');

    $.ajax({
        type: 'GET',
        url: '/movies/allmovies',
        success: function(movies){
            var totalAmountOfMovies = 0;
            $.each(movies, function(i, movie){ //index item
                totalAmountOfMovies++;
                $movies.append('<a href="/movie.html?id=' + movie.imdbTtNumber + '" class="movie-link"><img src="images/movies/movie%20(' + movie.imdbTtNumber + ').jpg" </a>')
            });

            $movies.width(366 * totalAmountOfMovies);
        }
    });
});