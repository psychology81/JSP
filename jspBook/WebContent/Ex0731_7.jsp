<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
	table {border-collapse : collapse;}	
	
</style>
</head>
<body>
	 
   <table border = '1'>
   <tr>
   <% for(int i = 1; i < 10; i++) {  %>
             <% for(int j = 1; j < 10; j++ ) {    %>
                 <%  out.print("<td>");
               out.print(i + "*" + j + "=" + (i*j) );
               out.print("</td>");
            }
            out.print("</tr>"); 
  
   }
   %>


   </table>
   
    <br><br> <br> -------------구분선--------<br><br><br>
   
   <table border = '1'>
   	<% for (int i = 1; i <= 9; i++ ) {
   		out.print("<tr>");
   		for(int j = 1; j <= 9; j++) {
   			out.print("<td>");
   			out.print(i + "*" + j + "=" + (i*j));
   			out.print("</td>");
   		}
   		out.print("</tr>");
     	}
   	%>
   </table>
     <br><br><br> -------------구분선--------<br><br><br>










</body>
</html>

