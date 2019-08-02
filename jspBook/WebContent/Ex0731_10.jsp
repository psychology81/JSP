<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
</head>
<body>
	<%!
	String greeting = "THIS IS THE HOME I MADE";
	String tagline = "I WELCOME YOU TO MY WORLD";	
	%>
	<nav class="navbar navbar-expand navbar-dark bg-dark">
	 	<div class ="contrainer"> 
	 		<div class="navbar-header">
	 		   <a class="navbar-brand" href="./Ex0731_9.jsp">HOME</a>
	 		</div>
	 	</div>
	 </nav>
	<div class="jumbotron">
	  <div class="container">
	    <h1 class="display-3"><%= greeting %></h1>
	  </div>
	</div>
	
	<div class ="container">
	  <div class = "text-center">
	    <h3 class="display-3"><%= tagline %></h3>
	  </div>
	</div>
	<BR><BR>
	
	
	<BR><BR>
	
	
	
	<footer class = "container">
		<p>&copy; WenMarket</p>
	</footer>



</body>
</html>