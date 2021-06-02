package com.example.springmvcexample.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.springmvcexample.mybatis.entity.Job;

@Mapper
public interface JobMapper {
	public Job getJob(String id);

	public List<Job> getAllJobs();

	public int addJob(Job job);

	public int chgJob(Job job);

	public int delJob(String id);
}
