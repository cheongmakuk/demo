package mkc.exercise.ac1.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import mkc.exercise.ac1.consumer.RawAgeConsumer;
import mkc.exercise.ac1.consumer.RawUserConsumer;
import mkc.exercise.ac1.model.in.RawAge;
import mkc.exercise.ac1.model.in.RawData;
import mkc.exercise.ac1.model.in.RawUser;
import mkc.exercise.ac1.model.out.Meta;
import mkc.exercise.ac1.model.out.User;
import mkc.exercise.ac1.model.out.UserSingleDataSet;
import mkc.exercise.ac1.model.out.UserWithAge;
import mkc.exercise.ac1.model.out.UsersDataSet;

/**
 * User service for handling user data
 * 
 * @author kcmak
 *
 */

public class UserService {

	private List<RawData> rawDataList;
	
	
	public UserService() {
		
	}
	
	/**
	 * initial the data by retrieving from data sources
	 */
	public void init() throws Exception{
		this.rawDataList = new ArrayList<RawData>();
		RawUserConsumer rawUserConsumer = new RawUserConsumer();
		
		RawData rawDataPage1 = rawUserConsumer.getRawDataByPage(1);
		this.rawDataList.add(rawDataPage1);
		
		int totalPages = rawDataPage1.getTotal_pages();
		
		if (totalPages>1) {
		for (int pageIndex=2; pageIndex<=totalPages; pageIndex++) {
				RawData tempRawData = rawUserConsumer.getRawDataByPage(pageIndex);
				this.rawDataList.add(tempRawData);
			}
		}
		
	}
	/**
	 * Find all the users from the sources with filter and sorting
	 * 
	 * @param params the list of search criteria
	 * @param sortBy the field name using for sorting
	 * @return the users data Set
	 */
	
	public UsersDataSet findAllUsers(List<SearchCriteria> params, 
			String sortBy) {
		
		Meta meta = createMeta();
		List<User> userList = new ArrayList();
		
		//combined all pages data to one page
		meta.setPage(1);
		meta.setTotalPages(1);
		
		if (this.rawDataList.size()>0) {
			
			RawData firstRawData = this.rawDataList.get(0);
			
			meta.setTotal(firstRawData.getTotal());
			meta.setCount(firstRawData.getTotal());
			
			userList = new ArrayList<User>();
			
			for (RawData tempRawData:this.rawDataList) {
				
				for (RawUser rawUser: tempRawData.getData()) {
					User user = new User();
					user.setAvatar(rawUser.getAvatar());
					user.setEmail(rawUser.getEmail());
					user.setFirstName(rawUser.getFirst_name());
					user.setLast_name(rawUser.getLast_name());
					user.setId(rawUser.getId());
					
					userList.add(user);
				}
			}
			
			//filter the user list by the search criteria
			for (SearchCriteria searchCriteria: params) {
				switch (searchCriteria.getKey()) {
				case "firstName":
					userList = userList.stream().filter(user->searchCriteria.getValue().equals(user.getFirstName())).collect(Collectors.toList());
					break;
				case "lastName":
					userList = userList.stream().filter(user->searchCriteria.getValue().equals(user.getLastName())).collect(Collectors.toList());
					break;
				case "email":
					userList = userList.stream().filter(user->searchCriteria.getValue().equals(user.getEmail())).collect(Collectors.toList());
					break;
				case "avatar":
					userList = userList.stream().filter(user->searchCriteria.getValue().equals(user.getAvatar())).collect(Collectors.toList());
					break;
				case "id":{
					if (isNumeric(searchCriteria.getValue().toString())) {
						switch (searchCriteria.getOperation()) {
		                case ":":
		                	userList = userList.stream().filter(user->Long.parseLong((String)searchCriteria.getValue())==user.getId()).collect(Collectors.toList());
		                	break;
		                case ">":
		                	userList = userList.stream().filter(user->user.getId()>Long.parseLong((String)searchCriteria.getValue())).collect(Collectors.toList());
		                	break;
		                case "<":
		                	userList = userList.stream().filter(user->user.getId()<Long.parseLong((String)searchCriteria.getValue())).collect(Collectors.toList());
		                	break;
						}
					}
					}
				}
			}
			
			//sort the user list by the field name
			if(sortBy != null) {
				switch (sortBy) {
				case "firstName":
					userList = userList.stream().sorted((u1, u2) -> (u1.getFirstName()).compareTo(u2.getFirstName())).collect(Collectors.toList());
					break;
				case "lastName":
					userList = userList.stream().sorted((u1, u2) -> (u1.getLastName()).compareTo(u2.getLastName())).collect(Collectors.toList());
					break;
				case "email":
					userList = userList.stream().sorted((u1, u2) -> (u1.getEmail()).compareTo(u2.getEmail())).collect(Collectors.toList());
					break;
				case "avatar":
					userList = userList.stream().sorted((u1, u2) -> (u1.getAvatar()).compareTo(u2.getAvatar())).collect(Collectors.toList());
					break;
				case "id":
					userList = userList.stream().sorted((u1, u2) -> ((Long)u1.getId()).compareTo((Long)u2.getId())).collect(Collectors.toList());
					break;
				}
			}
				
			meta.setCount(userList.size());
		}else {
			meta.setTotal(0);
			meta.setCount(0);
			
			userList = new ArrayList<User>();
		}
		
		UsersDataSet usersDataSet = new UsersDataSet();
		usersDataSet.setMeta(meta);
		usersDataSet.setData(userList);
		
		return usersDataSet;
	}
	
	/**
	 * Find single user from the sources with age
	 * 
	 * @param id user id
	 * @return single user data set
	 */
	
	public UserSingleDataSet findSingleUserWithAge(long id) {
		Meta meta = createMeta();
		UserWithAge user = null;
		try {
			if (this.rawDataList.size()>0) {
				
				RawData firstRawData = this.rawDataList.get(0);
				
				meta.setTotal(firstRawData.getTotal());
				meta.setTotalPages(firstRawData.getTotal_pages());
				
				for (RawData tempRawData:this.rawDataList) {
					
					List<RawUser> rawUserList = tempRawData.getData().stream().filter(rUser->id==rUser.getId()).collect(Collectors.toList());
					
					if (rawUserList.size()>=1) {
						meta.setCount(1);
						meta.setPage(tempRawData.getPage());
						
						RawUser rawUser = rawUserList.get(0);
						user = new UserWithAge();
						user.setAvatar(rawUser.getAvatar());
						user.setEmail(rawUser.getEmail());
						user.setFirstName(rawUser.getFirst_name());
						user.setLast_name(rawUser.getLast_name());
						user.setId(rawUser.getId());
						break;
					}
				}
				
				//cannot find the user by id
				if (user == null) {
					meta.setCount(0);
					meta.setPage(0);
				}else {
					RawAgeConsumer rawAgeConsumer = new RawAgeConsumer();
					RawAge rawAge = rawAgeConsumer.getUserAge(user.getFirstName());
					user.setAge(rawAge.getAge());
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
			meta.setStatusCode(Meta.STATUS_CODE_SERVER_ERROR);
		}
		
		UserSingleDataSet usersDataSet = new UserSingleDataSet();
		usersDataSet.setMeta(meta);
		usersDataSet.setData(user);
		
		return usersDataSet;
	}
	
	
	public Meta createMeta() {
		Meta meta = new Meta();
		
		meta.setContentType(Meta.CONTENT_TYPE_JSON);
		meta.setStatusCode(Meta.STATUS_CODE_OK);
	
		return meta;
	}
	
	//-- Utility --//
	private boolean isNumeric(final String str) {
        try {
            Long.parseLong(str);
        } catch (final NumberFormatException e) {
            return false;
        }
        return true;
    }
}
