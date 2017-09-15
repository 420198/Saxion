$("#submitrating").submit(function (e) {
    e.preventDefault(); //stop de redirect
    var token = localStorage.getItem('token');
    var id = $.urlParam('id'); // id
    var formData = $('#submitrating').serializeArray();
    var newRating = formData[0].value;

    $.ajax({
        type: 'GET',
        beforeSend: function (request) {
            request.setRequestHeader("authorization", token);
        },
        url: '/ratings/myrating?id=' + id,
        contentType: "application/json; charset=utf-8",
        success: function () {
            //rating, put!
            console.log("PUT!");
            $.ajax({
                type: 'PUT',
                data: JSON.stringify({
                    ratingNumber: newRating,
                    imdbTtNumber: id
                }),
                beforeSend: function (request) {
                    request.setRequestHeader("authorization", token);
                },
                url: '/ratings/update',
                contentType: "application/json; charset=utf-8",
                success: function (data) {
                    console.log(data);
                    $("#movieContainer").append('<p class="text-white">Rating updated!</p>')
                }
            });
        },
        error: function () {
            //rating, post!
            console.log("POST!");
            $.ajax({
                type: 'POST',
                data: JSON.stringify({
                    ratingNumber: newRating,
                    imdbTtNumber: id
                }),
                beforeSend: function (request) {
                    request.setRequestHeader("authorization", token);
                },
                url: '/ratings/add',
                contentType: "application/json; charset=utf-8",
                success: function () {
                    $("#movieContainer").append('<p class="text-white">Rating updated!</p>')
                }
            })
        }
    });
});
