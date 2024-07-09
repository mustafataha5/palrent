package com.palrent.models;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="addresses")
public class Address {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message = "")
	@Size(min=1,message = "Department Number must be at least 1 digit.")
	private String departmentNum;
	
	@NotEmpty(message = "")
	@Size(min=1,message = "Building Number must be at least 1 digit.")
	private String buildingNum;
	
	
	@NotEmpty(message = "")
	@Size(min=2,message = "Street Name must be at least 2 character.")
	private String street;
	
	@NotEmpty(message = "")
	@Size(min=4,message = "City Name must be at least 2 character.")
	private String city;
	
	@NotNull
	private Double locationX;
	@NotNull
	private Double locationY;
	
	@Column(updatable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createdAt;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updatedAt;

	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}

	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}
	
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="department_id")
	private Department department;
	public Address() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDepartmentNum() {
		return departmentNum;
	}

	public void setDepartmentNum(String departmentNum) {
		this.departmentNum = departmentNum;
	}

	public String getBuildingNum() {
		return buildingNum;
	}

	public void setBuildingNum(String buildingNum) {
		this.buildingNum = buildingNum;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Double getLocationX() {
		return locationX;
	}

	public void setLocationX(Double locationX) {
		this.locationX = locationX;
	}

	public Double getLocationY() {
		return locationY;
	}

	public void setLocationY(Double locationY) {
		this.locationY = locationY;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
	

	

}
