<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="blog" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
	<head>
		<title>BlogPost Exists</title>
		<link href="/resources/styles/grid.css" type="text/css" rel="stylesheet" media="screen"/>
		<link href="/resources/styles/components.css" type="text/css" rel="stylesheet" media="screen"/>		
	</head>
	<body>
		<div class="row">
		<header id="blog_hd" class="column grid_9">
			<h1 style="color: red;">Blog Post Exists</h1>
			<a href="<c:url value="/blog/posts/"/>">Home</a>
		</header>
		</div>
		<div class="row">
			<div class="column grid_9">
				<p>A blog post with the title <strong>${param.title}</strong> already exists</p>
				<h3>Change your title:</h3>
				<jsp:include page="post_form.jspf"/>
			</div>	
		</div>
	</body>
</html>