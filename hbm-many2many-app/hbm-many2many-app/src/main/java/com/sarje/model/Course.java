package com.sarje.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Course {
	@Id
	private int id;
	private String name;
	@ManyToMany
	@JoinTable(name = "course_subject",joinColumns = {@JoinColumn(name="id")},inverseJoinColumns = {@JoinColumn(name="no")})
	private Set<Subject> subjects = new HashSet<Subject>();
	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Course(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<Subject> getSubjects() {
		return subjects;
	}
	public void setSubjects(Set<Subject> subjects) {
		this.subjects = subjects;
	}
	@Override
	public String toString() {
		return id + " " + name;
	}
	
}
