package mkc.exercise.ac1.consumer;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.client.RestTemplate;

import mkc.exercise.ac1.model.in.RawData;

public class RawUserConsumer {
	private RestTemplate restTemplate;
	
	public RawUserConsumer() {
	}
	
	private RestTemplate getRestTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
	
	public  RawData getRawDataByPage(int page) throws Exception {
		if (this.restTemplate == null)
			this.restTemplate = getRestTemplate(new RestTemplateBuilder());
		return getRawDataByPage(restTemplate, page);
	}
	
	public static RawData getRawDataByPage(RestTemplate restTemplate, int page) throws Exception {
		
		String url = "https://reqres.in/api/users";
		if (page >0) {
			url += "?page=" + page;
		}
	
		RawData rawUsersData = restTemplate.getForObject(
				url, RawData.class);
		
		return rawUsersData;
	}
	
	
}
