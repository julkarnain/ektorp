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
		<div class="row">
				<div class="column grid_9">
					<c:choose>
						<c:when test="${empty blogPostList}">
							<p>This blog has no posts yet.</p>
							<h2><a href="new">Write Your First Blog Post</a></h2>
						</c:when>
						<c:otherwise>
							<c:forEach items="${blogPostList}" var="blogPost">
								<blog:blogPost post="${blogPost}"/>
							</c:forEach>
						</c:otherwise>
					</c:choose>
				</div>
			</div>
	
	</body>
	
	
	</html>