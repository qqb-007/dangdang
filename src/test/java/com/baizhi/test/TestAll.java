package com.baizhi.test;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.baizhi.dao.AdminDao;
import com.baizhi.dao.BookDao;
import com.baizhi.dao.CategoryDao;
import com.baizhi.entity.Admin;
import com.baizhi.entity.Book;
import com.baizhi.entity.Category;
import com.baizhi.service.BookService;
import com.baizhi.service.BookServiceImpl;
import com.baizhi.service.CategoryService;
import com.baizhi.service.CategoryServiceImpl;
import com.baizhi.util.MybatisUtils;
;

public class TestAll {
@Test
public void testAdmin(){
	SqlSession sqlSession =MybatisUtils.getSqlSession(); 
	AdminDao ad =sqlSession.getMapper(AdminDao.class);
	Admin admin =ad.selectAdmin("qqb", "qqb");
    MybatisUtils.close();
	System.out.println(admin);
}
@Test
public void testcategory(){
	SqlSession sqlSession =MybatisUtils.getSqlSession(); 
	CategoryDao cd =sqlSession.getMapper(CategoryDao.class);
	Category c =cd.selectById("1002");
	MybatisUtils.close();
	System.out.println(c);
}
@Test
public void testcategory2(){
	CategoryService ca =new CategoryServiceImpl();
	ca.deleteCategory("5415d889-58c0-455d-a16c-5cfe8e043fb8","1");	
}

@Test
public void testbook(){
	BookService bsBookService =new BookServiceImpl();
	int count = bsBookService.queryCountByScend("2826326f-935e-40bd-aa38-8c9179e50d9e");
	System.out.println(count);
	
	List<Book> list =bsBookService.queryBooksByScendCategory(2, "2826326f-935e-40bd-aa38-8c9179e50d9e");
	for (Book book : list) {
		System.out.println(book);
	}
}
@Test
public void testbook2(){
	SqlSession sqlSession =MybatisUtils.getSqlSession(); 
	BookDao bd =sqlSession.getMapper(BookDao.class);
	//List<Book> bookList = bd.selectAllBooks();
	Book book = new Book("0001", "小猪佩奇寻亲记2", "唐家三少", "aaa",
			"bbb", new Date(), "ccc", new Date(),
			"eee", "fff", "1000000", "10000",
			"ggg", "hhh", "iii", "100",
			"90", new Date(), "jjj",
			"kkk", "lll", "mmm",
			"nnn", "100000", "11000",
			"6a966418-c472-4329-adc2-20b5af90664a", null);
	bd.updateBook(book);
	MybatisUtils.commit();
	
}
@Test
public void testbook3(){
	SqlSession sqlSession =MybatisUtils.getSqlSession(); 
	BookDao bd =sqlSession.getMapper(BookDao.class);
	/*List<Book> bookList = bd.selectAllByFirstCategory("5b3128a3-a3ce-4178-a0b7-f78622f71942");
	for (Book book : bookList) {
		System.out.println(book);
	}
	
	MybatisUtils.close();*/
	
}
}
