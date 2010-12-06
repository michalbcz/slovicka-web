/**
 * 
 */
package cz.bernhard.slovicka.domains;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 
 * User in the system.
 * 
 * @author michal
 *
 */
@Entity(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Long id;
	
	@Column
	private String username;
	
	@Column
	private String password;
	
	public Long getId() {
		return id;
	}

	public User setId(Long id) {
		this.id = id;
		return this;
	}
	
	public String getUsername() {
		return username;
	}
	
	public User setUsername(String username) {
		this.username = username;
		return this;
	}
	
	public String getPassword() {
		return password;
	}
	
	public User setPassword(String password) {
		this.password = password;
		return this;
	}
	
	@Override
	public String toString() {
		return "User " +
			   "[username=" + username + 
			   ", password=" + (password != null? "[*****]" : "null") + "]";
	}
	
	
	
}
