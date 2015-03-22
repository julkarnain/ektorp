<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="blog" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>User Details</h1>
	
	 <div class="row">
			<div class="column grid_9">
				<c:choose>
					<c:when test="${empty userList}">
						<p>This blog has no posts yet.</p>
						<h2><a href="/ektorp/posts/new">Write Your First Blog Post</a></h2>
					</c:when>
					<c:otherwise>
						<c:forEach items="${userList}" var="user">
						
						 ID    :               ${user.id} <br />
						 Revision    :         ${user.revision} <br />
						 User Name :           ${ user.username} <br />
						 Password :            ${ user.password } <br />
						 Key for Hash(Salt)  : ${ user.salt} <br />
						 
						 
						
							
						</c:forEach>
					</c:otherwise>
				</c:choose>
			</div>
		</div> 
	
</body>
</html>