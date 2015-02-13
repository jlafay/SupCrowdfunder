package com.supinfo.supcrowdfunder.model;

import java.io.Serializable;

public class Project implements Serializable {

private long id;

	private String name;
	private String content;
	private String shortContent;
	private long price;
	private long contribution;
	private long percent;
	private Category category;
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

	public void setPrice(long price) {
		this.price = price;
	}

	public Category getCategory() {
		return category;
	}
	
	public void setCategory(Category category) {
		this.category = category;
	}

	public float getContribution() {
		return contribution;
	}

	public void setContribution(long contribution) {
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

	public void setPercent(long percent) {
		this.percent = percent;
	}
}