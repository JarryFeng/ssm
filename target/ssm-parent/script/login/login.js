/**
 * Created by jarry on 2017/5/4.
 */

function login() {
    $.ajax({
        url: "login",
        contextType:"application/json;charset=UTF-8",
        type: 'POST',
        data : {
            username : $('#username').val(),
            password : $('#password').val()
        },
        dataType : 'json',
        success:function (data) {
            alert("成功");
            alert(data.username);

        },
        error : function () {
            alert("失败");
        }

    });
}

