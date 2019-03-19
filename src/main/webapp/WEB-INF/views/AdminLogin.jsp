<%--   <%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
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
<script language="javascript">
  function check()
  {
	  if(document.f1.doctorEmail.value=="")
	  	{
	  		alert("Email field cannot  be blank");
	  		document.f1.doctorEmail.focus();
	  		return false;
	  	}
	  if(document.f1.password.value=="")
	  	{
	  		alert("Password field cannot be blank");
	  		document.f1.password.focus();
	  		return false;
	  	}
  }
  </script>
</head>

<body> 
 

 <form action="adminLogin" method="post" name="f1" onsubmit="return check()">
<input type="text" name="doctorEmail" >
<input type="password" name="password">
<input type="submit" value="login">
</form>
<--
<form:form action="${pageContext.request.contextPath}/adminLogin" modelAttribute="adminLoginObj" method="post">
MailID:<form:input path="doctorEmail"/>
Password:<form:password path="password"/>
<input type="submit" value="Login">
</form:form> 
</body>
</html> 
 --%>


<%--  <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>



<meta charset="utf-8">

  <meta name="viewport" content="width=device-width, initial-scale=1">

  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">

  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>

  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<!------ Include the above in your HEAD tag ----------> 

<script language="javascript">
  function check()
  {
	  if(document.f1.doctorEmail.value=="")
	  	{
	  		alert("Email field cannot  be blank");
	  		document.f1.doctorEmail.focus();
	  		return false;
	  	}
	  if(document.f1.password.value=="")
	  	{
	  		alert("Password field cannot be blank");
	  		document.f1.password.focus();
	  		return false;
	  	}
  }
  </script>

<style>

  body {

  font-family: Segoe UI, Helvetica, sans-serif;}

#myHeader {

    color: black;

    padding:30px;

    text-align:left-side;

} 

.container
{

  background-color:#000000;

  width:70%;

  height:400px;

  }

.link{

	block:blue;

    color: white;

    padding: 16px;

    font-size: 16px;

    border: none;
    }

.container_label {

  text-align: center;

}

span 

{

	color:blue;

	float :right;

}

 .new {

    background: red;

    text-align: center;

}

.left {

	float: right;

	padding: 0 20px 20px 0;

}

			

.button

{

	float: right;

	padding: 40px 50px 20px 0;

	text-decoration: none;

}

a.hover{

  text-decoration: underline;

}

.ad

{

	float: center;

	padding: 40px 50px 20px 0;

	text

}



a.hover {

    text-decoration: underline;

}

 

.form-control{

 width:50%;

}

.login_container{

	padding:10% 30% 10% 30%;

	color:white;

}

.emailBox,.passwordBox{

	border-radius: 0px !important; 

	width: 100%;

	margin-bottom: 30px;

	margin-left: 10px;

}		

.passwordBox{

	width: 96%;

	margin-left: 20px;

}

.submitBtn{

	background: green;

	border-radius: 0px !important; 

	width: 212px; 

	color: white;

	margin-bottom: 30px;

}



</style>

</head>

<body background="${pageContext.request.contextPath}/resources/image/bgLogin.png">





<header id="myHeader">

<img src="${pageContext.request.contextPath}/resources/image/logo.png" alt="attralogo" width="150" height="70" >

</header>



<div class="container">

	<div class="login_container">

		<div class="col-xs-12 text-center">

			<h1>Login</h1><br>

		</div>
<form action="adminLogin" method="post" name="f1" onsubmit="return check()">
		<div class="row">

			<div class="col-xs-4">

				 <label for="email">User Name:</label>

			</div>

			<div class="col-xs-8">

				 <input type="text" class="form-control emailBox" placeholder="Enter email" name="doctorEmail">

			</div>

		</div>

		<div class="row">

			<div class="col-xs-4">

				 <label for="pwd">Password:</label>

			</div>

			<div class="col-xs-8">

				 <input type="password" class="form-control passwordBox"  placeholder="Enter password" name="password">

			</div>

		</div>

		<div class="row">

			<div class="col-xs-4"></div>

			<div class="col-xs-8" style="margin-left: 95px;">

				<input type="submit" class="btn btn-default submitBtn" value="Login"></input><br>

			</div>

		</div>

		

		</form>	

		</div>

	</div>












</body>

</html>
  --%> --%>
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
<script language="javascript">
  function check()
  {
	  if(document.f1.doctorEmail.value=="")
	  	{
	  		alert("Email field cannot  be blank");
	  		document.f1.doctorEmail.focus();
	  		return false;
	  	}
	  if(document.f1.password.value=="")
	  	{
	  		alert("Password field cannot be blank");
	  		document.f1.password.focus();
	  		return false;
	  	}
  }
  </script>
</head>

<body> 
 

 <form action="adminLogin" method="post" name="f1" onsubmit="return check()">
<input type="text" name="doctorEmail" >
<input type="password" name="password">
<input type="submit" value="login">
</form>
<--
<form:form action="${pageContext.request.contextPath}/adminLogin" modelAttribute="adminLoginObj" method="post">
MailID:<form:input path="doctorEmail"/>
Password:<form:password path="password"/>
<input type="submit" value="Login">
</form:form> 
</body>
</html> 
 --%>


 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Expires" content="-1">

<%-- <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>



<meta charset="utf-8">

  <meta name="viewport" content="width=device-width, initial-scale=1">

  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">

  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>

  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<!------ Include the above in your HEAD tag ----------> 

<script language="javascript">
  function check()
  {
	  if(document.f1.doctorEmail.value=="")
	  	{
	  		alert("Email field cannot  be blank");
	  		document.f1.doctorEmail.focus();
	  		return false;
	  	}
	  if(document.f1.password.value=="")
	  	{
	  		alert("Password field cannot be blank");
	  		document.f1.password.focus();
	  		return false;
	  	}
  }
  </script>

<style>

  body {

  font-family: Arial, Helvetica, sans-serif;}





#myHeader {

    color: black;

    padding:30px;

    text-align:left-side;

} 

.container

{

  background-color:#000000;

  width:70%;

  height:400px;

  

}

.link{

	block:blue;

    color: white;

    padding: 16px;

    font-size: 16px;

    border: none;

}

.container_label {

  text-align: center;

}

span 

{

	color:blue;

	float :right;

}

 .new {

    background: red;

    text-align: center;

}

.left {

	float: right;

	padding: 0 20px 20px 0;

}

			

.button

{

	float: right;

	padding: 40px 50px 20px 0;

	text-decoration: none;

}

a.hover{

  text-decoration: underline;

}

.ad

{

	float: center;

	padding: 40px 50px 20px 0;

	text

}



a.hover {

    text-decoration: underline;

}

 

.form-control{

 

 width:50%;

}



.btn btn-default{

 width:50%;

}

.login_container{

	padding:10% 30% 10% 30%;

	color:white;

}

.emailBox,.passwordBox{

	border-radius: 0px !important; 

	width: 100%;

	margin-bottom: 30px;

	margin-left: 10px;

}		

.passwordBox{

	width: 96%;

	margin-left: 20px;

}

.submitBtn{

	background: green;

	border-radius: 0px !important; 

	width: 212px; 

	color: white;

	margin-bottom: 30px;

}

a{

	font-size:12px;

}

</style>

</head>

<body background="${pageContext.request.contextPath}/resources/image/bgLogin.png">





<header id="myHeader">

<img src="${pageContext.request.contextPath}/resources/image/logo.png" alt="attralogo" width="150" height="70" >

</header>



<div class="container">


	<div class="login_container">

		<div class="col-xs-12 text-center">

			<h1>Admin Login</h1><br>

		</div>
<form action="adminLogin" method="post" name="f1" onsubmit="return check()">
		<div class="row">

			<div class="col-xs-4">

				 <label for="email">User Name:</label>

			</div>

			<div class="col-xs-8">

				 <input type="text" class="form-control emailBox" placeholder="Enter email" name="doctorEmail">

			</div>

		</div>

		<div class="row">

			<div class="col-xs-4">

				 <label for="pwd">Password:</label>

			</div>

			<div class="col-xs-8">

				 <input type="password" class="form-control passwordBox"  placeholder="Enter password" name="password">

			</div>

		</div>

		<div class="row">

			<div class="col-xs-4"></div>

			<div class="col-xs-8" style="margin-left: 95px;">

				<input type="submit" class="btn btn-default submitBtn" value="Login"></input><br>

			</div>

		</div>

		

		</form>	

		</div>

	</div>












</body>

</html> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!------ Include the above in your HEAD tag ----------> 

<style>
body {
  font-family:  Segoe UI, Helvetica, sans-serif;}

  .container
{
 width: 500px;
	font-size:20px;
  background-color:#000000;
  <!--padding: 0px 20px 50px 400px; -->
  margin:50% 25% 25% 25%;
   
	opacity:0.8;
	padding : 5%;
	padding-left: 25px;
	padding-right: 25px;
  }

   #myHeader {
      padding:30px;
    
} 
.h
{

text-align:center;
margin-bottom:3%;
padding-bottom:10%;
}
 .label-text{
 	color:#ffffff;
 	}
.loginbtn
{
 background-color:green;
}
.form-control{
 width:60%;
margin: 1% 0% 1% 0%;
 }
 
.data-body{
padding-left: 25%;
}
  
  .pro{
  
  margin-left:10%;
  
  }

  .emailBox{

	padding:0px 0px 0px 0px;

	width: 100%;

	margin-bottom: 30px;

	
	margin-left: 40px;

}
.passwordBox
{

	padding:0px 0px 0px 0px;

	width: 100%;

	margin-bottom: 30px;

	margin-left: 10px;
	}
.text-left
{  
width:25%;
margin-left:-5%;
}	
.text-left1
	{
width:35%;
margin-left:-5%;
}
.loginbtn 
{
width: 58.33333333%  0px !important; 
margin-left:17%;
	width:70%;
	
	}
 </style>


<title>Admin Login Page</title>
<script>
 function check()
  {
	  if(document.f1.doctorEmail.value=="")
	  	{
	  		alert("Email field cannot  be blank");
	  		document.f1.doctorEmail.focus();
	  		return false;
	  	}
	  if(document.f1.password.value=="")
	  	{
	  		alert("Password field cannot be blank");
	  		document.f1.password.focus();
	  		return false;
	  	}
  }

</script>
</head>
<!--<body background="${pageContext.request.contextPath}/resources/image/bgLogin.png" style="background-repeat: no-repeat;">-->
 <body background="${pageContext.request.contextPath}/resources/image/bgLogin.png" style="background-repeat: no-repeat;">
<header id="myHeader">  
<img  src="${pageContext.request.contextPath}/resources/image/logo.png" height="60" width="180" align="middle">

</header>

<div class="container">



<div class="col-xs-12 text-center">
<div class="label-text h text-center"><b>Admin Login </b></div>


<form action="adminLogin" method="post" name="f1" onsubmit="return check()">
<div class="data-body">
<div class="col-xs-5 text-left">
 <label class="label-text" for="email" >Email:</label>
 </div>
 <div class="col-xs-7">
     <input type="email"  class="form-control emailBox" placeholder="Enter email" name="doctorEmail" autocomplete=off   />
	
    </div>
   <div class="col-xs-5 text-left1">
      <label class="label-text" for="pwd">Password:</label>
     </div>
     <div class="col-xs-7">
      <input type="password" name="password" class="form-control passwordBox"  placeholder="Enter password"  autocomplete=off />
      	 
    </div>
	</div>
	<!--<div class="col-xs-4 text-left">
      <label class="label-text" for="pwd">PatientName:</label>
      </div>
      <div class="col-xs-8">
     <input type="text" name="patientName" class="form-control" id="pName" autocomplete="off"/>
	  <p id="nameError" style="display:none; color:red">Name field cannot be blank</p>
    </div>
	<div class="col-xs-4 text-left">
      <label class="label-text" for="pwd">Phone:</label>
      </div>
      <div class="col-xs-8">
      <input type="text" name="phone" class="form-control" id="phone" autocomplete="off"/>
       <p id="phoneError" style="display:none; color:red">Phone no field cannot be blank</p>
	 	 <p id="phoneError1" style="display:none; color:red">enter valid phone number</p>
    </div>>-->
    <div class="col-xs-5">
    </div>
    <div class="col-xs-7">
		<button type="submit" class="form-control loginbtn label-text"  id="btn" >Login</button><br>
		<p id="btnError" style="display:none; color:red">All Field cannot be blank</p>
	</div>
	
	</div>
	</div>
		</form>
	<!--<div class="pro">
<h6>	<p style="color:white;">Already have an account?</p></h6>
<h4>	<a href="login">Login</a> </h4>
	
	</div>--s>-->
	

</div>

</body>
</html>



 