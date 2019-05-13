package com.sha.microservicecoursemanagement.model;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Table(name = "course")
public class Course  implements IModel {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "author")
    private String author;

    @Column(name = "serial_number")
    private String serialNumber;

    @Column(name = "category")
    private String category;

    @Column(name = "publish_date")
    private LocalDate publishDate;
    
    public Course() {
    	
    }
    
    

	public Course(Long id, String title, String author, String serialNumber, String category, LocalDate publishDate) {
		this.id = id;
		this.title = title;
		this.author = author;
		this.serialNumber = serialNumber;
		this.category = category;
		this.publishDate = publishDate;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public LocalDate getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(LocalDate publishDate) {
		this.publishDate = publishDate;
	}
    
    

}
