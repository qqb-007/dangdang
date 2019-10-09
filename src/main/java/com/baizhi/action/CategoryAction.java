package com.baizhi.action;

import java.util.List;

import com.baizhi.entity.Book;
import com.baizhi.entity.Category;
import com.baizhi.service.CategoryService;
import com.baizhi.service.CategoryServiceImpl;
import com.opensymphony.xwork2.ActionSupport;

public class CategoryAction extends ActionSupport{
	private CategoryService cs = new CategoryServiceImpl();
	private List<Category> list;
	private Category category;
	private String categoryName;
	//二级类别的父类id
	private String parentId;
	//添加的二级类别的类名
    private String sname;
    //要删除的类别id
    private String id;
    //要删除类别的级别
    private String levels;
    //要修改的图书对象
    private Book book;
	

	

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public String getLevels() {
		return levels;
	}

	public void setLevels(String levels) {
		this.levels = levels;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public List<Category> getList() {
		return list;
	}

	public void setList(List<Category> list) {
		this.list = list;
	}
	public String showAllCategory(){
		list = cs.queryAll();
		
	   
		return "showAllCategorySuccess";
	}
	//添加一级类别
	public String addFirstCategory(){
		String addFirstMessage = cs.addFirstCategory(categoryName);
		System.out.println(addFirstMessage);
		return "addFirstCategorySucess";
	}
	//查询所有一级类
	public String showAllFirstCategory(){
		list=cs.queryAllFirstCategories();
		return "showAllFirstCategorySuccess";
	}
	//添加二级类别
	public String addScendCategory(){
		
		//System.out.println(parentId+sname);
		String addScendCategory=cs.addScendCategory(parentId, sname);
		System.out.println(addScendCategory);
		return "addScendCategorySuccess";
	}
	//删除类别
	public String removeCategory(){
		//System.out.println(id+""+levels);
		cs.deleteCategory(id, levels);
		return "removeCategorySuccess";
	}
	//展示所有二级类别
	public String showAllScendCategory(){
		
		list =cs.queryAllScendCategories();
		for (Category c : list) {
			System.out.println(c);
		}
		
		return "showAllScendCategorySuccess";
	}
	//修改图书前的查询二级类别
     public String showAllScendCategory1(){
		
		list =cs.queryAllScendCategories();
		for (Category c : list) {
			System.out.println(c);
		}
		
		return "showAllScendCategory1Success";
	}
	
}
