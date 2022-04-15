package mkc.exercise.ac1.model.in;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * User data object for the raw data from the RawUserConsumer
 * 
 * @author kcmak
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class RawUser {
	private long id;
	private String email;
	private String first_name;
	private String last_name;
	private String avatar;
	
	public RawUser() {	
		
	};
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	
}
