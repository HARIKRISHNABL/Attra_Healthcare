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
  .container
{
	font-size:20px;
  background-color:#000000;
  /* padding: 0px 20px 50px 400px; */
  margin:0% 5% 10% 5%;
	opacity:0.8;
	padding : 5%;
	padding-left: 5px;
	padding-right: 5px;
  }

   #myHeader {
      padding:30px;
    
} 
.h
{
text-align:center;
margin-bottom:3%;
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
  </style>


<title>Registration Page</title>
<script>
$(document).ready(function(){
   $("#pswrd").focus(function(){
	   $("#emailError").show();
	   var email = document.getElementById("emailID").value
	   if(email!=""){
		   $("#emailError").hide();
	   } 
   });
	   $("#phone").focus(function(){
		   $("#nameError").show();
		   var name = document.getElementById("pName").value
		   if(name!=""){
			   $("#nameError").hide();
		   } 
	   });
	 $("#pName").focus(function(){
			   $("#pswrdError").show();
			   var pass = document.getElementById("pswrd").value
			   if(pass!=""){
				   if(pass.length<6)
					 {
					   $("#pswrdError").hide();
					   $("#pswrdError1").show();				  
					 }
				   else 
					{
					    $("#pswrdError").hide();
		  				 $("#pswrdError1").hide();
		  				
	 			    } 
			   }
			   
	 });
	
	 $("#btn").focus(function(){
			   $("#phoneError").show();
			   var phn = document.getElementById("phone").value
			   if(phn!=""){
				   if(isNaN(phn)||phn.length!=10)
					 {
					   $("#phoneError").hide();
					   $("#phoneError1").show();
					 }
				   else 
					{
		  				 $("#phoneError").hide();
		  				 $("#phoneError1").hide();
	 			    } 
			   }		 
	 });
	
});
function validate() {
	 var email = document.getElementById("emailID").value
	  var name = document.getElementById("pName").value
	  var pass = document.getElementById("pswrd").value
	  var phn = document.getElementById("phone").value
	if(email!="" && name!="" && (pass!="" &&pass.length>=6) && (phn!="" && !isNaN(phn) && phn.length==10))
		return true;
	else
		return false;
}
</script>
</head>
<body background="${pageContext.request.contextPath}/resources/image/bgLogin.png" style="background-repeat: no-repeat;">
<header id="myHeader">  
<img  src="${pageContext.request.contextPath}/resources/image/logo.png" height="60" width="180" align="middle"> 
 
</header>

<div class="container">

<div class="col-xs-12 text-center">
<div class="label-text h text-center">User Registration </div>


<form action="register" method="post" onsubmit="return validate()">
<div class="data-body">
<div class="col-xs-4 text-left">
 <label class="label-text" for="email" >Email:</label>
 </div>
 <div class="col-xs-8">
     <input type="email" name="email" class="form-control" id="emailID" />
	  <p id="emailError" style="display:none; color:red">Email field cannot be blank</p>
    </div>
   <div class="col-xs-4 text-left">
      <label class="label-text" for="pwd">Password:</label>
     </div>
     <div class="col-xs-8">
      <input type="password" name="password" class="form-control" id="pswrd" />
      	  <p id="pswrdError" style="display:none; color:red">Password field cannot be blank</p>
      	  <p id="pswrdError1" style="display:none; color:red">Minimum 6 characters</p>
    </div>
	<div class="col-xs-4 text-left">
      <label class="label-text" for="pwd">PatientName:</label>
      </div>
      <div class="col-xs-8">
     <input type="text" name="patientName" class="form-control" id="pName"/>
	  <p id="nameError" style="display:none; color:red">Name field cannot be blank</p>
    </div>
	<div class="col-xs-4 text-left">
      <label class="label-text" for="pwd">Phone:</label>
      </div>
      <div class="col-xs-8">
      <input type="text" name="phone" class="form-control" id="phone"/>
       <p id="phoneError" style="display:none; color:red">Phone no field cannot be blank</p>
	 	 <p id="phoneError1" style="display:none; color:red">enter valid phone number</p>
    </div>
    <div class="col-xs-4">
    </div>
    <div class="col-xs-8">
		<button type="submit" class="form-control loginbtn label-text"  id="btn" >Register</button><br>
		<p id="btnError" style="display:none; color:red">All Field cannot be blank</p>
	</div>
	<div class="pro">
	<h6><p style="color:white;">Already have an account?</p></h6>
	<h4><a href="login">Login</a></h4>
	</div> 
	</form>
</div>
</div>
</body>
</html>



















