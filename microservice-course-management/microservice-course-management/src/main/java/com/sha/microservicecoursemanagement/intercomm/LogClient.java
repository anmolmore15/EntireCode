package com.sha.microservicecoursemanagement.intercomm;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("log-service")
public interface LogClient {
	 @RequestMapping(method = RequestMethod.GET, value = "/service/popular", consumes = "application/json")
	    List<Long> getPopularCourses();
}
