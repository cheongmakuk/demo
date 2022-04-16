package mkc.exercise.ac1.model.out;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import mkc.exercise.ac1.model.in.RawAge;
import mkc.exercise.ac1.model.in.RawUser;

/**
 * User with age data object for the return in User RESTful api
 * 
 * @author kcmak
 *
 */
@JsonPropertyOrder({ "id", "email","firstName","lastName","avatar","age"})
public class UserWithAge extends User {
	private int age;
	
	@JsonGetter("age")
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public UserWithAge() {
		
	}

}
