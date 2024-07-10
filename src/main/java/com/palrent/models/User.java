package com.palrent.models;

import java.util.Date;
import java.util.List;
import org.springframework.format.annotation.DateTimeFormat;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message = "")
	@Size(min=3,message ="First Name must be at least 2 character")
	private String firstName;
	
	@NotEmpty(message = "")
	@Size(min=3,message ="Last Name must be at least 2 character")
	private String lastName;
	
	
	
	@NotEmpty(message = "")
	@Email(message = "Please enter a valid email!",regexp  = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}")
	//@Size(min = 6, message = "User Email Must be at least 6 charachters")
	private String email;

	@NotEmpty(message = "")
	@Size(min = 8, max = 128, message = "User Password Must be at least 8 charachters")
	private String password;
	
	@Transient
	@NotEmpty(message="Confirm Password is required!")
    @Size(min=8, max=128, message="Confirm Password must be between 8 and 128 characters")
	private String confirm;
	
	@NotNull(message = "Date of Birth should not be null")
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	private Date dateOfBirth ;
	
	@NotNull(message = "UrlImage should not be null")
	private String urlImage ; 
	
	@NotEmpty(message = "")
	@Size(min=10,message = "Phone number must be at least 10 Digit")
	private String phone ; 
	
	 
	 @Column(updatable = false)
		@DateTimeFormat(pattern = "yyyy-MM-dd")
		private Date createdAt;
		@DateTimeFormat(pattern = "yyyy-MM-dd")
		private Date updatedAt;

		@PrePersist
		protected void onCreate() {
			this.createdAt = new Date();
		}
	
	@OneToMany(mappedBy = "owner",fetch = FetchType.LAZY)
	List<Department> ownedDeparment; 
	
	@OneToMany(mappedBy = "user",fetch = FetchType.LAZY)
	List<UserBookDep> departments ; 
	
	@OneToMany(mappedBy = "reviewer",fetch = FetchType.LAZY)
	List<ReviewDep> reviewDeps;
	
	public User() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getUrlImage() {
		return urlImage;
	}

	public void setUrlImage(String urlImage) {
		this.urlImage = urlImage;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
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

	public List<Department> getOwnedDeparment() {
		return ownedDeparment;
	}

	public void setOwnedDeparment(List<Department> ownedDeparment) {
		this.ownedDeparment = ownedDeparment;
	}

	public List<UserBookDep> getDepartments() {
		return departments;
	}

	public void setDepartments(List<UserBookDep> departments) {
		this.departments = departments;
	}
	
	
	

}
