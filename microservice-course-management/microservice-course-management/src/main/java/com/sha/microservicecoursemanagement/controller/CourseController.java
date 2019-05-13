package com.sha.microservicecoursemanagement.controller;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sha.microservicecoursemanagement.intercomm.LogClient;
import com.sha.microservicecoursemanagement.intercomm.UserClient;
import com.sha.microservicecoursemanagement.model.Transaction;
import com.sha.microservicecoursemanagement.service.CourseService;

@RestController
@RequestMapping("/service")
public class CourseController {
	  @Autowired
	    private UserClient userClient;

	    @Autowired
	    private LogClient logClient;

	    @Autowired
	    private CourseService courseService;
	    
	    @PostMapping("/user")
	    public ResponseEntity<?> filterTransactions(@RequestBody Long userId){
	        return new ResponseEntity<>(courseService.filterTransactionsOfUser(userId), HttpStatus.OK);
	    }

	    @GetMapping("/popular")
	    public ResponseEntity<?> popularCourses(){
	        List<Long> popularIdList = logClient.getPopularCourses();
	        if(popularIdList==null || popularIdList.isEmpty()){
	            return ResponseEntity.notFound().build();
	        }
	        return new ResponseEntity<>(courseService.filterCoursesByIdList(popularIdList), HttpStatus.OK);
	    }
	    
	    @GetMapping("/students")
	    public ResponseEntity<?> getUsers(){
	    	List<Long> list = Arrays.asList(1L,2L,3L);
	    	List<String> users = userClient.getUsers(list);
	    	return new ResponseEntity<>(users, HttpStatus.OK);
	    }
	    
	    @PostMapping("/")
	    public ResponseEntity<?> allCourses(){
	        return new ResponseEntity<>(courseService.allCourses(), HttpStatus.OK);
	    }
	    
	    @PostMapping("/filter")
	    public ResponseEntity<?> filterCourses(@RequestBody String text){
	        return new ResponseEntity<>(courseService.filterCourses(text), HttpStatus.OK);
	    }
	    
	    @PostMapping("/enroll")
	    public ResponseEntity<?> saveTransaction(@RequestBody Transaction transaction){
	        transaction.setDateOfIssue(LocalDateTime.now());
	        transaction.setCourse(courseService.findCourseById(transaction.getCourse().getId()));
	        courseService.saveTransaction(transaction);
	        return ResponseEntity.ok(transaction);
	    }
	    
	    @PostMapping("/students")
	    public ResponseEntity<?> findCourseStudents(@RequestBody Long courseId){
	        List<Transaction> list = courseService.filterTransactionsOfCourse(courseId);
	        if(list!=null && !list.isEmpty()){
	            List<Long> userIdList = list.parallelStream().map(t->t.getUserId()).collect(Collectors.toList());
	            List<String> students = userClient.getUsers(userIdList);
	            return ResponseEntity.ok(students);
	        }
	        return ResponseEntity.notFound().build();
	    }
}
