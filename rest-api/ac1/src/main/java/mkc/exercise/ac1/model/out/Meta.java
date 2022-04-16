package mkc.exercise.ac1.model.out;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * Meta data object for the return in User RESTful api
 * 
 * @author kcmak
 *
 */
@JsonPropertyOrder({ "total","count","page","totalPages","statusCode","contentType"})
public class Meta {
	public static final String CONTENT_TYPE_JSON = "application/json";
	
	public static final int STATUS_CODE_OK = 200;
	public static final int STATUS_CODE_CLIENT_ERROR = 400;
	public static final int STATUS_CODE_SERVER_ERROR = 500;
	

	private int total;
	private int count;
	private int page;
	private int totalPages;
	private int statusCode;
	private String contentType;
	
	public Meta() {
		
	}
	
	
	@JsonGetter("total")
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	@JsonGetter("count")
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	@JsonGetter("page")
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	@JsonGetter("totalPages")
	public int getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	@JsonGetter("statusCode")
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	@JsonGetter("contentType")
	public String getContentType() {
		return contentType;
	}
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
}
