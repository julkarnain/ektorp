package org.ektorp.sample;

import java.util.List;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.codehaus.jackson.annotate.JsonProperty;
import org.ektorp.support.CouchDbDocument;
import org.ektorp.support.TypeDiscriminator;

@TypeDiscriminator("doc.type == 'DrishtiUser'")
public class DrishtiUser extends CouchDbDocument {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = -4431250802870328244L;
	
	
	@JsonProperty
    private String username;

    @JsonProperty
    private String password;

    @JsonProperty
    private String salt;

    @JsonProperty
    private List<String> roles;
    
    @JsonProperty
    private String type;

    @JsonProperty
    private boolean active;

    protected DrishtiUser() {
    }

    public DrishtiUser(String username, String password, String salt, List<String> roles, boolean active) {
        this.username = username;
        this.password = password;
        this.salt = salt;
        this.roles = roles;
        this.active = active;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getSalt() {
        return salt;
    }

    public List<String> getRoles() {
        return roles;
    }

    public boolean isActive() {
        return active;
    }

    @Override
    public boolean equals(Object o) {
        return EqualsBuilder.reflectionEquals(this, o, "id");
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this, "id");
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}