package com.supinfo.supcrowdfunder.dao;

import java.util.List;

import com.supinfo.supcrowdfunder.entity.Category;
import com.supinfo.supcrowdfunder.entity.Project;

public interface ProjectDao {
	void createProject(Project project);
	void updateProject(Project project);
	Project findProjectById(Long Id);
	List<Project> findProjectsByCategory(Category category);
	List<Project> findProjects();
}
