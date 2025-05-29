<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Registration Application System</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
 <div class="form-container">
<form action="letsgo" method="post">
<center style="font-size:18px;">
	<h1>Login Page</h1>
	<table>
		<tr>
			<td>Name: </td>
			<td><input type="text" name="username" placeholder="Enter your name" autocomplete="off" autofocus></td>
		</tr>
		<tr>
			<td>Password: </td>
			<td><input type="password" name="userpassword" placeholder="Enter your Password" autocomplete="off"></td>
		</tr>
		<tr>
			<td>E-mail ID: </td>
			<td><input type="text" name="usermail" placeholder="Enter your e-mail id" autocomplete="off"></td>
		</tr>
		<tr>
			<td>course: </td>
			<td>
			<select name="usercourse">
			<option value="dataAnalysis">dataAnalysis</option>
			<option value="dataScientist">dataScientist</option>
			<option value="javaDeveloper">javaDeveloper</option>
			</select>
			</td>
		</tr>
		<td><td><button type="submit" style="padding:9px 18px; border-radius:10px; font-size:15px; margin-top:18px">Register Here</button></td></td>
	</table>
	<br/> 
<a href="readServlet" style="color: #fff; text-decoration: none; display:block; left-margin:10px;"><span style="font-size: 2.5rem; margin-right:1rem;">&#128073;</span>View Employees</a> 
</center>
</form>
</div>

</body>
</html>