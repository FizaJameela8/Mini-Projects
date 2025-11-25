<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.user.dto.*"%>
<%@ page import="java.util.*"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home page</title>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Fleur+De+Leah&family=Molle&family=VT323&display=swap"
	rel="stylesheet">
<style>
body {
	margin: 0;
	height: auto;
	position: relative;
}

h1 {
	font-family: "Molle";
	font-weight: 100;
}

.bg {
	position: fixed;
	inset: 0;
	background-image:
		url("https://images.unsplash.com/photo-1599607789301-fd8892b7ecfb?ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&q=80&w=826");
	background-size: cover;
	background-repeat: no-repeat;
	filter: brightness(60%) blur(2px); /* darker + slight blur */
	z-index: -1;
}

.head {
	padding: 10px;
	margin-top: 0;
	display: block;
	background-color: #f07267;
	display: flex;
	flex-direction: row;
	justify-content: space-around;
}

.h1 {
	text-align: center;
	color: white;
	text-shadow: 2px 2px 5px black;
}

.list {
	border: 5px dashed red;
	border-radius: 20px 50px;
	background-image:
		url("https://plus.unsplash.com/premium_photo-1726399099927-f198294a02c6?ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&q=80&w=870");
	background-size: cover;
	height: 1000px;
	width: 85%;
	padding: 10px;
	padding-top: 70px;
	margin: 8%;
	box-shadow: 2px 2px 5px black, 2px 2px 5px black, 2px 2px 5px black, 2px
		2px 5px black;
	text-align: center;
}

.butterfly {
	position: absolute;
	top: 100px;
}

.girl {
	position: absolute;
	bottom: 0;
	right: 70px;
}

.container {
	height: 800px;
	width: 80%;
	padding: 20px;
	background-color: #4c49f5;
	align-self: center;
	justify-self: center;
		border: 3px dashed white;
}

.search {
	padding: 10px;
	margin-top: 20px;
	margin-left: 30px;
}

.in {
	display: inline;
	padding: 10px;
}

.searchbnt {
	background-color: red;
	color: white;
	text-shadow: 2px 2px 5px black;
	border-radius: 30px;
	font-family: "Molle";
	font-weight: 100;
	margin-left: 10px;
	text-align: center;
	box-shadow: 2px 2px 5px black;
	transition: background-color 0.2s ease-in-out, transform 0.2s linear;
}

.searchbnt:hover {
	transform: scale(1.1);
	background-color: blue;
}

input {
	transition: transform 0.2s ease-in-out;
}

input:hover {
	box-shadow: 2px 2px 5px blue, -2px -2px 5px blue;
	transform: scale(1.1);
}
.content{
display:flex;
justify-content:center;

overflow-y: auto;
height:70%;
margin:20px;
padding :20px
}
table{
border-collapse: collapse;
border :2px solid red;

margin:0 auto;
width:80%;
padding:10px;
}
tr, td, th {
  border: 2px solid red;
}
th {
  background-color: orange;
  padding: 10px;
}

td {
  background-color: white;
  padding: 8px;
}
.delete-btn{
background-color:red;
color:white;
}



</style>
</head>
<body>
	<div class="bg"></div>
	<div class="head">
	<form action="logout" method="get" style="display: inline;">
				<button type="submit"
					style="background-color: white; border: none; color: red; cursor: pointer;height:50px;width:100px;border-radius:30px;border:7px dashed red">
					Logout</button>
			</form>
		<%
		User u = (User) session.getAttribute("user");
		if (u == null) {
			response.sendRedirect("login.jsp");
			return;
		}
		%>
		
		<div class="subhead1">
			

			<%
			if (u != null) {
			%>
			<h1 class="h1">
				Welcome
				<%=u.getName()%></h1>
			<%
			}
			%>
		</div>
		<div class="subhead2">
			<form action="searchTask" method="post"
				style="display: flex; align-items: center;">
				<input class="search" type="text" name="search"
					placeholder="Search tasks">
				<button class="searchbnt" type="submit">
					<h2 class="in">Search</h2>
				</button>
			</form>

		</div>
	</div>
	<div class="butterfly">
		<img
			src="https://cdn.pixabay.com/photo/2022/02/28/12/15/butterfly-7039079_1280.png"
			height="300px" width="300px">
	</div>
	<div class="girl">
		<img
			src="https://cdn.pixabay.com/photo/2022/05/24/11/18/student-7218264_1280.png"
			height="400px" width="500px">
	</div>
	<div class="list">

		<div class="container">
			<h1 class="h1">
				<u>To-Do List:-</u>
			</h1>
			<%
			String message = (String) session.getAttribute("message");
			if (message != null) {
			%>
			<p class="message"><%=message%></p>
			<%
			session.removeAttribute("message");
			}
			%>

			<h2>Add Task</h2>
			<form action="addtask" method="post">
				<input type="text" name="task" placeholder="Enter new task" required>
				<button type="submit" class="searchbnt">Add</button>
			</form>

			<div class="content">
				<%
				List<Tasks> list = (List<Tasks>) request.getAttribute("taskList");
				if (list != null && !list.isEmpty()) {
				%>


				<table class="task-table">
					<tr>
						<th>Task ID</th>
						<th>Task</th>
						<th>Status</th>
						<th>Action</th>
					</tr>
					<%
					for (Tasks t : list) {
					%>
					<tr>
						<td><%=t.getTid()%></td>
						<td><%=t.getTasks()%></td>
						<td>
							<form action="updatestatus" method="post">
								<input type="hidden" name="taskid" value="<%=t.getTid()%>">
								<input type="checkbox" name="status" value="true"
									onchange="this.form.submit()"
									<%=t.getStatus() ? "checked" : ""%>>
							</form>
						</td>

						<td>
							<form action="deletetask" method="post" style="display: inline;">
								<input type="hidden" name="taskid" value="<%=t.getTid()%>">
								<button type="submit" class="delete-btn">Delete</button>
							</form>
						</td>
					</tr>
					<%
					}
					%>
				</table>
				<%
				} else {
				%>
				<p style="color: white;">No tasks available.</p>
				<%
				}
				%>
			</div>

		</div>
	</div>
</body>
</html>