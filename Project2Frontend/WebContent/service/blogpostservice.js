/**
 * BlogService
 */
app.factory('BlogService',function($http){
	var blogService={}
	
	blogService.addBlog=function(blog){
		return $http.post("http://localhost:9090/Project2MiddleWare/addblogpost",blog)
	}
	blogService.getBlogsWaitingForApproval=function(){
		return $http.get("http://localhost:9090/Project2MiddleWare/blogswaitingforapproval")
	}
	
	blogService.getBlogsApproved=function(){
		return $http.get("http://localhost:9090/Project2MiddleWare/blogsapproved")
	}
	
	blogService.getBlog=function(blogPostId){
		return $http.get("http://localhost:9090/Project2MiddleWare/getBlog/"+blogPostId)
	}
	blogService.approve=function(blogPost){
    	return $http.put("http://localhost:9090/Project2MiddleWare/approve",blogPost)
    }	
	
	blogService.reject=function(blogPost,rejectionReason){
		return $http.put("http://localhost:9090/Project2MiddleWare/reject/"+rejectionReason,blogPost)
	}
	blogService.hasUserLikedBlogPost=function(blogPostId){
		return $http.get("http://localhost:9090/Project2MiddleWare/hasUserLikedBlogPost/"+blogPostId);
	}
	
	blogService.updateLikes=function(blogPostId){
		return $http.put("http://localhost:9090/Project2MiddleWare/updateLikes/"+blogPostId);
	}
	
	blogService.addBlogComment=function(blogComment){
		//newly created blogcomment object with the values for two properties - blogPost, commentTxt
		//blogComment {'blogPost':{},'commentTxt':'Thanks'}
		return $http.post("http://localhost:9090/Project2MiddleWare/addblogcomment",blogComment)
	}
	
	blogService.getAllBlogComments=function(blogPostId){
	return $http.get("http://localhost:9090/Project2MiddleWare/getblogcomments/"+blogPostId)	
	}
	
	
	
	
	
	
	return blogService;
})
