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
public class DrishtiUserRepository extends CouchDbRepositorySupport<DrishtiUser> {

	@Autowired
	public DrishtiUserRepository(@Qualifier("blogPostDatabase") CouchDbConnector db) {
		super(DrishtiUser.class, db);
		initStandardDesignDocument();
	}
	
	@GenerateView 
	@Override
	public List<DrishtiUser> getAll() {
		ViewQuery q = createQuery("all")
						.descending(true)
						.includeDocs(true);
		return db.queryView(q, DrishtiUser.class);
	}
	
	@GenerateView
	public List<DrishtiUser> findByUsername(String username, String password) {
		
		/*ViewQuery query = createQuery("by_username")
				.includeDocs(true)
				.key(username);
		
		
			return db.queryView(query,DrishtiUser.class);*/
		
		
		return queryView("by_username", username);
		
		
	}

}
