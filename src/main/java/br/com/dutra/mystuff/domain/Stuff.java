package br.com.dutra.mystuff.domain;

import java.util.Date;

import org.bson.types.ObjectId;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Id;
import com.google.code.morphia.annotations.PrePersist;

@Entity(value = "stuff", noClassnameStored = true)
public class Stuff {
	@Id
	private ObjectId id;

	private String name;
	private StuffSize size;
	private Integer quantity;
	
	private Object imageId;
	
	private Boolean active;
	private Boolean borrowed;
	
	private Date creationDate;
	private Date lastUpdateDate;
	
	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public StuffSize getSize() {
		return size;
	}

	public void setSize(StuffSize size) {
		this.size = size;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Object getImageId() {
		return imageId;
	}

	public void setImageId(Object imageId) {
		this.imageId = imageId;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Boolean getBorrowed() {
		return borrowed;
	}

	public void setBorrowed(Boolean borrowed) {
		this.borrowed = borrowed;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getLastUpdateDate() {
		return lastUpdateDate;
	}

	public void setLastUpdateDate(Date lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	@PrePersist
	public void prePersist() {
		this.creationDate = (creationDate == null) ? new Date() : creationDate;
		this.lastUpdateDate = (lastUpdateDate == null) ? creationDate : new Date();
	}

	public enum StuffSize {
		SMALL, MEDIUM, LARGE, HUGE
	}
}
