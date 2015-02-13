package com.supinfo.supcrowdfunder.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.xml.bind.annotation.XmlIDREF;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import java.util.Date;


@Entity
@Table(name = "projects")
@NamedQueries({
    @NamedQuery(name = "findProjects", query = "SELECT p FROM Project AS p"),
    @NamedQuery(name = "findProjectsByCategory", query = "SELECT p FROM Project AS p WHERE p.category=:category")
})
@XmlRootElement
public class Project {

	@Id
	@GeneratedValue
	private long id;
	
	@Column(name = "name", nullable = false, unique = true)
	private String name;
	
	@Column(name = "content", nullable = false)
	private String content;
	
	@Column(name = "shortContent", nullable = false)
	private String shortContent;
	
	@Column(name = "price", nullable = false)
	private float price;
	
	@Column(name = "contribution", nullable = false)
	private float contribution;
	
	@Column(name = "percent", nullable = false)
	private float percent;
	
	@ManyToOne
	@XmlIDREF
	@JoinColumn(name = "category_id")
	private Category category;
	
	@OneToOne
	//@XmlIDREF
	@JoinColumn(name = "creator_id")
	private User creator;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
	
	@XmlTransient
	public Category getCategory() {
		return category;
	}
	
	public void setCategory(Category category) {
		this.category = category;
	}

	public float getContribution() {
		return contribution;
	}

	public void setContribution(float contribution) {
		this.contribution = contribution;
	}

	public User getCreator() {
		return creator;
	}

	public void setCreator(User creator) {
		this.creator = creator;
	}

	public String getShortContent() {
		return shortContent;
	}

	public void setShortContent(String shortContent) {
		this.shortContent = shortContent;
	}

	public float getPercent() {
		return percent;
	}

	public void setPercent(float percent) {
		this.percent = percent;
	}
	
}