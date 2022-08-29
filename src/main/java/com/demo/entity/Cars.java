package com.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Component
@Entity
public class Cars {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String company;

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

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public Cars() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cars(int id, String name, String company) {
		super();
		this.id = id;
		this.name = name;
		this.company = company;
	}

	@Override
	public String toString() {
		return "Cars [id=" + id + ", name=" + name + ", company=" + company + "]";
	}

}
