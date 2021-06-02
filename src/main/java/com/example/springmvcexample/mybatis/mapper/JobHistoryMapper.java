package com.example.springmvcexample.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.springmvcexample.mybatis.entity.JobHistory;

@Mapper
public interface JobHistoryMapper {
	public JobHistory getJobHistory(Integer id);

	public List<JobHistory> getAllJobHistories();

	public int addJobHistory(JobHistory jobHistory);

	public int chgJobHistory(JobHistory jobHistory);

	public int delJobHistory(Integer id);
}
