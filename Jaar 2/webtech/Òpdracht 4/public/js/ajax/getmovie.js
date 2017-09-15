$(function(){
    var $title = $('#title');
    var $director = $('#director');
    var $description = $('#description');
    var $image = $('#imagediv');

    var token = localStorage.getItem('token');

    var id = $.urlParam('id'); // id
    console.log(id);

    $.ajax({ //get movie info
        type: 'GET',
        url: '/movies/id?id=' + id,
        success: function(movie){
            console.log(movie);
            movie = movie[0];
            console.log(movie);
            console.log(movie.title);
            $title.text(movie.title);
            $director.text(movie.director);
            $description.text(movie.description);
            $title.text(movie.title);
            $image.html('<img id="image" src="images/movies/movie%20(' + movie.imdbTtNumber + ').jpg" class="img-responsive img-rounded">')

            if(token != 'undefined'){
                $.ajax({
                    type: 'GET',
                    url: '/ratings/get?id=' + movie.imdbTtNumber,
                    beforeSend: function (request) {
                        request.setRequestHeader("authorization", token);
                    },
                    success: function(rating){
                        var ratingNumber = $('#ratingNumber');

                        var totalRating = 0;
                        var totalAmountOfRatings = 0;

                        $.each(rating, function (i, rating) { //index item
                            totalRating += rating.ratingNumber;
                            totalAmountOfRatings += 1;
                        });

                        if(totalRating != 0) {
                            ratingNumber.html(totalRating / totalAmountOfRatings);
                        }
                        else {
                            var ratingParagraph = $('#ratingParagraph');
                            ratingParagraph.html('This movie has not been rated');
                        }
                    },
                    error: function() {
                        var ratingParagraph = $('#ratingParagraph');
                        ratingParagraph.html('');
                    }
                });
            }
        },
        error: function() { //film bestaat niet!
            alert("This movie doesn't exist in our database!");
            window.location.href = "/index.html";
        }
    });
});

$.urlParam = function(name){
    var results = new RegExp('[\?&]' + name + '=([^&#]*)').exec(window.location.href);
    if (results==null){
        return null;
    }
    else{
        return results[1] || 0;
    }
};