package mkc.exercise.ac1.model.out;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import mkc.exercise.ac1.model.in.RawAge;
import mkc.exercise.ac1.model.in.RawUser;

/**
 * User data object for the return in User RESTful api
 * 
 * @author kcmak
 *
 */

@JsonPropertyOrder({ "id", "email","firstName","lastName","avatar"})
public class User {
	private long id;
	private String email;
	private String firstName;
	private String lastName;
	private String avatar;
	
	public User() {
		
	}
	
	@JsonGetter("id")
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	@JsonGetter("email")
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@JsonGetter("firstName")
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	@JsonGetter("lastName")
	public String getLastName() {
		return lastName;
	}
	public void setLast_name(String lastName) {
		this.lastName = lastName;
	}
	
	@JsonGetter("avatar")
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
}
