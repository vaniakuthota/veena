/**
 * UserService
 */
app.factory('UserService',function($http){
	var userService={}
	
	userService.registration=function(user){//user from controller
		return $http.post("http://localhost:9090/Project2MiddleWare/registration",user)
	}
	
	userService.login=function(user){
		return $http.put("http://localhost:9090/Project2MiddleWare/login",user)
	}
	
	
	userService.logout=function(){
		return $http.put("http://localhost:9090/Project2MiddleWare/logout")
	}
	
	return userService;
})


