package com.sha.microservicelogmanagement.model;

import java.io.Serializable;

import org.springframework.data.cassandra.core.cql.Ordering;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.*;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@Table("summary")
public class Summary implements Serializable  {
	
	@PrimaryKeyColumn(name = "course_id", type = PrimaryKeyType.PARTITIONED)
    private Long courseId;

    @PrimaryKeyColumn(name = "hit_count", ordinal = 0, type = PrimaryKeyType.CLUSTERED, ordering = Ordering.DESCENDING)
    private Long hitCount;

    public Summary() {
    	
    }
    
        
	public Summary(Long courseId, Long hitCount) {
		this.courseId = courseId;
		this.hitCount = hitCount;
	}


	public Long getCourseId() {
		return courseId;
	}

	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}

	public Long getHitCount() {
		return hitCount;
	}

	public void setHitCount(Long hitCount) {
		this.hitCount = hitCount;
	}
    
    

}
