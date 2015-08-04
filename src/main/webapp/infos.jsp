<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
 	String accessToken = (String)request.getAttribute("accessToken");
	String userInfo = (String)request.getAttribute("userInfo");
%>
<html>
	<head>
		<script type="text/javascript" src="/js/main.js"> </script>
		<LINK rel="stylesheet" type="text/css" href="/css/style.css">
	</head>
	<body>
		<h1>France Connect - Connexion Test - User Infos</h1>
		Token : <%= accessToken %>
		<br/>		
		<script type="text/javascript">
			var str = JSON.stringify(<%=userInfo%>, undefined, 4);
			output(syntaxHighlight(str));			
		</script>
	</body>
</html>


