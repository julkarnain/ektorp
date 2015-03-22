<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
			<a href="<c:url value="/ektorp/"/>">Back</a>
		</header>
		</div>
		<div class="row">
			<div class="column grid_9">
				<blog:blogPost post="${blogPost}" comments="true"/>
			</div>	
		</div>
	</body>
</html>