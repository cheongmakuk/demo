package mkc.exercise.ac1.model.out;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * 
 * Single user data set object for the return in User RESTful api
 * @author kcmak
 *
 */

@JsonPropertyOrder({ "meta", "data"})
public class UserSingleDataSet {
		
	private Meta meta;
	private UserWithAge data;
		
	@JsonGetter("meta")
	public Meta getMeta() {
		return meta;
	}
	public void setMeta(Meta meta) {
		this.meta = meta;
	}
	@JsonGetter("data")
	public UserWithAge getData() {
		return data;
	}
	public void setData(UserWithAge data) {
		this.data = data;
	}
		
	public UserSingleDataSet() {
		
	}
}
