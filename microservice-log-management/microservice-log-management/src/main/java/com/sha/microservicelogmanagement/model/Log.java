package com.sha.microservicelogmanagement.model;

import com.datastax.driver.core.DataType;

import lombok.Data;

import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;


@Data
@Table("log")
public class Log implements Serializable { 

	@PrimaryKey
	@CassandraType(type=DataType.Name.UUID)
	private UUID id;

	@Column("ip")
	private String ip;
	
	@Column("course_id")
	private Long courseId;
	
	@Column("log_date")
	private LocalDateTime logDate;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Long getCourseId() {
		return courseId;
	}

	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}

	public LocalDateTime getLogDate() {
		return logDate;
	}

	public void setLogDate(LocalDateTime logDate) {
		this.logDate = logDate;
	}

	public Log(UUID id, String ip, Long courseId, LocalDateTime logDate) {
		this.id = id;
		this.ip = ip;
		this.courseId = courseId;
		this.logDate = logDate;
	}

	public Log()
	{
		
	}
	
	
}
