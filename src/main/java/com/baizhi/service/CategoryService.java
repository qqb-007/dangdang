package com.baizhi.service;

import java.util.List;

import com.baizhi.entity.Category;

public interface CategoryService {
	List<Category> queryAll();
	String addFirstCategory(String name);
	List<Category> queryAllFirstCategories();
	String addScendCategory(String parentId,String name);
	List<String> queryAllParentId();
	void deleteCategory(String id,String levels);
	List<Category> queryAllScendCategories();
	List<Category> queryAllOnFront();
	Category queryCategoryByID(String id);
}
	
	

