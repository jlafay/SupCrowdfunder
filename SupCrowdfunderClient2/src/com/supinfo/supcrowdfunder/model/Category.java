package com.supinfo.supcrowdfunder.model;

import java.io.Serializable;
import java.util.List;

import com.supinfo.supcrowdfunder.model.Project;

public class Category implements Serializable {

	private Long id;

	private String name;

	private List<Project> projects;

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

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}
}