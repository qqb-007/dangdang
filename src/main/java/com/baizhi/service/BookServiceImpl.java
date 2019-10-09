package com.baizhi.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.apache.ibatis.session.SqlSession;

import com.baizhi.dao.BookDao;
import com.baizhi.entity.Book;
import com.baizhi.util.MybatisUtils;

public class BookServiceImpl implements BookService {

	@Override
	//查询所有图书
	public List<Book> queryAllBooks() {
		SqlSession sqlSession =MybatisUtils.getSqlSession(); 
		BookDao bd =sqlSession.getMapper(BookDao.class);
		List<Book> bookList = bd.selectAllBooks();
		MybatisUtils.close();
		return bookList;
	}

	@Override
	//添加图书
	public void addBook(Book book) {
		SqlSession sqlSession =MybatisUtils.getSqlSession(); 
		BookDao bd =sqlSession.getMapper(BookDao.class);
		//id,添加时间，销量
		String id =UUID.randomUUID().toString();
		Date date =new Date();
		book.setId(id);
		book.setCreateDate(date);
		book.setSale("0");
		System.out.println(book);
		bd.addBook(book);
		MybatisUtils.commit();
	
		
	}

	@Override
	public List<Book> queryBooksByFactor(String key, String content) {
		SqlSession sqlSession =MybatisUtils.getSqlSession(); 
		BookDao bd =sqlSession.getMapper(BookDao.class);
		List<Book> bookList;
		if ("name".equals(key)) {
			bookList=bd.selectBooksByName(content);
		}else if ("author".equals(key)) {
			bookList=bd.selectBooksByAuthor(content);
		}else if("press".equals(key)){
			bookList=bd.selectBooksByPress(content);
		}else {
			bookList=bd.selectAllBooks();
		}
		
		MybatisUtils.close();
		return bookList;
	}

	@Override
	public Book queryBookById(String id) {
		SqlSession sqlSession =MybatisUtils.getSqlSession(); 
		BookDao bd =sqlSession.getMapper(BookDao.class);
		Book book = bd.selectBookById(id);
		MybatisUtils.close();
		System.out.println(book);
		return book;
	}

	@Override
	public void updateBook(Book book) {
		SqlSession sqlSession =MybatisUtils.getSqlSession(); 
		BookDao bd =sqlSession.getMapper(BookDao.class);
		bd.updateBook(book);
		MybatisUtils.commit();
		
	}

	@Override
	public void deleteBook(String id) {
		SqlSession sqlSession =MybatisUtils.getSqlSession(); 
		BookDao bd =sqlSession.getMapper(BookDao.class);
		bd.deleteBook(id);
		MybatisUtils.commit();
		
	}

	@Override
	public List<Book> queryBooksBySalt() {
		SqlSession sqlSession =MybatisUtils.getSqlSession(); 
		BookDao bd =sqlSession.getMapper(BookDao.class);
		List<Book> bookList = bd.selectBooksBySale();
		MybatisUtils.close();
		return bookList;
	}

	@Override
	public List<Book> queryBooksByDate() {
		SqlSession sqlSession =MybatisUtils.getSqlSession(); 
		BookDao bd =sqlSession.getMapper(BookDao.class);
		List<Book> bookList = bd.selectBooksByDate();
		MybatisUtils.close();
		return bookList;
	}

	@Override
	public List<Book> queryBooksByDateAndDate() {
		SqlSession sqlSession =MybatisUtils.getSqlSession(); 
		BookDao bd =sqlSession.getMapper(BookDao.class);
		List<Book> bookList = bd.selectBooksByDateAndSale();
		MybatisUtils.close();
		return bookList;
	}

	@Override
	public List<Book> queryBooksByNothing() {
		SqlSession sqlSession =MybatisUtils.getSqlSession(); 
		BookDao bd =sqlSession.getMapper(BookDao.class);
		List<Book> bookList = bd.selectAllBooks();
		Set<Book> set = new HashSet<Book>();
		List<Book> randombookBooks=new ArrayList<>(); 
		MybatisUtils.close();
		//随机展示的数量
		int m = 2;
		while (set.size()<m) {
			int n = (int) (Math.random() * bookList.size());
			set.add(bookList.get(n));
			
		}
		for (Book book : set) {
			randombookBooks.add(book);
		}
		return randombookBooks;
	}

	@Override
	public List<Book> queryBooksByScendCategory(int page,String id) {
		SqlSession sqlSession =MybatisUtils.getSqlSession(); 
		BookDao bd =sqlSession.getMapper(BookDao.class);
		int p1=(page-1)*3+1;
		int p2=(page)*3;
		
		List<Book> bookList = bd.selectAllByScendCategory(p1,p2,id);
		MybatisUtils.close();
		return bookList;
	}

	@Override
	public List<Book> queryBooksByFirstCategory(int page,String id) {
		SqlSession sqlSession =MybatisUtils.getSqlSession(); 
		BookDao bd =sqlSession.getMapper(BookDao.class);
		int p1=(page-1)*3+1;
		int p2=(page)*3;
		List<Book> bookList = bd.selectAllByFirstCategory(p1,p2,id);
		MybatisUtils.close();
		return bookList;
	}

	@Override
	public int queryCountByFirst(String id) {
		SqlSession sqlSession =MybatisUtils.getSqlSession(); 
		BookDao bd =sqlSession.getMapper(BookDao.class);
		int count = bd.selectCountByFirstCategory(id);
		
		return count;
	}

	@Override
	public int queryCountByScend(String id) {
		SqlSession sqlSession =MybatisUtils.getSqlSession(); 
		BookDao bd =sqlSession.getMapper(BookDao.class);
		int count = bd.selectCountByScendCategory(id);
		return count;
	}

}
