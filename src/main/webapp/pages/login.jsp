
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.connection.ConnectionProvider"%>
<%@page import="com.controller.CityController"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
	<h1>LOGIN</h1>
	<form action="login">
		<table>
			<tr>
				<td>Login:</td>
				<td><input type="text" name="username"></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type="password" name="password"></td>

			</tr>


		</table>
		<input type="submit" value="Login"> <a href="register">Register</a>
	</form>
	
	
<br><br>
<a href="pages/testError.jsp">Test Error</a>



	<%-- DriverManager.getConnection("jdbc:mysql://localhost:3306/maximus", "root", "root"); --%>

	<%--
ApmCityController apmCityController = new ApmCityController();
int result = apmCityController.addCity();
if(result == 1)
	{
		System.out.println("City data saved");	
		out.println("City data saved <br>");
	}
	else
	{
		System.out.println("City details failed to save");
		out.println("City details failed to save <br>");
	}				


	//ApmCityController apmCityController2 = new ApmCityController();
	//apmCityController2.showAllCities();
--%>


</body>
</html>