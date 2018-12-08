package com.niit.Controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.niit.Dao.BlogPostLikeDao;
import com.niit.Models.BlogPost;
import com.niit.Models.BlogPostLikes;
import com.niit.Models.ErrorClazz;

@Controller
public class BlogPostLikeController {
	@Autowired
	private BlogPostLikeDao blogPostLikesDao;
	  @RequestMapping(value="/hasUserLikedBlogPost/{blogPostId}",method=RequestMethod.GET)
		public ResponseEntity<?> hasUserLikedBlogPost(@PathVariable int blogPostId,HttpSession session){
			String email=(String)session.getAttribute("email");
			if(email==null){
				ErrorClazz errorClazz=new ErrorClazz(5,"Unauthorized access.. please login");
				return new ResponseEntity<ErrorClazz>(errorClazz,HttpStatus.UNAUTHORIZED);
			}
			BlogPostLikes blogPostLikes=blogPostLikesDao.hasUserLikedBlogPost(blogPostId, email);
			return new ResponseEntity<BlogPostLikes>(blogPostLikes,HttpStatus.OK);
		}
	  @RequestMapping(value="/updateLikes/{blogPostId}",method=RequestMethod.PUT)
	  public ResponseEntity<?> updateLikes(@PathVariable int blogPostId,HttpSession session){
		  System.out.println("UPDATELIKES " + blogPostId);
		  String email=(String)session.getAttribute("email");
			if(email==null){
				ErrorClazz errorClazz=new ErrorClazz(5,"Unauthorized access.. please login");
				return new ResponseEntity<ErrorClazz>(errorClazz,HttpStatus.UNAUTHORIZED);
			}
			BlogPost blogPost=blogPostLikesDao.updateLikes(blogPostId,email);
			return new ResponseEntity<BlogPost>(blogPost,HttpStatus.OK);
	  }
		
	}






