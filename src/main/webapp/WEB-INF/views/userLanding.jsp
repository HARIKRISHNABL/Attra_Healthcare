<%@page import="java.sql.*"%>  
<%
	Connection con = null;
	Statement stm = null;
	ResultSet rs = null;
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script type="text/javascript" src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script>

window.history.forward();
$(function(){
	$("#scheduleDate").datepicker();
}); 
/* $(document).ready(function() {
	$('#bA').click(function (e) {
		e.preventDefault();
		bookAppointment();
	});
}); */
function bookAppointment() {
	var hosId = $("#hospital").val();
	var depId = $("#department").val();
	var docId = $("#doctor").val();
	var schDelId = $("#scheduleDate").val();
	var doctorAvail = $("#doctoravail").val();
	$.ajax({
		url :'storeData',
		type : 'POST',	
		data : {
			"hospId" : hosId,
			"depId" : depId,
			"docId" : docId,
			"schDelId" : schDelId,
			"doctorAvail" : doctorAvail
		},
		
			/* contentType: 'application/json',
		    dataType: 'json',
			data : JSON.stringify(data), */
			success : function(res){
				/* alert(res); */
				alert("Your request has been sent to doctor for fixing an appointment.\n Please wait for email confirmation");},
			error : function(error) {
				console.log(error);
				alert("error occured");}
	});
}
</script>

<style>
.myHeader {
	background-color: #353535;
	height: 110px;
}
.book
{padding :2% 0% 0% 4%;
 text-align:center;
 font-size:20px;
}
.book1
{
 border:1px solid
#bcbcbc; 
}
.imagestyle {
	color: #ffffff;
	padding-top: 35px;
}
.spacing{
margin:1% 0% 2% 0%;

}
.width
{
width:100%
}
.abc
{
padding-top: 20px;
	padding-left: 20px;
}
.logoutstyle {
padding-right:15px;
	color: green;
}
</style>

</head>
<body>
<div class="col-xs-12">
	<header class="myHeader" >
		<div class="col-xs-3 ">
			<img  src="${pageContext.request.contextPath}/resources/image/logo.png">
		</div>
		<div style="text-align:right" class="imagestyle" >
			 <img  src="${pageContext.request.contextPath}/resources/image/60fee6bf-a1cc-4001-9e56-7b5fb295ee5d.png" height="42" width="42" align="middle">
			${PatientName}
			&nbsp&nbsp&nbsp&nbsp&nbsp
			<a href="login" class="logoutstyle">Logout</a> 
		</div> 
	</header>
</div>

<div class="container">
	<div class="row">
    	<div class="col-sm-6" ></div> 
    	<div class="col-sm-6" >
  	  		<span class="book">
  			  <p>Book an Appointment</p><br>
 	  		 </span>  
   		 </div>
	<form action="" method="post">
		<div class="form-group">
		<div class="col-sm-3" ></div>
  	   <div class="col-sm-3" >Hospital Name:</div>

    	  <div class="col-sm-6" >
				<%
					try {
						HttpSession session1=request.getSession();
						String patientname=(String) session.getAttribute("PatientName");


if(patientname!=null) {
System.out.println("hai");
	
	
		
}


					
						
						
						Class.forName("com.mysql.jdbc.Driver").newInstance();
						con = DriverManager.getConnection("jdbc:mysql://localhost:3306/attrahealthcare", "root", "root");
						stm = con.createStatement();
						rs = stm.executeQuery("select * from attrahealthcare.hospitaldetails");
				%>	
						<select name="hospital" id="hospital" class="form-control spacing book1"
						onchange="this.form.submit();">
						<option value="-1">select Hospital </option>
						<%
							while (rs.next()) {
						%>
						<option value="<%=rs.getInt(1)%>" 
						
						<% 
						if(request.getParameter("hospital")!=null)
						{
						 if(rs.getInt(1)==Integer.parseInt(request.getParameter("hospital")))
						 {
							 out.print("selected");
						 }
						}
						%>
						
						><%=rs.getString(2)%></option>
						<%
							}
						%>
				</select>
				 <%
 					} 
					catch (Exception ex) {
 					out.println("error is coming");
 					}
				 %> 
 	 </div>
  </div>
  
 <div class="book2">
 	 <div class="col-sm-3" ></div> 
     <div class="col-sm-3" >Department Name:</div>
 </div>
 <div class="col-sm-6" >
 
 <%
 	try {
 		Class.forName("com.mysql.jdbc.Driver").newInstance();
 		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/attrahealthcare", "root", "root");
 		PreparedStatement psmt = con
 				.prepareStatement("select * from attrahealthcare.departmentdetails where HospitalId=?");
 		psmt.setString(1,request.getParameter("hospital")  );
 		/* request.getParameter("hospital") */
 		rs = psmt.executeQuery();
 %>
		
		 <select name="department" id="department" class="form-control spacing" onchange="this.form.submit();">
		 
		<option value="-1">select Department</option>
		<%
			while (rs.next()) {
		%>
		<option value="<%=rs.getInt(1)%>"
		<% 
			if(request.getParameter("department")!=null)
				{
					 if(rs.getInt(1)==Integer.parseInt(request.getParameter("department")))
						 {
							 out.print("selected");
						 }
						}
						%>
						><%=rs.getString(2)%></option>
						<%
							}
							} catch (Exception ex) {

								out.println("error os cmmming");
							}
						%>
				</select>	
		</div>
 <div class="book2"> 
	  <div class="col-sm-3" ></div>
     <div class="col-sm-3" ><th> Doctor Name:</th> </div>
      <div class="col-sm-6" >					
	<%
	try {
 		Class.forName("com.mysql.jdbc.Driver").newInstance();
 		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/attrahealthcare", "root", "root");
 		PreparedStatement psmt = con
 				.prepareStatement("select * from attrahealthcare.doctordetails where DeptId=?");
 		psmt.setString(1, request.getParameter("department"));
 		rs = psmt.executeQuery();
	%>			
		<select name="doctor" id="doctor" class="form-control spacing" onchange="this.form.submit();">	
				<option value="-1">select Doctors</option>
				<%
							while (rs.next()) {
						%>
						<option value="<%=rs.getInt(1)%>"
						<% 
						if(request.getParameter("doctor")!=null)
						{
						 if(rs.getInt(1)==Integer.parseInt(request.getParameter("doctor")))
						 {
							 out.print("selected");
						 }
						}
						%>
						><%=rs.getString(2)%></option>
						<%
							}
							} catch (Exception ex) {
								out.println("error os cmmming");
							}
						%>
				</select>
</div>
</div>			
<div class="book2"> 
	 <div class="col-sm-3" ></div>
     <div class="col-sm-3" >Schedule Date:</th></div>
      <div class="col-sm-6" >
		<input type="text" name="scheduleDate" class="form-control spacing"   id="scheduleDate" data-date-inline-picker="true" placeholder="Enter Date" />

	</div>
</div>
<div class="book2">
 <div class="col-sm-3" ></div> 
     <div class="col-sm-3" ><th>Schedule Time:</th></div>
      <div class="col-sm-6" >
<%
	try {
 		Class.forName("com.mysql.jdbc.Driver").newInstance();
 		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/attrahealthcare", "root", "root");
 		PreparedStatement psmt = con
 				.prepareStatement("select * from attrahealthcare.doctoravailability where DoctorId=?");
 		psmt.setString(1, request.getParameter("department"));
 		rs = psmt.executeQuery();
	%>			
		 <td> <select name="doctoravail"  id="doctoravail" class="form-control spacing">		
				<option value="-1">Schedule Time</option>
				<%
							while (rs.next()) {
						%>
						<option value="<%=rs.getString(5)%>"><%=rs.getString(5)%></option>
						<%
							}
							} catch (Exception ex) {
								out.println("error os cmmming");
							}
						%>
				
				</select>
</div>	
</div>
<div class="book3"> 
     <div class="col-sm-6" ></div>
      <div class="col-sm-6" >
		<input type="submit" value="Book Appointment" class="btn btn-success width" name="Book Appointment"  onclick="bookAppointment()">
	</div>
</div>

</form>
</div>
</div>
</body>
</html>
<script>
/* function checkIt(res)
{
	if(res==true)
	{ 
		window.alert( "Your request has been sent to doctor for fixing an appointment.\n Please wait for email confirmation");

	 }
	else
	{
		window.alert("Doctor is not available.Try for some other date");
	} 
}   */
</script>







