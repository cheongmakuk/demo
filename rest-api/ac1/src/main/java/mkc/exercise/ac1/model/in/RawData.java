package mkc.exercise.ac1.model.in;


import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Data object for the raw data from the RawUserConsumer
 * 
 * @author kcmak
 * 
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class RawData {
	
	private int page;
	private int per_page;
	private int total;
	private int total_pages;
	private List<RawUser> data;
	
	public RawData() {
		
	}
	
	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPer_page() {
		return per_page;
	}

	public void setPer_page(int per_page) {
		this.per_page = per_page;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getTotal_pages() {
		return total_pages;
	}

	public void setTotal_pages(int total_pages) {
		this.total_pages = total_pages;
	}

	public List<RawUser> getData() {
		return data;
	}

	public void setData(List<RawUser> data) {
		this.data = data;
	}
}
