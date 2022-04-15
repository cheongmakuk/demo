package mkc.exercise.ac1.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import mkc.exercise.ac1.service.SearchCriteria;
import mkc.exercise.ac1.service.UserService;

/**
 * Users RESTful api controller 
 * 
 * @author kcmak
 *
 */

@RestController
public class UserController {
	
	@GetMapping("/rest/v1/users")
	public String retrieveAllUsers(
			@RequestParam(value = "filter", required = false) String filter,
			@RequestParam(value = "sort_by", required = false) String sortBy){
		
		String resultString ="";
		ObjectMapper mapper = new ObjectMapper();
		UserService userService = new UserService();
		List<SearchCriteria> filterParams = new ArrayList<SearchCriteria>();
		
		
		if (filter != null) {
            Pattern pattern = Pattern.compile("(\\w+?)(:|<|>)(\\w+?),");
            Matcher matcher = pattern.matcher(filter + ",");
            while (matcher.find()) {
                filterParams.add(new SearchCriteria(matcher.group(1), matcher.group(2), matcher.group(3)));
            }
        }
		
		try {
			userService.init();
			resultString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(userService.findAllUsers(filterParams, sortBy));
		}catch(Exception e) {
			resultString ="Exception caught:" +e.getMessage();
		}
		
		return resultString;
	}
	
	@GetMapping("/rest/v1/users/{id}")
	public String retrieveUser(@PathVariable(value = "id", required = false) long id) {
		String resultString ="";
		ObjectMapper mapper = new ObjectMapper();
		UserService userService = new UserService();
		try {
			userService.init();
			resultString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(userService.findSingleUserWithAge(id));
		}catch(Exception e) {
			resultString ="Exception caught:" +e.getMessage();
		}
		
		return resultString;
	}

}
