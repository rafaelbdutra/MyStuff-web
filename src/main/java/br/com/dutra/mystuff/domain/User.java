package br.com.dutra.mystuff.domain;

import java.util.Date;
import java.util.List;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Id;
import com.google.code.morphia.annotations.PrePersist;

@Entity(value = "user", noClassnameStored = true)
public class User {

	@Id
	private String email;
	private String password;

	private String firstName;
	private String lastName;
	
	private List<Stuff> stuffs;
	
	private Date creationDate;
	private Date lastUpdateDate;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public List<Stuff> getStuffs() {
		return stuffs;
	}
	
	public void setStuffs(List<Stuff> stuffs) {
		this.stuffs = stuffs;
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
}
