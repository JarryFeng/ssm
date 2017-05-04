/**
 * Created by jarry on 2017/5/4.
 */

function login() {
    $.ajax({
        url: "/login",
        contextType:"application/json;charset=UTF-8",
        content : {
            username : $('#username').val(),
            password : $('#password').val()
        },
        success:function () {
            alert("成功");
        },
        error : function () {
            alert("失败");
        }

    });
}

