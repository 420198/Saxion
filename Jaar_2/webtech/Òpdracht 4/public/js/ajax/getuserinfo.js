$(function(){
    var token = localStorage.getItem('token');
    $.ajax({ //get movie info
        type: 'GET',
        beforeSend: function (request) {
            request.setRequestHeader("authorization", token);
        },
        data: JSON.stringify({token: token}),
        url: '/users/getcurrentuser',
        success: function(userinfo){
            console.log(userinfo);

            $.ajax({
                type: 'GET',
                beforeSend: function (request) {
                    request.setRequestHeader("authorization", token);
                },
                url: '/users/getuser?username=' + userinfo.username,
                success: function(user){
                    user = user[0];
                    $('#headerUsername').html(user.username + " <span class=\"glyphicon glyphicon-user\"></span>");
                    $('#firstname').html(user.firstname);
                    $('#lastname').html(user.lastname);
                    $('#lastnamePrefix').html(user.lastnamePrefix);
                }
            });
        },
        error: function () {
            window.location.href = "/login.html";
        }
    });
});