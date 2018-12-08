package com.niit.Dao;

import java.util.List;

import com.niit.Models.job;

public interface JobDao {
	void addJob(job job);
	List<job> getAllJobs();
}
