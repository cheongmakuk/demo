package mkc.exercise.ac1.model.out;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import mkc.exercise.ac1.model.in.RawData;
/**
 * Users data set object for the return in User RESTful api
 * 
 * @author kcmak
 *
 */
@JsonPropertyOrder({ "meta", "data"})
public class UsersDataSet {
	
	private Meta meta;
	private List<User> data;
	
	@JsonGetter("meta")
	public Meta getMeta() {
		return meta;
	}
	public void setMeta(Meta meta) {
		this.meta = meta;
	}
	@JsonGetter("data")
	public List<User> getData() {
		return data;
	}
	public void setData(List<User> data) {
		this.data = data;
	}
	
	public UsersDataSet() {
		
	}
}
