/**
 * JobService
 */
app.factory('JobService',function($http){
var jobService={}
	
jobService.addJob=function(job){
	return $http.post("http://localhost:9090/Project2MiddleWare/addjob",job)
}

jobService.getAlljobs=function(){
	return $http.get("http://localhost:9090/Project2MiddleWare/getalljobs")
}

return jobService;
})