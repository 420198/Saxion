$( "#registerform" ).submit(function(e) {
    e.preventDefault(); //stop de redirect
    var username = $("#username").val();
    var password = $("#password").val();
    var lastname = $("#lastname").val();
    var lastnameprefix = $("#lastnameprefix").val();
    var firstname = $("#firstname").val();

    $.ajax({
        type: 'POST',
        data: JSON.stringify({
                username: username,
                password: password,
                lastname: lastname,
                lastnamePrefix: lastnameprefix,
                firstname: firstname
            }),
        url: '/users/register',
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        success: function () {
            window.location.href = "/login.html";
        },
        error: function () {
            alert('Registration failed! Please check all fields and try again!');
        }
    });
});