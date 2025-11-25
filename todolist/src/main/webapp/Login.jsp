<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
if (session != null && session.getAttribute("user") != null) {
    response.sendRedirect("dashboard");
    return;
}
%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login page</title>
<STYLE>
body{
background-image:url('https://images.unsplash.com/photo-1579973422569-38c5a46a0b45?ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&q=80&w=870');
background-size:cover;
margin:0;
height:100vh;
display:flex;
flex-direction:column;
justify-content:center;
}
form{
display:flex;
flex-direction:column;
background-color:rgba(7, 136, 95, 0.8);
padding:50px;
gap:20px;
margin:20px;
min-width:500px;
border-radius:10px 30px;
}
input[placeholder]{
text-align:center;
}
input{
padding:10px;
border:none;
transition:transform 0.2s linear,border 0.2s ease-in;
border-radius:10px;
}
.container{
display:flex;
flex-direction:column;
justify-content:center;
align-items:center;
}
button{
background-color:rgba(163, 0, 0, 1);
width:100px;
align-self:center;
padding:10px;
border-radius:10px ;
color:white;
font-size:20px;
transition:transform 0.2s linear,background-color 0.2s ease-in-out;
}
.note{
color:blue;
text-align:center;
background-color:rgba(255,255,255,0.7);
border-radius:10px 20px;
font-size:20px;
padding:10px;
}
.heading{
color:white;
font-weight:70px;
text-align:center;
 text-shadow: 2px 2px 0px rgba(5, 209, 145, 0.69),2px 2px 0px rgba(5, 209, 145, 0.69),2px 2px 0px rgba(5, 209, 145, 0.69),2px 2px 0px rgba(5, 209, 145, 0.69),2px 2px 0px rgba(5, 209, 145, 0.69); 
font-size:50px;
padding:10px;
}
button:hover{
background-color:blue;
transform:scale(1.1);
}
input:hover{
transform:scale(1.1);
border:2px solid blue;
}
a[href]{
color:black;
}  
</STYLE>
</head>
<body>
<h1 class="heading">Log-in</h1>
<% if(request.getAttribute("success")!=null) { %>
<h3 Style="color:blue;font-size:30px;text-align:center;">
<%=request.getAttribute("success") %>
</h3>
<%} %>
<% if(request.getAttribute("successp")!=null) { %>
<h3 Style="color:blue;font-size:30px;text-align:center;">
<%=request.getAttribute("successp") %>
</h3>
<%} %>
<div class="container">
<form action="login" method="post">

<input type="text" name="email" placeholder="ENTER YOUR EMAIL">
<input type="text" name="password" placeholder="ENTER YOUR PASSWORD ">
<button type="Submit" value="submit">Login</button>
<% if(request.getAttribute("error")!=null) { %>
<h3 Style="red:blue;font-size:30px;text-align:center;">
<%=request.getAttribute("error") %>
</h3>
<%} %>
<% if(request.getAttribute("failed")!=null) { %>
<h3 Style="color:red;font-size:30px;text-align:center;">
<%=request.getAttribute("failed") %>
</h3>
<%} %>

</form>
<b><p class="note">Don't have an account?<a href="Signin.jsp">Sign-up</a></p></b>
<b><p class="note"><a href="forget.jsp">Forgot password?</a></p></b>
</div>


</body>
</html>