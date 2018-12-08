/**
 * 
 */
app.factory('NotificationService',function($http){
	var notificationService={}
	
	notificationService.getAllNotifications=function(){
		return $http.get("http://localhost:9090/Project2MiddleWare/getallnotifications")
	}
	
	
	notificationService.getNotification=function(notificationId){
		return $http.get("http://localhost:9090/Project2MiddleWare/getnotification/"+notificationId)
	}
	
	notificationService.updateNotification=function(notificationId){
		return $http.put("http://localhost:9090/Project2MiddleWare/updatenotification/"+notificationId);
	}
	
	return notificationService;
})