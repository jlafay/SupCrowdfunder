package com.supinfo.supcrowdfunder.dao;

import java.util.List;

import com.supinfo.supcrowdfunder.entity.Category;
import com.supinfo.supcrowdfunder.entity.Project;
import com.supinfo.supcrowdfunder.entity.User;

public interface UserDao {
	void createUser(User user);
	void updateUser(User user);
	User findUserById(Long Id);
	User findUserByEmail(String email);
}
