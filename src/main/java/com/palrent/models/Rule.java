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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="rules")
public class Rule {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty
	@Size(min=3)
	private String name;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public Rule() {
		
	}

	/*
	 * @OneToMany(mappedBy="rule", fetch=FetchType.LAZY) private List<DepRule>
	 * departments;
	 */
	    
	 @ManyToMany(fetch = FetchType.LAZY)
		@JoinTable(name = "department_rule",
		joinColumns = @JoinColumn(name = "rule_id"),
		inverseJoinColumns = @JoinColumn(name = "department_id"))
		List<Department> departments;
	 
	 @Column(updatable = false)
		@DateTimeFormat(pattern = "yyyy-MM-dd")
		private Date createdAt;
		@DateTimeFormat(pattern = "yyyy-MM-dd")
		private Date updatedAt;

		@PrePersist
		protected void onCreate() {
			this.createdAt = new Date();
		}

		

		public List<Department> getDepartments() {
			return departments;
		}

		public void setDepartments(List<Department> departments) {
			this.departments = departments;
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

		@PreUpdate
		protected void onUpdate() {
			this.updatedAt = new Date();
		}
}
