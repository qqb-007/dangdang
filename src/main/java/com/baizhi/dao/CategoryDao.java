package com.baizhi.dao;

import java.util.List;

import com.baizhi.entity.Category;



public interface CategoryDao {
	List<Category> selectAll();
	void addCategory(Category category);
	List<Category> selectAllFirstCategories();
	List<String> selectAllParentId();
	void deleteCategory(String id);
	List<Category> selectAllScendCategories();
	List<Category> selectAllOnfront();
	Category selectById(String id);
    
}
