package org.ektorp.sample;

import org.ektorp.support.CouchDbDocument;
import org.ektorp.support.TypeDiscriminator;

public class User extends CouchDbDocument{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2402610095474867608L;
	
	
	@TypeDiscriminator
	private String username;
	private String password;
	private String fname;
	private String lname;
	private String fathername;
	private String email;
	private String presentadd;
	private String permanentadd;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getFathername() {
		return fathername;
	}
	public void setFathername(String fathername) {
		this.fathername = fathername;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPresentadd() {
		return presentadd;
	}
	public void setPresentadd(String presentadd) {
		this.presentadd = presentadd;
	}
	public String getPermanentadd() {
		return permanentadd;
	}
	public void setPermanentadd(String permanentadd) {
		this.permanentadd = permanentadd;
	}

}
