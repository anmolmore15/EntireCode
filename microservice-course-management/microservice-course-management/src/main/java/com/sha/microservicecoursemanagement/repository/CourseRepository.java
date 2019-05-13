package com.sha.microservicecoursemanagement.repository;

import java.util.List;

import com.sha.microservicecoursemanagement.model.Course;

public interface CourseRepository extends IGenericDao<Course> {
	    List<Course> filterCourses(final String content);

	    List<Course> filterCoursesByIdList(List<Long> idList);
}
