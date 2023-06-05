<%@page import="java.util.ArrayList"%>
<%@page import="com.model.UserDetails"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Users</title>
</head>
<body>
	<%
	ArrayList<UserDetails> usersList = (ArrayList<UserDetails>) request.getAttribute("userlist");
	%>

	<table>
		<tr>
			<td><h3>
					Welcome,
					<%=session.getAttribute("username")%></h3>
			<td>
			<td><a href="logout">Logout</a>
			<td>
		</tr>
		<tr>
			<td><input type="button" value="Add New User" onclick="window.location.href='register'; return false;"/></td>
		</tr>
	</table>

	<br>
	<br>


	<%
	if (usersList != null && usersList.size() > 0) {
	%>
	<table border="1"
		style="border: 1px solid black; border-collapse: collapse;">
		<thead>
			<tr>
				<th>ID</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Full Name</th>
				<th>Address</th>
				<th>Contact</th>
				<th>Gender</th>
				<th>State Id</th>
				<th>City Id</th>
				<th>Email</th>
				<th>DOB</th>
				<th>Reg_date</th>
				<th>Last_modified</th>
				<th>Is Admin</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<%
			for (UserDetails details : usersList) {
			%>
			<tr>
				<td><%=details.getId()%></td>
				<td><%=details.getFirstName()%></td>
				<td><%=details.getLastName()%></td>
				<td><%=details.getFullName()%></td>
				<td><%=details.getAddress()%></td>
				<td><%=details.getContact()%></td>
				<td><%=details.getGender()%></td>
				<td><%=details.getStateId()%></td>
				<td><%=details.getCityId()%></td>
				<td><%=details.getEmail()%></td>
				<td><%=details.getDob()%></td>
				<td><%=details.getRegDate()%></td>
				<td><%=details.getLastModified()%></td>
				<td><%=(details.getIsAdmin() == 0 ? "No" : "Yes")%></td>
				<td><a href="userDetails?id=<%=details.getId()%>">Edit</a> | <a
					href="Deactivate?id=<%=details.getId()%>">Deactivate</a> | <a
					href="DeleteUser?id=<%=details.getId()%>" onclick="if(!(confirm('Confirm Delete!'))) return false;">Delete</a></td>
			</tr>
			<%
			}
			%>
		</tbody>
	</table>
	<%
	} else {
	%>
	<h1>No users found</h1>
	<%
	}
	%>



	<br>
	<br>
</body>
</html>