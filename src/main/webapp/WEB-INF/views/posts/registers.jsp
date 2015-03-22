<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="blog" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
	<head>
		<title>User Registration</title>
		<link href="/resources/styles/grid.css" type="text/css" rel="stylesheet" media="screen"/>
		<link href="/resources/styles/components.css" type="text/css" rel="stylesheet" media="screen"/>		
	</head>
	
	<body>
	
	
		<form:form action="/ektorp/user/submit/">
		
			 <div class="section">
				<label for="username">User Name : </label>
				<form:input path="username"/>
			</div> 
			
			<div class="section">
				<label for="password">Password : </label>
				<form:input path="password"/>
			</div>
			<div class="section">
				<label for="fname">First Name : </label>
				<form:input path="fname"/>
			</div>
			<div class="section">
				<label for="lname">Last Name :</label>
				<form:textarea path="lname"/>
			</div>
			
			<div class="section">
				<label for="fathername">Father Name :</label>
				<form:textarea path="fathername"/>
			</div>
			
			<div class="section">
				<label for="email">E-Mail Address :</label>
				<form:textarea path="email"/>
			</div>
			
			<div class="section">
				<label for="presentadd">Present Address :</label>
				<form:textarea path="presentadd"/>
			</div>
			
			<div class="section">
				<label for="permanentadd">Permanent Address :</label>
				<form:textarea path="permanentadd"/>
			</div>
			
			<div>
				<button type="submit">Submit</button>
			</div>
		</form:form>
	</body>
	
	</html>