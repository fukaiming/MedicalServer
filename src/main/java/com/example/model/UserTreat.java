package com.example.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "user_treat")
public class UserTreat {
	private long id;
	private String classType;
	private String description;
	private User user;
	private Set<Material> materials = new HashSet<Material>();

	
	public UserTreat(){
		
	}
	
	public UserTreat(String classType,String description) {
		this.classType = classType;
		this.description = description;
	}
	
	public UserTreat(String classType,String description,User user){
		this(classType,description);
		this.user = user;
	}
	

	@GenericGenerator(name = "generator", strategy = "increment")
	@Id
	@GeneratedValue(generator="generator")
	@Column(name="id")
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	@Basic
	@Column(name="class_type",length=50,nullable = false)
	public String getClassType() {
		return classType;
	}

	public void setClassType(String classType) {
		this.classType = classType;
	}

	@Basic
	@Column(name="description" ,length=500)
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="user_id")
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name="usertreat_id")
	public Set<Material> getMaterials() {
		return materials;
	}

	public void setMaterials(Set<Material> materials) {
		this.materials = materials;
	}
	
	

}
