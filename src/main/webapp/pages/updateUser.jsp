<%@page import="com.model.UserDetails"%>
<%@page import="com.model.City"%>
<%@page import="com.model.State"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update User</title>

</head>
<%
ArrayList<State> states = (ArrayList<State>) request.getAttribute("states");
ArrayList<City> cities = (ArrayList<City>) request.getAttribute("cities");
UserDetails userDetails = (UserDetails) request.getAttribute("userdetails");
%>


<body>

	<h1>REGISTRATION</h1>

	<form action="updateUser">
		<input type="hidden" name="id" value="<%=userDetails.getId()%>">

		First name: <input type="text" name="firstname"
			value="<%=userDetails.getFirstName()%>"> <br> <br>

		Last Name: <input type="text" name="lastname"
			value="<%=userDetails.getLastName()%>"> <br> <br>

		Address: <input type="text" name="address"
			value="<%=userDetails.getAddress()%>"> <br> <br>

		Contact: <input type="text" name="contact"
			value="<%=userDetails.getContact()%>"> <br> <br>

		Gender:
		<%
 if (userDetails.getGender().equals("male")) {
 %>
		<input type="radio" name="gender" value="male" checked>Male <input
			type="radio" name="gender" value="female">Female
		<%
		} else {
		%>
		<input type="radio" name="gender" value="male">Male <input
			type="radio" name="gender" value="female" checked>Female
		<%
		}
		%>

		<br> <br> State: <select name="stateid" id="state">
			<option value="0">Select State</option>
			<%
			for (State state : states) {
			%>
			<option value="<%=state.getId()%>" <%= state.getId() == userDetails.getStateId() ? "selected":""%>>
				<%=state.getName()%>
			</option>
			<%
			}
			%>
			
		</select> <br> <br> City: <select name="cityid" id="city">
			<option value="0">Select City</option>
			<%
			for (City city : cities) {
			%>
			<option value="<%=city.getId()%>" <%= city.getId() == userDetails.getCityId() ? "selected":""%>><%=city.getName()%></option>
			<%
			}
			%>

		</select> <br> <br> Email: <input type="email" name="email"
			value="<%=userDetails.getEmail()%>"> <br> <br> 
			
			DOB:
		<input type="date" name="dob" value="<%=userDetails.getDob() %>"> <br> <br> 
		
		Is Admin:
		<%
 if (userDetails.getIsAdmin() == 0) {
 %><input type="radio" name="isadmin" value="1">Yes <input
			type="radio" name="isadmin" value="0" checked>No
		<%
 } else {
 %>
		<input type="radio" name="isadmin" value="1" checked>Yes <input
			type="radio" name="isadmin" value="0">No
		<%
		}
		%>
		<br> <br>

		<!--  User ID: <input type="text" name="userid"> <br> <br>

		Password: <input type="password" name="password"> <br> <br> -->
		<input type="submit" value="Update">  
	</form>
</body>
</html>