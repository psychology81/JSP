
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
	<h1>게시판 글쓰기 </h1>
	<form method='post' action='./writeokok.jsp'>
	
	
	<table border='1'>
		<tr>
		   <td width='100px'>제목</td> 
		   <td width='400px'><input type='text' name='b_subject' size='40'></td>
		</tr>
	
		<tr>
		   <td width='100px'>이름</td> 
		   <td width='400px'><input type='text' name='b_name'></td>
		</tr>
	
		<tr>
			<td width='100px'>통신사</td>
			<td width='400px'>
		      <input type='radio' name='phone' value='SKT' checked>SKT 
			  <input type='radio' name='phone' value='KT'>	KT 
		      <input type='radio' name='phone' value='LG'>LG 
			</td>
		</tr>

			
		<tr>
			<td width='100px'>지역</td>
			<td width='400px'> 
			  <select name='city'>
			  <optgroup label="지역">
			  	<option value="충북"selected>충북</option>
			  	<option value="경기">경기</option>
			  	<option value="서울">서울</option>
			  </optgroup>
			  </select>
	
	
	    <tr>
		   <td width='100px'>이름</td> 
		   <td width='400px'><textarea rows='15' cols='40' name='b_contents'></textarea></td>		  
		</tr>
		
		<tr>
		   <td colspan='2'><input type='submit'></td>
		</tr>
		
	</table>
		</form>
	
</body>
</html>
</body>
</html>