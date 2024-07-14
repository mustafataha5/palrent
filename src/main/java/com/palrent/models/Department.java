package com.palrent.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "departments")
public class Department {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Min(value = 1)
	private Integer numOfRoom;

	@NotNull
	@Min(value = 1)
	private Integer numOfBath;

	@NotNull
	@Min(value = 1)
	private Integer numOfBed;

	@NotNull
	@Min(value = 1)
	private Integer area;

	@NotNull
	@Min(value = 1)
	private Integer numOfGuest;

	@NotNull
	@Min(value = 1, message = "Price must be greater than 1 ")
	private Double price;

	@NotNull
	@Size(min = 3 ,max =10)
	private String title;

	@NotNull
	@Size(min = 3)
	private String description;

	@NotEmpty(message = "")
	@Size(min = 1, message = "Department Number must be at least 1 digit.")
	private String departmentNum;

	@NotEmpty(message = "")
	@Size(min = 1, message = "Building Number must be at least 1 digit.")
	private String buildingNum;

	@NotEmpty(message = "")
	@Size(min = 2, message = "Street Name must be at least 2 character.")
	private String street;

	@NotEmpty(message = "")
	@Size(min = 4, message = "City Name must be at least 4 character.")
	private String city;

	private Double locationX;
	private Double locationY;

	private Boolean approval;

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

	public Department() {
        this.approval = false;
        this.images = new ArrayList<>();
        this.offers = new ArrayList<>();
        this.rules = new ArrayList<>();
//        this.images.add("https://images.pexels.com/photos/1918291/pexels-photo-1918291.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1");
//        this.images.add("https://images.pexels.com/photos/1571468/pexels-photo-1571468.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1" );
//        this.images.add("https://images.pexels.com/photos/5502218/pexels-photo-5502218.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1 ");
//    
//	
//
//		this.approval = false;
//		this.images = new ArrayList<>();
//		this.offers = new ArrayList<>();
//		this.rules = new ArrayList<>();

		
	}
//	@Column(columnDefinition = "Text")
	@OneToMany(mappedBy ="department",fetch = FetchType.LAZY)
	@JsonManagedReference // Manage the relationship on this side
	private List<Image> images;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "department_offer", joinColumns = @JoinColumn(name = "department_id"), inverseJoinColumns = @JoinColumn(name = "offer_id"))
	 @JsonIgnore // Avoid circular references
	List<Offer> offers;

	/*
	 * @OneToMany(mappedBy = "department", fetch = FetchType.LAZY) private
	 * List<DepRule> rules;
	 */
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "department_rule", joinColumns = @JoinColumn(name = "department_id"), inverseJoinColumns = @JoinColumn(name = "rule_id"))
	 @JsonIgnore // Avoid circular references
	List<Rule> rules;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "owner_id")
	@JsonBackReference // Back reference to prevent infinite loop
	private User owner;

	@OneToMany(mappedBy = "department", fetch = FetchType.LAZY)
	 @JsonIgnore // Avoid circular references
	private List<Booking> users;

	@OneToMany(mappedBy = "department", fetch = FetchType.LAZY)
	 @JsonIgnore // Avoid circular references
	List<ReviewDep> reviewers;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getNumOfRoom() {
		return numOfRoom;
	}

	public void setNumOfRoom(Integer numOfRoom) {
		this.numOfRoom = numOfRoom;
	}

	public Integer getNumOfBath() {
		return numOfBath;
	}

	public void setNumOfBath(Integer numOfBath) {
		this.numOfBath = numOfBath;
	}

	public Integer getNumOfBed() {
		return numOfBed;
	}

	public void setNumOfBed(Integer numOfBed) {
		this.numOfBed = numOfBed;
	}

	public Integer getArea() {
		return area;
	}

	public void setArea(Integer area) {
		this.area = area;
	}

	public Integer getNumOfGuest() {
		return numOfGuest;
	}

	public void setNumOfGuest(Integer numOfGuest) {
		this.numOfGuest = numOfGuest;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public Boolean getApproval() {
		return approval;
	}

	public void setApproval(Boolean approval) {
		this.approval = approval;
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

	public List<Offer> getOffers() {
		return offers;
	}

	public void setOffers(List<Offer> offers) {
		this.offers = offers;
	}

	public List<Rule> getRules() {
		return rules;
	}

	public void setRules(List<Rule> rules) {
		this.rules = rules;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public List<Booking> getUsers() {
		return users;
	}

	public void setUsers(List<Booking> users) {
		this.users = users;
	}

	public List<ReviewDep> getReviewers() {
		return reviewers;
	}

	public void setReviewers(List<ReviewDep> reviewers) {
		this.reviewers = reviewers;
	}

	public List<Image> getImages() {
		return images;
	}

	public void setImages(List<Image> images) {
		this.images = images;
	}
	
}
