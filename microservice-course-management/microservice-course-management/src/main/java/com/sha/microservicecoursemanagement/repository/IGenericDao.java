package com.sha.microservicecoursemanagement.repository;

import java.util.List;

import org.hibernate.Session;

import com.sha.microservicecoursemanagement.model.IModel;

public interface IGenericDao<T extends IModel> {
	    T find(final Long id);
	    List<T> findAll();
	    void save(final T entity);
	    T update(final T entity);
	    void delete(final Long id);
	    T findReference(final Long id);
	    Session getSession();
}
