package org.ektorp.sample;

import java.util.List;

import org.ektorp.CouchDbConnector;
import org.ektorp.ViewQuery;
import org.ektorp.support.CouchDbRepositorySupport;
import org.ektorp.support.GenerateView;
import org.ektorp.support.View;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
//@View( name="all", map = "function(doc) { if (doc.blogPostId) { emit(null, doc) } }")
public class CommentRepository extends CouchDbRepositorySupport<Comment> {

        @Autowired
        public CommentRepository(@Qualifier("blogPostDatabase") CouchDbConnector db) {
                super(Comment.class, db);
                initStandardDesignDocument();
        }
        
       @GenerateView 
    	@Override
    	public List<Comment> getAll() {
    		ViewQuery q = createQuery("all")
    						.descending(true)
    						.includeDocs(true);
    		return db.queryView(q, Comment.class);
    	}
        @GenerateView
        public List<Comment> findByBlogPostId(String blogPostId) {
                return queryView("by_blogPostId", blogPostId);
        }

}