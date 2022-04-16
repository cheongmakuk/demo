package mkc.exercise.ac1.model.in;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
/**
 * Age data object for the raw data from the RawAgeConsumer
 * 
 * @author kcmak
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class RawAge {
	private int age;
	private String name;
	
	public RawAge() {
		
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
