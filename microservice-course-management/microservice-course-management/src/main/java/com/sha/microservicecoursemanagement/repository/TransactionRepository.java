package com.sha.microservicecoursemanagement.repository;

import java.util.List;

import com.sha.microservicecoursemanagement.model.Transaction;

public interface TransactionRepository extends IGenericDao<Transaction> {
	    List<Transaction> findAllTransactionsOfUser(Long userId);

	    List<Transaction> findAllTransactionsOfCourse(Long courseId);
}
