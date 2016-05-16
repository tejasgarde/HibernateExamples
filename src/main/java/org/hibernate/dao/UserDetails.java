package org.hibernate.dao;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity//(name="USER_DETAILS")
@Table(name="USER_DETAILS")
public class UserDetails {

	@Id
	@Column(name="USER_ID")
	private int userId;
	// Treate this field as filed which should be  persisted and apply hibernate Defaults, thats what happenning even when we dont make it default
	@Basic 
	private String userName;
	
	//@Transient this will make HB to ignore this field
	@Temporal(TemporalType.DATE)//THis will Save Date only , there are many options to save tiestamp as well
	private Date joinedDate;
	private String address;
	//@Lob without LOB its varchar(255)
	private String description;
	
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Date getJoinedDate() {
		return joinedDate;
	}
	public void setJoinedDate(Date joinedDate) {
		this.joinedDate = joinedDate;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
	
}
