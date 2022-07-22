<%@ page import="hello.servlet.mvcbasic.domain.member.Member" %><%--
  Created by IntelliJ IDEA.
  User: parksungbum
  Date: 2022/07/21
  Time: 1:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
%>
<html>
<head>
  <title>Title</title>
</head>
<body>
성공
<ul>
<%--  <li>id=<%=((Member)request.getAttribute("member")).getId()%></li>--%>
<%--  <li>username=<%=((Member)request.getAttribute("member")).getUsername()%></li>--%>
<%--  <li>age=<%=((Member)request.getAttribute("member")).getAge()%></li>--%>
  <li>id=${member.id}</li>
  <li>username=${member.username}</li>
  <li>age=${member.age}</li>
</ul>
<a href="/index.html">메인</a>
<form action="new-form" method="get">
  <button type="submit">form</button>
</form>
</body>
</html>