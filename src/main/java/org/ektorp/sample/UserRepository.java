package org.ektorp.sample;

import java.util.List;

import org.ektorp.CouchDbConnector;
import org.ektorp.ViewQuery;
import org.ektorp.support.CouchDbRepositorySupport;
import org.ektorp.support.GenerateView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class UserRepository extends CouchDbRepositorySupport<User> {
	
	@Autowired
	public UserRepository(@Qualifier("blogPostDatabase") CouchDbConnector db) {
		
		super(User.class, db);
		initStandardDesignDocument();
	}
	
	@GenerateView 
	@Override
	public List<User> getAll() {
		ViewQuery q = createQuery("all")
						.descending(true)
						.includeDocs(true);
		return db.queryView(q, User.class);
	}

	@GenerateView
	public List<User> findByUsername(String username, String password) {
		return queryView("by_username", username);
		
		
	}
	

}
