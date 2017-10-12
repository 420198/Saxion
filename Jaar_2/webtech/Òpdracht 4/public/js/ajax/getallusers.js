$(function(){
    var token = localStorage.getItem('token');

    $.ajax({ //get movie info
        type: 'GET',
        beforeSend: function (request) {
            request.setRequestHeader("authorization", token);
        },
        data: JSON.stringify({token: token}),
        url: '/users/getusers',
        success: function(userinfo){
            console.log(userinfo);

            var friendsList = $("#friends-list");
            var body = $("body");

            userinfo.forEach(function loopje(item, i){
                friendsList.append(
                    '<div class="col-md-2 text-center">' +
                    '<a href="#friendModal' + i + '" data-toggle="modal" class="friends-item"> ' +
                    '<div class="text-center"> ' +
                    '<span class="glyphicon glyphicon-user"></span> <br>' +
                    item.firstname +
                    ' </div> ' +
                    '</a>' +
                    '</div>');

                body.append(
                    ' <div class="modal fade" id="friendModal' + i + '" tabindex="-1" role="dialog">' +
                    '<div class="modal-dialog" role="document">'+
                    '<div class="modal-content" style="background-color: #2c2c2c;">'+
                    '<div class="modal-header border-red">'+
                    '<button type="button" class="close" style="color: white;" data-dismiss="modal" aria-label="Close"><spanaria-hidden="true">&times;</span></button>'+
                '<h4 class="modal-title">Accountdetails</h4>'+
                    '</div>'+
                    '<div class="modal-body">'+
                    '<div class="container">'+
                    '<div class="row">'+
                    '<div class="col-md-12 text-white">'+
                    '<div class="col-md-2">'+
                    '<label>Name</label>'+
                    '</div>'+
                    '<div class="col-md-10 text-left" id="firstname">' + item.firstname + '</div>'+
                    '</div>'+
                    '<div class="col-md-12 text-white">'+
                    '<div class="col-md-2">'+
                    '<label>Lastname prefix</label>'+
                '</div>'+
                '<div class="col-md-10 text-left" id="lastnamePrefix">' + item.lastnamePrefix + '</div>'+
                    '</div>'+
                    '<div class="col-md-12 text-white">'+
                    '<div class="col-md-2">'+
                    '<label>Lastname</label>'+
                    '</div>'+
                    '<div class="col-md-10 text-left" id="lastname">' + item.lastname + '</div>'+
                    '</div>'+
                    '</div>'+
                    '</div>'+
                    '</div>'+
                    '<div class="modal-footer border-red">'+
                    '<button type="button" class="btn btn-red" data-dismiss="modal">Close</button>'+
                    '</div>'+
                    '</div><!-- /.modal-content -->'+
                '</div><!-- /.modal-dialog -->'+
                '</div><!-- /.modal -->');
            });
        },
        error: function () {
            window.location.href = "/login.html";
        }
    });
});