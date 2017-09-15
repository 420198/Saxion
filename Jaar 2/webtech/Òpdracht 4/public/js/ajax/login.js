$( "#loginform" ).submit(function(e) {
    e.preventDefault(); //stop de redirect
    var username = $("#username").val();
    var password = $("#password").val();

    $.ajax({
        type: 'POST',
        data: JSON.stringify({username: username, password: password}),
        url: '/users/login',
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        success: function (data) {
            localStorage.setItem('token', data.token);
            window.location.href = "/index.html";
        },
        error: function () {
            alert('Authentication failed');

            var formPassword = $(".form-password");
            var formUsername = $(".form-username");

            formPassword.addClass("has-error");
            formUsername.addClass("has-error");
        }
    });
});