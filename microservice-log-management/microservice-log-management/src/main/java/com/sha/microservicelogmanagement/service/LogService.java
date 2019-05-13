package com.sha.microservicelogmanagement.service;

import java.util.List;

import com.sha.microservicelogmanagement.model.Log;
import com.sha.microservicelogmanagement.model.Summary;

public interface LogService {

	Log saveOrUpdate(Log log);

	Summary saveOrUpdate(Summary summary);

	List<Summary> findPopularCourses();
	
	Summary findSummaryByCourseId(Long courseId);

}
