package com.niit.Dao;

import java.util.List;

import com.niit.Models.BlogComment;

public interface BlogCommentDao {
	void addBlogComment(BlogComment blogComment);//insert into blogcomment table
	List<BlogComment> getAllBlogComments(int blogPostId);
	    
}
