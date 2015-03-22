<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="joda" uri="http://www.joda.org/joda/time/tags" %>
<%@ attribute name="post" required="true" type="org.ektorp.sample.BlogPost" %>
<%@ attribute name="comments" required="false" type="java.lang.Boolean" %>
<article class="blog_post">
	 <header>
	 	<h2>${post.title}</h2>
	 	<time><joda:format value="${post.dateCreated}" style="SS" /></time>
	 </header>
	 <section>
	 	${post.body}
	 </section>
	 <footer>
	 <c:choose>
		<c:when test="${not empty comments}">
			<c:if test="${not empty post.comments}">
				<h3>Comments:</h3>
				<c:forEach items="${post.comments}" var="comment">
		  		<div class="comment">
		  			<header>${comment.email}&nbsp;<time><joda:format value="${comment.dateCreated}" style="SS" /></time></header>
		  			${comment.comment}
		  		</div>
			  	</c:forEach>				
			</c:if>
		  	<form id="comment_form" action="/ektorp/posts/${post.id}/comment" method="post">
			 	<h3>Send a Comment</h3>
			 	<div class="section">
					<label for="username">Email</label>
					<input type="text" name="email" />
				</div>
				<div class="section">
					<textarea name="comment"></textarea>
				</div>
				<div>
					<button type="submit">Submit</button>
				</div>
			 </form>
		</c:when>
		<c:otherwise>
			<a href="${post.id}">Show comments...</a>	
		</c:otherwise>
	</c:choose>
	 </footer>
</article>

