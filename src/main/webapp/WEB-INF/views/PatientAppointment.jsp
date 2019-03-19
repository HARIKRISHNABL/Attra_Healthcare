<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   <%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
   <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
  <%--  <jsp:useBean id="now" class="java.util.Date" /> --%>
   <%@ page import="java.util.Date"%>
   <%@ page import="java.text.SimpleDateFormat"%>
  <%! String  strDate;%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>PatientAppointment</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>

  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
<script >
window.history.forward();</script>

<style >
.rowdesign {
	/* border:1px solid black;
border-collapse: collapse;
 */
	/*  padding: 5px */
	color: #4c4c4c;
}
/* table, th, td {
    border-collapse: collapse;
} */
.tabledesign {
	border: 1px solid #bcbcb;
	background-color: #efefef;
	width: 75%;
	text-align: center;
	/* border-collapse: collapse; */
}

.buttonstyle {
	/* padding-top: 5px; */
	margin-top: 26px;
	margin-right: 11px;
	background-color: green;
	color: white;
}

.myHeader {
	background-color: #353535;
	height: 110px;
}

.imagestyle {
	color: #ffffff;
	padding-top: 35px;
}

.logoutstyle {
padding-right:15px;
	color: green;
}
/* .maintext
{
background-color: green;
} */
.titleheading {
	padding: 50px;
}

.col-xs-3 {
	padding-top: 20px;
	padding-left: 20px;
}
.abc{
text-align: center;
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
${DoctorName}
&nbsp&nbsp&nbsp&nbsp&nbsp
<a href="logout" class="logoutstyle">Logout</a> 
</div> 
</header>
</div>



 <%-- <div style="text-align:right">
 <img  src="${pageContext.request.contextPath}/resources/image/60fee6bf-a1cc-4001-9e56-7b5fb295ee5d.png" height="42" width="42" align="middle">
${DoctorName}
&nbsp&nbsp&nbsp&nbsp&nbsp
<a href="logout">Logout</a> 
</div>  --%>

<%-- <%Date date = new Date();
SimpleDateFormat formatter = new SimpleDateFormat("yyyy-dd-MM");
 strDate= formatter.format(date);
out.print(strDate);
 %> --%>
<%-- <fmt:formatDate value="${now}" pattern="yyyy-mm-dd" var="todaydate"/>  --%>
<%-- <c:set var="datet" value="${strDate}">

</c:set> --%>
<%-- <sql:setDataSource
        var="patientDetails"
        driver="com.mysql.jdbc.Driver"
        url="jdbc:mysql://localhost:3306/attrahealthcare"
        user="root" password="root"
    /> --%>
    <%-- <sql:query var="patientList"   dataSource="${patientDetails}" >
    SELECT * FROM attrahealthcare.appointmentdetails where appointmentdetails.AppointmentDate="${strDate}"
        
        <sql:param value="${datet}"/>
       
    </sql:query> --%>
  <%--  <%out.print(strDate) ;%> --%>
  <div align="middle" class ="titleheading">
  <caption ><h2>My Appointments</h2></caption>
  </div>
      <form action="conform" method="post">
    <div align="center">
      
        <table  class=" table-striped table-bordered  tabledesign" >
          
            <tr >
              <th></th> 
                <th class="abc">PatientName</th>
                <th class="abc">AppointmentDate</th>
                <th class="abc">TimeSlot</th>
                <th class="abc">Status</th>
            </tr>
             
            <c:forEach var="patient" items="${patientlist}">
              
                <tr>
                   <td class="checkedvalues" >
            <input type="checkbox" name="checkedvalues" value="${patient.appointmentId}">
            </td>
                   <%--  <td><c:out value="${patient.appointmentId}" /></td>  --%>
                    <td class="rowdesign"><c:out value="${patient.patientName}" /></td>
                    <td class="rowdesign"><c:out value="${patient.appointmentDate}" /></td>
                    <td class="rowdesign"><c:out value="${patient.timeSlot}" /></td>
                    <td class="rowdesign"><c:out value="${patient.status}" /></td>
                </tr>
            </c:forEach>
            <tr>
            <td></td>
            <td></td>
            </tr>
            </table>
           <div  style="text-align:center">
            <input class="buttonstyle" type="submit" value="Confirm Booking" name="conform">
        <input class="buttonstyle" type="submit" value="Cancel Booking" name="cancel">
        </div>
        
        <!-- </table>
        <table cellpadding="10"> -->
       
      
       
        
         </div> 
        </form>
       <!--  <th>
        <form action="delete">
        <input type="submit" value="delete">
        </form></th>
        </tr> -->
        
   
</body>
</html>