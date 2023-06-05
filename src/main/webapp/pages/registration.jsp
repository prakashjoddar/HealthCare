<%@page import="com.model.City"%>
<%@page import="com.model.State"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration</title>

</head>
<%
ArrayList<State> states = (ArrayList<State>) request.getAttribute("states");
ArrayList<City> cities = (ArrayList<City>) request.getAttribute("cities");
%>


<body>

	<h1>REGISTRATION</h1>

	<form action="user-register">
		First name: <input type="text" name="firstname"> <br> <br>
		Last Name: <input type="text" name="lastname"> <br> <br>
		Address: <input type="text" name="address"> <br> <br>
		Contact: <input type="text" name="contact"> <br> <br>
		Gender: <input type="radio" name="gender" value="male" checked>Male
		<input type="radio" name="gender" value="female">Female <br>
		<br> State: <select name="stateid" id="state">
			<option value="0">Select State</option>
			<%
			for (State state : states) {
			%>
			<option value="<%=state.getId()%>">
				<%=state.getName()%>
			</option>
			<%
			}
			%>
			<!-- <option value="1">Maharashtra</option>
			<option value="2">MP</option>
			<option value="3">UP</option>
			<option value="4">Goa</option>  -->
		</select> <br> <br> City: <select name="cityid" id="city">
			<option value="0">Select City</option>
			<%
			for (City city : cities) {
			%>
			<option value="<%=city.getId()%>"><%=city.getName()%></option>
			<%
			}
			%>

			<!-- <option value="1">Nagpur</option>
			<option value="2">Pune</option>
			<option value="3">Mumbai</option>
			<option value="4">Delhi</option>
			<option value="5">Punjab</option>  -->
		</select> <br> <br>Email: <input type="email" name="email"> <br>
		<br>DOB: <input type="date" name="dob"> <br> <br>
		Is Admin: <input type="radio" name="isadmin" value="yes">Yes <input
			type="radio" name="isadmin" value="no" checked>No <br> <br>
		User ID: <input type="text" name="userid"> <br> <br>
		Password: <input type="password" name="password"> <br> <br>
		<input type="submit" value="Register">
	</form>
</body>
</html>