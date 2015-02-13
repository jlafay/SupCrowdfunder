package com.supinfo.supcrowdfunder.dao;

import java.util.List;

import com.supinfo.supcrowdfunder.entity.Category;
import com.supinfo.supcrowdfunder.entity.User;

public interface CategoryDao {
    List<Category> findCategories();
    Category findCategoryById(Long Id);
}