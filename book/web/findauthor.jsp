<%@ page import="com.book.Author" %>
<%@ page import="com.book.Book" %>
<%@ page import="java.util.ArrayList" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: forandroid
  Date: 16-9-27
  Time: 下午11:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style>
        body{TEXT-ALIGN: center;}
        table {
            margin-right: auto;
            margin-left: auto;
        }
    </style>
    <title>作者的大作在此</title>
    <link href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

    <!-- HTML5 Shim 和 Respond.js 用于让 IE8 支持 HTML5元素和媒体查询 -->
    <!-- 注意： 如果通过 file://  引入 Respond.js 文件，则该文件无法起效果 -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<table>
    <%
        Author Values=(Author) session.getAttribute("author");
    %>
    <tr>
        <td>作者信息</td>
    </tr>
    <tr>
        <td><%=Values.name %></td>
        <td><%=Values.age %>岁</td>
        <td><%=Values.country %></td>
    </tr>
</table>
<HR style="FILTER: alpha(opacity=100,finishopacity=0,style=2)" width="80%" color=#987cb9 SIZE=10>
<div class="center-block">
<table border = "1">
    <tr>
        <td>书名</td>
        <td>ISBN</td>
        <td>出版日期</td>
        <td>出版社</td>
        <td>价格</td>
    </tr>
    <%
        int num = 1;
        for(Book book:(ArrayList<Book>) session.getAttribute("author_list")) {
    %>
    <tr>
        <td><a href="#" onclick="hide_or_show(<%=num%>)"><%= book.title%></a></td>
        <td id="ISBN<%=num%>" style="visibility:hidden" > <%= book.ISBN%></td>
        <td id="publish_date<%=num%>" style="visibility:hidden" > <%= book.publish_date%></td>
        <td id="publisher<%=num%>" style="visibility:hidden" > <%= book.publisher%></td>
        <td id="price<%=num%>" style="visibility:hidden" > <%= book.price%></td>
    </tr>
    <%
       num++;
        }
    %>
</table>
    <a href="/index.jsp">返回首页~</a>
</body>
<script>
    function hide_or_show_single(single) {
        if(single.style.visibility=="hidden") single.style.visibility="visible";
        else single.style.visibility="hidden";
    }

    function hide_or_show (num) {
        ISBN = document.getElementById("ISBN"+num);
        hide_or_show_single(ISBN);
        publish_date = document.getElementById("publish_date"+num);
        hide_or_show_single(publish_date);
        publisher = document.getElementById("publisher"+num);
        hide_or_show_single(publisher);
        price = document.getElementById("price"+num);
        hide_or_show_single(price);
    }
</script>
</html>
