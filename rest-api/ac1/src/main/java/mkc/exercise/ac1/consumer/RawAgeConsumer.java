package mkc.exercise.ac1.consumer;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.client.RestTemplate;

import mkc.exercise.ac1.model.in.RawAge;

/**
 * Consumer for retrieving the age data from "https://api.agify.io/"
 * 
 * @author kcmak
 *
 */
public class RawAgeConsumer {
	private RestTemplate restTemplate;
	private RestTemplate getRestTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
	
	public RawAge getUserAge(String name) throws Exception{
		if (this.restTemplate == null)
			restTemplate = getRestTemplate(new RestTemplateBuilder());
		return getUserAge(restTemplate, name);
	}
	
	
	public RawAge getUserAge(RestTemplate restTemplate, String name) throws Exception{
		String url = "https://api.agify.io/";
	
		RawAge rawAge = restTemplate.getForObject(
				url+"?name="+name, RawAge.class);
		
		return rawAge;
	}
}
