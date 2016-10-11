<%--
  Created by IntelliJ IDEA.
  User: forandroid
  Date: 16-9-27
  Time: 下午5:42
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <style>
      body{TEXT-ALIGN: center;}
    </style>
    <title>图书管理系统</title>
    <link href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

    <!-- HTML5 Shim 和 Respond.js 用于让 IE8 支持 HTML5元素和媒体查询 -->
    <!-- 注意： 如果通过 file://  引入 Respond.js 文件，则该文件无法起效果 -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
  </head>
  <body>
    <div class="center-block">
      <H1> 欢迎来到历史上最次的图书管理系统 </H1>
      <hr>
      <form action="search" method="post">
        您希望查询那个作者的图书? <br>
        <input name="author_name" type="text"><br>
        <input type="submit" value="查询呐~o~">
      </form>

    <HR style="FILTER: alpha(opacity=100,finishopacity=0,style=2)" width="80%" color=#987cb9 SIZE=10>
    <form action="add_book" method="post">
      您希望增加图书吗? <br>
      ISBN码是? <input name="ISBN" type="text"><br>
      书名是?   <input name="title" type="text"><br>
      作者是?   <input name="author_name" type="text"><br>
      出版日期?  <input name="publish_date" type="text"><br>
      出版社?    <input name="publisher" type="text"><br>
      价格?     <input name="price" type="text"><br>
      <input type="submit" value="增加喽^_^">
    </form>

      <HR style="FILTER: alpha(opacity=100,finishopacity=0,style=2)" width="80%" color=#987cb9 SIZE=10>
      <form action="add_author" method="post">
        您希望增加作者吗? <br>
        大名是?   <input name="name" type="text"><br>
        年龄?    <input name="age" type="text"><br>
        国家?     <input name="country" type="text"><br>
        <input type="submit" value="增加喽^_^">
      </form>

    <HR style="FILTER: alpha(opacity=100,finishopacity=0,style=2)" width="80%" color=#987cb9 SIZE=10>
    <form action="update" method="post">
      您希望更新图书吗? <br>
      书名是?    <input name="title" type="text"><br>
      请选填您要更新的项目<br>
      ISBN码是?    <input name="ISBN" type="text"><br>
      作者是?    <input name="Author_name" type="text"><br>
      出版日期?   <input name="publish_date" type="text"><br>
      出版社?    <input name="publisher" type="text"><br>
      价格?      <input name="price" type="text"><br>
      <input type="submit" value="更新啦@_@">
    </form>
      <form action="delete" method="post">
        您希望删除图书吗? <br>
        名字是?    <input name="title" type="text"><br>
        <input type="submit" value="删除啦T_T">
      </form>
  </div>
  </body>
</html>
