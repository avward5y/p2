package com.revature.p1.model;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "ers_reimbursement")
public class Reimbursement {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "reimb_id")
	private int id;
	@Column(name = "reimb_amount")
	private float amount;
	@Column(name = "reimb_submitted")
	private Date submitted;
	@Column(name = "reimb_resolved")
	private Date resolved;
	@Column(name = "reimb_description")
	private String description;
	@Column(name = "reimb_author")
	private int author;
	@Column(name = "reimb_resolver")
//	@JsonIgnore
	private int resolver;
	@Column(name = "reimb_status_id")
	private int status;
	@Column(name = "reimb_type_id")
	private int type;
	
	
	public Reimbursement(int id, float amount, Date submitted, Date resolved, String description, int author,
			int resolver, int status, int type) {
		super();
		this.id = id;
		this.amount = amount;
		this.submitted = submitted;
		this.resolved = resolved;
		this.description = description;
		this.author = author;
		this.resolver = resolver;
		this.status = status;
		this.type = type;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public float getAmount() {
		return amount;
	}


	public void setAmount(float amount) {
		this.amount = amount;
	}


	public Date getSubmitted() {
		return submitted;
	}


	public void setSubmitted(Date submitted) {
		this.submitted = submitted;
	}


	public Date getResolved() {
		return resolved;
	}


	public void setResolved(Date resolved) {
		this.resolved = resolved;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public int getAuthor() {
		return author;
	}


	public void setAuthor(int author) {
		this.author = author;
	}


	public int getResolver() {
		return resolver;
	}


	public void setResolver(int resolver) {
		this.resolver = resolver;
	}


	public int getStatus() {
		return status;
	}


	public void setStatus(int status) {
		this.status = status;
	}


	public int getType() {
		return type;
	}


	public void setType(int type) {
		this.type = type;
	}

}