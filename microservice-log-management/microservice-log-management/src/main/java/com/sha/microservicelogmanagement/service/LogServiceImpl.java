package com.sha.microservicelogmanagement.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.sha.microservicelogmanagement.Repository.LogRepository;
import com.sha.microservicelogmanagement.Repository.SummaryRepository;
import com.sha.microservicelogmanagement.model.Log;
import com.sha.microservicelogmanagement.model.Summary;

@Transactional
@Service
public class LogServiceImpl implements  LogService {
	
	    @Autowired
	    private LogRepository logRepository;

	    @Autowired
	    private SummaryRepository summaryRepository;
	    
	    @Override
	    public Summary findSummaryByCourseId(Long courseId) {
	        return summaryRepository.findByCourseId(courseId).orElse(null);
	    }
	    
	    @Override
	    public Log saveOrUpdate(Log log) {
	    	Summary existSummary = summaryRepository.findByCourseId(log.getCourseId()).orElse(null);
	        if(existSummary!=null){
	            summaryRepository.delete(existSummary);
	            existSummary.setHitCount(existSummary.getHitCount()+1);
	            summaryRepository.save(existSummary);
	        }else{
	            Summary summary = new Summary();
	            summary.setCourseId(log.getCourseId());
	            summary.setHitCount(1L);
	            summaryRepository.save(summary);
	        }
	    
	        log.setId(UUID.randomUUID());
	        logRepository.save(log);
	        return log;
	    }
	    
	    @Override
	    public Summary saveOrUpdate(Summary summary) {
	        summaryRepository.save(summary);
	        return summary;
	    }


	    @Override
	    public List<Summary> findPopularCourses(){
	        return summaryRepository.findPopularCourses();
	    }
	    
	 

}
