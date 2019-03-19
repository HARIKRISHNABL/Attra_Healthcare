<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
 <!-- <script type="text/javascript">
function validate() {
	var email=document.forms["loginform"]["doctorEmail"];
	if(email.equals(""))
		{
		alert("please enter ur email");
		email.focus();
		return false;
		}
	
}
</script>  -->
</head>

<body>
  <% response.sendRedirect("adminlogin"); %> 

<!-- <form action="adminLogin" method="post">
<input type="text" name="doctorEmail" >
<input type="password" name="password">
<input type="submit" value="login">

</form>  -->
<form:form action="${pageContext.request.contextPath}/adminLogin" modelAttribute="adminLoginObj" method="post">
MailID:<form:input path="doctorEmail"/>
Password:<form:password path="password"/>
<input type="submit" value="Login">
</form:form>
</body>
</html> --%>
<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"

    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Insert title here</title>

</head>

<body>

<div align="center">

<h>AttraHealthCare</h>

</div>

<a href="error-page1">Go</a>

</body>

</html> --%>


<!DOCTYPE html>

<html>

<head>



<meta charset="utf-8">

  <meta name="viewport" content="width=device-width, initial-scale=1">

  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">

  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>

  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<style>

#myHeader {

Background-color:#000000;

opacity:.5;

    padding:30px;

    text-align:left-side;

} 

.container

{

   text-align: center;

   color:white;

  width:70%;

  height:400px;

  font-size:50px;

  padding:10% 0% 10% 0%;

  margin-left:15%;

  }

 .submitBtn{

	background-color: green;

	border-radius: 0px !important; 

	width: 212px; 

	color: white;

	margin-bottom:20px;

}



  

.footer {

   position: fixed;

   left: 0;

   bottom: 0;

   width: 100%;

   background-color: black;

   color: white;

   text-align: center;

   font-size:15px;

}



</style>

</head>

<body>

<body background="${pageContext.request.contextPath}/resources/image/bgLogin.png">





<header id="myHeader">

<img src="${pageContext.request.contextPath}/resources/image/logo.png" alt="attralogo" width="150" height="70">

</header>



<div class=" container">

<span><p>We Care For Your Health </p>

<p> Every Moment</p></span>





			<a href="login"><button type="submit" class="btn btn-classic  submitBtn" style="background:green">Get Started</button></a><br>

			

		</div>

		<footer class="footer">

		<p>  &copy;

2018 All Rights Reserved.AttraHealthCare </p></footer>

</body>

</html>