<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="blog" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
	<head>
		<title>Relaxed Blog</title>
		<link href="/resources/styles/grid.css" type="text/css" rel="stylesheet" media="screen"/>
		<link href="/resources/styles/components.css" type="text/css" rel="stylesheet" media="screen"/>		
	</head>
	
	
	
	
	<body>
	
	<h1>User List</h1>
	
	<div class="row">
			<div class="column grid_9">
				<c:choose>
					<c:when test="${empty userList}">
						<p>This blog has no posts yet.</p>
						<h2><a href="/ektorp/posts/new">Write Your First Blog Post</a></h2>
					</c:when>
					<c:otherwise>
						<c:forEach items="${userList}" var="user">
						
						 User Name :  ${ user.username}
						 First Name : ${ user.fname }
						 Last Name  : ${ user.lname}
						 Father Name : ${ user.fathername}
						 E-Mail : ${ user.email}
						 Present Address : ${user.presentadd}
						 Permanent Address : ${user.permanentadd}
							
						</c:forEach>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
	
	
	</body>
	</html>