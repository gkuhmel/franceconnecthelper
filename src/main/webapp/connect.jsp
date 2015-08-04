<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
 String redirect = (String)request.getAttribute("redirect");
%>
<h1>France Connect - Connexion Test</h1>
<a href="<%=redirect%>">Login</a>
<br/>
<a href="https://fcp.integ01.dev-franceconnect.fr/api/v1/logout">Logout</a>

