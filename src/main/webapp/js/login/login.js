/**
 * Created by jarry on 2017/5/4.
 */
function login() {
    var username = $('#username').val();
    var password = $('#password').val();
//如果不转成json格式的字符串，也是接收不到的
    var data = JSON.stringify({'username':username,'password':password});
    $.ajax({
        url: "/ssm/login",
        type: 'POST',
        data : data,
        contentType:'application/json;charset=utf-8',
        /*data : {
            username : $('#username').val(),
            password : $('#password').val()
        },*/
        dataType:"json",
        success:function (data) {
            alert("成功1");
            alert(data.username);
        },
        error : function () {
            alert("失败1");
        }
    });
}


function login2() {
    var saveDataAry=[];
    var data1={"username":"test","password":"gz"};
    var data2={"username":"ququ","password":"gr"};
    saveDataAry.push(data1);
    saveDataAry.push(data2);
    $.ajax({
        type:"POST",
        url:"/ssm/login",
        dataType:"json",
        contentType:"application/json",
        data:JSON.stringify(saveDataAry),
        success:function (data) {
            alert("成功2");
        },
        error : function () {
            alert("失败2");
        }
    });
}

