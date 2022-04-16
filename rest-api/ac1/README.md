# RESTful API demo application for University of Cardiff

This is the RESTful API demo application for University of Cardiff. It is builded by Sprint boot v2.6.6 and Java 11.

## Build the Project

  	mvn clean install
 
## Run the application
	$ ./mvnw clean spring-boot:run
    
## REST API
There are two retrieve functions in this API:

### 1. Retrieve all users

#### Request

`GET /rest/v1/users`

	curl -v localhost:8080/rest/v1/users
    
#### Response sample
	{
        "meta" : 
        {
          "total" : 12,
          "count" : 12,
          "page" : 1,
          "totalPages" : 1,
          "statusCode" : 200,
          "contentType" : "application/json"
        },
        "data" : [ 
          {
            "id" : 1,
            "email" : "george.bluth@reqres.in",
            "firstName" : "George",
            "lastName" : "Bluth",
            "avatar" : "https://reqres.in/img/faces/1-image.jpg"
  		  }, {
            "id" : 2,
            "email" : "janet.weaver@reqres.in",
            "firstName" : "Janet",
            "lastName" : "Weaver",
            "avatar" : "https://reqres.in/img/faces/2-image.jpg"
          }, {
            "id" : 3,
            "email" : "emma.wong@reqres.in",
            "firstName" : "Emma",
            "lastName" : "Wong",
            "avatar" : "https://reqres.in/img/faces/3-image.jpg"
          }, {
            "id" : 4,
            "email" : "eve.holt@reqres.in",
            "firstName" : "Eve",
            "lastName" : "Holt",
            "avatar" : "https://reqres.in/img/faces/4-image.jpg"
          }, {
          	"id" : 5,
          	"email" : "charles.morris@reqres.in",
          	"firstName" : "Charles",
          	"lastName" : "Morris",
          	"avatar" : "https://reqres.in/img/faces/5-image.jpg"
          }, {
            "id" : 6,
            "email" : "tracey.ramos@reqres.in",
            "firstName" : "Tracey",
            "lastName" : "Ramos",
            "avatar" : "https://reqres.in/img/faces/6-image.jpg"
          }, {
            "id" : 7,
            "email" : "michael.lawson@reqres.in",
            "firstName" : "Michael",
            "lastName" : "Lawson",
            "avatar" : "https://reqres.in/img/faces/7-image.jpg"
          }, {
            "id" : 8,
            "email" : "lindsay.ferguson@reqres.in",
            "firstName" : "Lindsay",
            "lastName" : "Ferguson",
            "avatar" : "https://reqres.in/img/faces/8-image.jpg"
          }, {
            "id" : 9,
            "email" : "tobias.funke@reqres.in",
            "firstName" : "Tobias",
            "lastName" : "Funke",
            "avatar" : "https://reqres.in/img/faces/9-image.jpg"
          }, {
            "id" : 10,
            "email" : "byron.fields@reqres.in",
            "firstName" : "Byron",
            "lastName" : "Fields",
            "avatar" : "https://reqres.in/img/faces/10-image.jpg"
          }, {
            "id" : 11,
            "email" : "george.edwards@reqres.in",
            "firstName" : "George",
            "lastName" : "Edwards",
            "avatar" : "https://reqres.in/img/faces/11-image.jpg"
          }, {
            "id" : 12,
            "email" : "rachel.howell@reqres.in",
            "firstName" : "Rachel",
            "lastName" : "Howell",
            "avatar" : "https://reqres.in/img/faces/12-image.jpg"
          } ]
 	}
    
 #### Request by filter
 You can apply a filter by filter parameters.
 
  `GET /rest/v1/users?filter={filterParams}`
 
 ##### Filter parameters 
 {fieldName}+{operator}+{value}, ...
 
 For String field, operator can be ":" representing "equal". For Number field, operator can be ">", ":", "<" representing "greater than", "equal" and "less than".
 
 ##### Example
 	curl -v localhost:8080/rest/v1/users?filter=firstName:Emma
    
 #### Response sample
 	{ 
        "meta" : 
        { 
        	"total" : 12, 
            "count" : 1, 
            "page" : 1, 
            "totalPages" : 1, 
            "statusCode" : 200, 
            "contentType" : 
            "application/json"
         }, 
         "data" : [ 
         	{ 
              "id" : 3, 
              "email" : "emma.wong@reqres.in", 
              "firstName" : "Emma", 
              "lastName" : "Wong", 
              "avatar" : "https://reqres.in/img/faces/3-image.jpg" 
            } 
          ] 
    }
    
 #### Request by sorting
 
 You can apply an ascending order sorting by a field name.
 
 `GET /rest/v1/users?sort_by={sortByParam}`
 
 ##### Sort by parameter
 {fieldName}
 
 ##### Example
 	curl -v localhost:8080/rest/v1/users?sort_by=firstName
    
 #### Response sample
 
 	{ 
        "meta" : 
        { 	
        	"total" : 12, 
            "count" : 12, 
            "page" : 1, 
            "totalPages" : 1, 
            "statusCode" : 200, 
            "contentType" : "application/json" 
        }, 
        "data" : [ 
        	{ 
              "id" : 10,
              "email" : "byron.fields@reqres.in", 
              "firstName" : "Byron", 
              "lastName" : "Fields", 
              "avatar" : "https://reqres.in/img/faces/10-image.jpg" 
        	}, { 
              "id" : 5, 
              "email" : "charles.morris@reqres.in", 
              "firstName" : "Charles", 
              "lastName" : "Morris", 
              "avatar" : "https://reqres.in/img/faces/5-image.jpg" 
            }, {
              "id" : 3, 
              "email" : "emma.wong@reqres.in", 
              "firstName" : "Emma", 
              "lastName" : "Wong", 
              "avatar" : "https://reqres.in/img/faces/3-image.jpg" 
            }, {
              "id" : 4, 
              "email" : "eve.holt@reqres.in", 
              "firstName" : "Eve", 
              "lastName" : "Holt", 
              "avatar" : "https://reqres.in/img/faces/4-image.jpg" 
            }, {
              "id" : 1, 
              "email" : "george.bluth@reqres.in", 
              "firstName" : "George", 
              "lastName" : "Bluth", 
              "avatar" : "https://reqres.in/img/faces/1-image.jpg" 
            }, {
              "id" : 11, 
              "email" : "george.edwards@reqres.in", 
              "firstName" : "George", 
              "lastName" : "Edwards", 
              "avatar" : "https://reqres.in/img/faces/11-image.jpg" 
            }, {
              "id" : 2, 
              "email" : "janet.weaver@reqres.in", 
              "firstName" : "Janet", 
              "lastName" : "Weaver", 
              "avatar" : "https://reqres.in/img/faces/2-image.jpg" 
            }, {
              "id" : 8, 
              "email" : "lindsay.ferguson@reqres.in", 
              "firstName" : "Lindsay", 
              "lastName" : "Ferguson", 
              "avatar" : "https://reqres.in/img/faces/8-image.jpg" 
            }, {
              "id" : 7, 
              "email" : "michael.lawson@reqres.in", 
              "firstName" : "Michael", 
              "lastName" : "Lawson", 
              "avatar" : "https://reqres.in/img/faces/7-image.jpg" 
            }, {
              "id" : 12, 
              "email" : "rachel.howell@reqres.in", 
              "firstName" : "Rachel", 
              "lastName" : "Howell", 
              "avatar" : "https://reqres.in/img/faces/12-image.jpg" 
            }, {
              "id" : 9, 
              "email" : "tobias.funke@reqres.in", 
              "firstName" : "Tobias", 
              "lastName" : "Funke", 
              "avatar" : "https://reqres.in/img/faces/9-image.jpg" 
            }, {
              "id" : 6, 
              "email" : "tracey.ramos@reqres.in", 
              "firstName" : "Tracey", 
              "lastName" : "Ramos", 
              "avatar" : "https://reqres.in/img/faces/6-image.jpg" 
            } 
         ] 
   	 }
     
### 2. Retrieve single user
Retrieve single user by id. The age field is added.

#### Request

`GET /rest/v1/users/{id}`

	curl -v localhost:8080/rest/v1/users/1
    
#### Response sample

	{
	   "meta" : 
	   {
		"total" : 12,
		"count" : 1,
		"page" : 1,
		"totalPages" : 2,
		"statusCode" : 200,
		"contentType" : "application/json"
	   },
	   "data" : 
	   {
	   	"id" : 1,
	      	"email" : "george.bluth@reqres.in",
	      	"firstName" : "George",
	      	"lastName" : "Bluth",
	      	"avatar" : "https://reqres.in/img/faces/1-image.jpg",
	      	"age" : 24
	   }
	}
    
### Error Response

The error response for internal server error

	{
	   "meta:
	   {
		"total":0,
		"count":0,
		"page":0,
		"totalPages":0,
		"statusCode":500,
		"contentType":"application/json"
	   },
	   "data" : null
   	}
