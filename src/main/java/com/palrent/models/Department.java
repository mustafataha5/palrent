package com.palrent.models;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

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
	@Min(value = 1)
	private Double price;

	@NotNull
	@Size(min = 3)
	private String title;

	@NotNull
	@Size(min = 3)
	private String description;

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

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "department_offer", joinColumns = @JoinColumn(name = "department_id"), inverseJoinColumns = @JoinColumn(name = "offer_id"))
	List<Offer> offers;

	@OneToMany(mappedBy = "department", fetch = FetchType.LAZY)
	private List<DepRule> rules;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "owner_id")
	private User owner;

	@OneToMany(mappedBy = "department", fetch = FetchType.LAZY)
	private List<UserBookDep> users;

	@OneToMany(mappedBy = "department", fetch = FetchType.LAZY)
	List<ReviewDep> reviewers;
	
	@OneToMany(mappedBy = "department", fetch = FetchType.LAZY)
	List<Image> images;
	
	@OneToOne(mappedBy = "department",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private Address address ; 

	public List<DepRule> getRules() {
		return rules;
	}

	public List<Image> getImages() {
		return images;
	}

	public void setImages(List<Image> images) {
		this.images = images;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public void setRules(List<DepRule> rules) {
		this.rules = rules;
	}

	public Department() {
		this.approval = false;

	}

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

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public List<UserBookDep> getUsers() {
		return users;
	}

	public void setUsers(List<UserBookDep> users) {
		this.users = users;
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

	public List<ReviewDep> getReviewers() {
		return reviewers;
	}

	public void setReviewers(List<ReviewDep> reviewers) {
		this.reviewers = reviewers;
	}

}
