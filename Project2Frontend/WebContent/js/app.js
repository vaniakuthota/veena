var app=angular.module("app",['ngRoute','ngCookies'])

app.config(function($routeProvider){
	$routeProvider
	.when('/registration',{controller:'UserCtrl',templateUrl:'views/registration.html'})
	.when('/login',{controller:'UserCtrl',templateUrl:'views/login.html'})
	.when('/home',{controller:'NotificationCtrl',templateUrl:'views/home.html'})
	.when('/addjob',{controller:'JobCtrl',templateUrl:'views/jobform.html'})
	.when('/getalljobs',{controller:'JobCtrl',templateUrl:'views/job.html'})
	.when('/addblog',{controller:'BlogCtrl',templateUrl:'views/blogpost.html'})
	.when('/blogsWaitingForApproval/:id',{controller:'BlogCtrl',templateUrl:'views/blogsWaitingForApproval.html'})
	.when('/blogsApproved/:id',{controller:'BlogCtrl',templateUrl:'views/blogsApproved.html'})
	.when('/getBlogApprovalForm/:id',{controller:'BlogInDetailCtrl',templateUrl:'views/blogApprovalForm.html'})
	.when('/getBlogApproved/:id',{controller:'BlogInDetailCtrl',templateUrl:'views/blogdetails.html'})
	.when('/getnotification/:id',{controller:'NotificationCtrl',templateUrl:'views/notificationdetails.html'})
	.when('/suggestedusers',{controller:'FriendCtrl',templateUrl:'views/suggestedusers.html'})
.when('/pendingrequests',{controller:'FriendCtrl',templateUrl:'views/pendingrequests.html'})
.when('/listoffriends',{controller:'FriendCtrl',templateUrl:'views/friendslist.html'})
.when('/uploadprofilepic',{templateUrl:'views/uploadprofilepic.html'})
.when('/chat',{
		templateUrl:'views/chat.html',
		controller:'ChatCtrl'
	})
	.otherwise({templateUrl:'views/home.html'})
})

app.run(function($cookieStore,$rootScope,UserService,$location){
	if($rootScope.user==undefined)
		$rootScope.user=$cookieStore.get('loggedInUser')//add user variable to the newly created $rootScope object
		
		$rootScope.logout=function(){//function is called from index.html
		  alert('logout function is called')
		  UserService.logout().then(function(response){
			  delete $rootScope.user
			  $cookieStore.remove('loggedInUser')
			  $location.path('/login')
		  },function(response){
			  delete $rootScope.user
			  $cookieStore.remove('loggedInUser')
			  if(response.status==401)//UNAUTHORIZED
				  $location.path('/login')
		  })
		}
	
			
		
})

