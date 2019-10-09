package com.baizhi.service;

import java.util.List;
import java.util.UUID;

import javax.swing.text.html.CSS;

import org.apache.ibatis.session.SqlSession;

import com.baizhi.dao.BookDao;
import com.baizhi.dao.CategoryDao;
import com.baizhi.entity.Book;
import com.baizhi.entity.Category;
import com.baizhi.util.MybatisUtils;

public class CategoryServiceImpl implements CategoryService {

	@Override
	//查询所有
	public List<Category> queryAll() {
		SqlSession sqlSession =MybatisUtils.getSqlSession(); 
		CategoryDao cd =sqlSession.getMapper(CategoryDao.class);
		List<Category> list=cd.selectAll();
	    MybatisUtils.close();
		return list;
	}

	@Override
	//添加一级类
	public String addFirstCategory(String name) {
		// TODO Auto-generated method stub
		SqlSession sqlSession =MybatisUtils.getSqlSession(); 
		CategoryDao cd =sqlSession.getMapper(CategoryDao.class);
		List<Category> list=cd.selectAll();
		boolean pd = true;
		for (Category category : list) {
			if (category.getName().equals(name)) {
				pd=false;
			}
		}
		if (pd) {
			String id=UUID.randomUUID().toString();
			Category cg=new Category(id,name,null,"1",null,null);
			cd.addCategory(cg);
			MybatisUtils.commit();
			return "添加成功";
		}else {
			return "类名已存在";
		}
		
	}

	@Override
	//查询所有一级类别
	public List<Category> queryAllFirstCategories() {
		SqlSession sqlSession =MybatisUtils.getSqlSession(); 
		CategoryDao cd =sqlSession.getMapper(CategoryDao.class);
		List<Category> list = cd.selectAllFirstCategories();
		MybatisUtils.close();
		return list;
	}

	@Override
	//添加二级类别
	public String addScendCategory(String parentId, String name) {
		SqlSession sqlSession =MybatisUtils.getSqlSession(); 
		CategoryDao cd =sqlSession.getMapper(CategoryDao.class);
		List<Category> list=cd.selectAll();
		boolean pd = true;
		for (Category category : list) {
			if (category.getName().equals(name)) {
				pd=false;
			}
		}
		if (pd) {
			String id=UUID.randomUUID().toString();
			Category cg=new Category(id,name,parentId,"2",null,null);
			//System.out.println(cg);
			cd.addCategory(cg);
			MybatisUtils.commit();
			return "添加成功";
		}else {
			return "类名已存在";
		}
		
	}

	@Override
	public List<String> queryAllParentId() {
		SqlSession sqlSession =MybatisUtils.getSqlSession(); 
		CategoryDao cd =sqlSession.getMapper(CategoryDao.class);
		List<String> Idlist = cd.selectAllParentId();
		MybatisUtils.close();
		return Idlist;
	}

	@Override
	//删除类别
	public void deleteCategory(String id,String levels) {
		//List<String> Idlist =queryAllParentId();
		SqlSession sqlSession =MybatisUtils.getSqlSession(); 
		CategoryDao cd =sqlSession.getMapper(CategoryDao.class);
		List<String> Idlist = cd.selectAllParentId();
		boolean pd=true;
		if (levels.equals("2")) {
			//删除前查询该2级类别下是否有图书
			BookDao bd =sqlSession.getMapper(BookDao.class);
			List<Book> books = bd.selectAllBooks();
			for (Book book : books) {
				if (id.equals(book.getCategoryId())) {
					pd=false;
				}
			}
			if (pd) {

				cd.deleteCategory(id);
				MybatisUtils.commit();
			}
			
		}else {
			
			for (String string : Idlist) {
				if (string.equals(id)) {
					pd=false;
				}
			}
			if (pd) {
				cd.deleteCategory(id);	
				MybatisUtils.commit();
			}
		}
		
		
	}

	@Override
	public List<Category> queryAllScendCategories() {
		SqlSession sqlSession =MybatisUtils.getSqlSession(); 
		CategoryDao cd =sqlSession.getMapper(CategoryDao.class);
		List<Category> categorieslist = cd.selectAllScendCategories();
		MybatisUtils.close();
		return categorieslist;
	}

	@Override
	public List<Category> queryAllOnFront() {
		SqlSession sqlSession =MybatisUtils.getSqlSession(); 
		CategoryDao cd =sqlSession.getMapper(CategoryDao.class);
		List<Category> categorieslist = cd.selectAllOnfront();
		
		MybatisUtils.close();
		return categorieslist;
	}

	@Override
	public Category queryCategoryByID(String id) {
		SqlSession sqlSession =MybatisUtils.getSqlSession(); 
		CategoryDao cd =sqlSession.getMapper(CategoryDao.class);
		Category c =cd.selectById(id);
		MybatisUtils.close();
		//System.out.println(c);
		return c;
	}

}
