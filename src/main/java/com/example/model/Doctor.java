 package com.example.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "doctor")
public class Doctor {
	private long id;
	private String username;
	private String phone;
	private String title;
	private String office;
	private String skill;
	private String experience;
	private Hospital hospital;
	private Set<ScheduleTime> scheduleTimes =  new HashSet<ScheduleTime>();
	public Doctor() {

	}

	@GenericGenerator(name = "generator", strategy = "increment")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "id", length = 500, nullable = false, unique = true)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Basic
	@Column(name = "username", length = 100, nullable = false)
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Basic
	@Column(name = "phone", length = 20)
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	@Basic
	@Column(name="title",length=100)
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	@Basic
	@Column(name="office",length=100)
	public String getOffice() {
		return office;
	}

	public void setOffice(String office) {
		this.office = office;
	}
	
	@Basic
	@Column(name="skill",length=100)
	public String getSkill() {
		return skill;
	}

	public void setSkill(String skill) {
		this.skill = skill;
	}
	
	@Basic
	@Column(name="experience",length=500)
	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="hosptial_id")
	public Hospital getHospital() {
		return hospital;
	}

	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "doctor_id")
	public Set<ScheduleTime> getScheduleTimes() {
		return scheduleTimes;
	}

	public void setScheduleTimes(Set<ScheduleTime> scheduleTimes) {
		this.scheduleTimes = scheduleTimes;
	}
	
	
}
