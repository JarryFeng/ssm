/**
 * Created by jarry on 2017/6/26.
 */
//全选or不全选
function checkAll(obj) {

    if(!obj.checked) {
        $('input[name=cb]').each(function (i) {
            this.checked = false;
        });
    }else {
        $('input[name=cb]').each(function (i) {
            this.checked = true;
        });
    }
}

function query() {

    var data = {};
    data.triggerName = $('#query_triggerName').val();
    data.triggerCode = $('#query_triggerCode').val();
    data.status = $('#query_status').val();
    $.ajax({
        url: "/ssm/schedule/query",
        type: 'POST',
        contentType:'application/json;charset=utf-8',
        data : JSON.stringify(data),
        dataType:"json",
        success:function (data) {
            var str = "";
            $.each(data, function(i, item) {
                str += "<tr>" +
                    "<td><input type='checkbox' class='checkbox' name='cb' value='" + item.id + "' /></td>" +
                    "<td>" + item.triggerName    + "</td>" +
                    "<td>" + item.triggerCode + "</td>" +
                    "<td>" + item.cronExpresion + "</td>" +
                    "<td>" + item.status + "</td>" +
                    "<td>" + item.createdate + "</td>" +
                    "<td>" + item.updatedate + "</td></tr>";
            });
            //先清空内容，后填充
            $("#trigger").empty();
            $("#trigger").append(str);
        },
        error : function () {
            alert("失败1");
        }
    });
}