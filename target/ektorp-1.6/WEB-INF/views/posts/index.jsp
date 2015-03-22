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
		<header id="blog_hd" class="column grid_9">
			<h1>Relaxed Blog</h1>
			<a href="/ektorp/posts/new">New  Post</a>  <br />
			<a href="/ektorp/user/register/">New User</a>
		</header>
		</div>
		
		
		<div class="row">
			<div class="column grid_9">
				<c:choose>
					<c:when test="${empty commentList}">
						<p>This blog has no posts yet.</p>
						<h2><a href="new">Write Your First Blog Post</a></h2>
					</c:when>
					<c:otherwise>
						<c:forEach items="${commentList}" var="comment">
							<%-- <blog:blogPost post="${blogPost}" /> --%>
							 
							<%--  
							  Blog Title : ${comment.blogPost.blogPostId}
							 Blog Body : ${comment.blogPost.body} 
							   
							  Post Id    :               ${comment.blogPostId} <br />
							  Comment    :               ${comment.comment} <br /> --%>
							 
						</c:forEach>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
	</body>
</html>