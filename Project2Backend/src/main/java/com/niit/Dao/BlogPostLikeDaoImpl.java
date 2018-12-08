package com.niit.Dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.Models.BlogPost;
import com.niit.Models.BlogPostLikes;
import com.niit.Models.User;
@Repository
@Transactional
public class BlogPostLikeDaoImpl implements BlogPostLikeDao {
	@Autowired
	private SessionFactory sessionFactory;

	public BlogPostLikes hasUserLikedBlogPost(int blogPostId, String email) {
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from BlogPostLikes where blogPost.id=? and user.email=?");
		query.setInteger(0,blogPostId);
		query.setString(1,email);
		BlogPostLikes blogPostLikes=(BlogPostLikes)query.uniqueResult();
		
		return blogPostLikes;
	}

	public BlogPost updateLikes(int blogPostId, String email) {
		Session session=sessionFactory.getCurrentSession();
BlogPostLikes blogPostLikes=hasUserLikedBlogPost(blogPostId, email);//previous value
		
		BlogPost blogPost=(BlogPost)session.get(BlogPost.class,blogPostId);
		User user=(User)session.get(User.class,email);
		if(blogPostLikes==null){//glyphicon black color, and on clicked  - liked it now
			//insert and increment, update
			blogPostLikes=new BlogPostLikes();
			blogPostLikes.setBlogPost(blogPost);
			blogPostLikes.setUser(user);
			session.save(blogPostLikes);//insert into blogpostlikes 
			blogPost.setLikes(blogPost.getLikes() + 1);// similar to blogpost.likes = blogpost.likes + 1
			//update blogpost set likes=? where id=?
			session.update(blogPost);
		}
		//The blogpost is previously liked by the user, but now the user has unliked it
		else{//previously liked the post, but now unliked it  - unlike
			//Decrement the number of likes
			//delete blogpostlikes
			session.delete(blogPostLikes);//delete from blogpostlikes where likedId=?
			blogPost.setLikes(blogPost.getLikes() - 1);
	        session.update(blogPost);//update blogpost set likes= likes -1 where id=?
			
		}
		return blogPost;
		
		
		
	}

}
