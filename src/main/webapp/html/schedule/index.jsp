<%--
  Created by IntelliJ IDEA.
  User: jarry
  Date: 2017/6/26
  Time: 9:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>定时任务管理界面</title>
    <style>
        table.show {
            font-family: Verdana,arial,sans-serif;
            font-size: 11px;
            color: #333333;
            border-collapse: collapse;
            border: 1px;
        }

        table.show th{
            border-width: 1px;
            padding: 8px;
            border-style:solid;
            border-color: #999999;

        }

        table.show td{
            border-width: 1px;
            padding: 8px;
            border-style: solid;
            border-color: #999999;
        }

    </style>
    <script src="../js/jquery-3.2.1.min.js"></script>
    <script src="../js/schedule/schedule.js"></script>
</head>
<body>

    <div>
        触发器名称：<input type="text" name="query_triggerName" id="query_triggerName"/>
        触发器代码：<input type="text" name="query_triggerCode" id="query_triggerCode"/>
        状态:<select name="query_status" id="query_status">
                <option value="0">开启</option>
                <option value="1">关闭</option>
            </select>
        <input type="button" name="查询" value="查询按钮" onclick="query()" />
    </div>

    <table id="show">
        <thead>
            <th><input type="checkbox" id="checkAll" onclick="checkAll(this)"/></th>
            <th>触发器名称</th>
            <th>触发器代码</th>
            <th>表达式</th>
            <th>状态</th>
            <th>创建时间</th>
            <th>更新时间</th>
        </thead>
        <tbody id="trigger">

        </tbody>

    </table>
</body>
</html>
