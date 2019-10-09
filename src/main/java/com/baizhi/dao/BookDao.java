package com.baizhi.dao;

import java.util.List;

import com.baizhi.entity.Book;

public interface BookDao {
	List<Book> selectAllBooks();
	void addBook(Book book);
	List<Book> selectBooksByName(String name);
	List<Book> selectBooksByAuthor(String Author);
	List<Book> selectBooksByPress(String press);
	void updateBook(Book book);
	Book selectBookById(String id);
	void deleteBook(String id);
	List<Book> selectBooksBySale();
	List<Book> selectBooksByDate();
	List<Book> selectBooksByDateAndSale();
	List<Book> selectAllByScendCategory(int a,int b,String id);
	List<Book> selectAllByFirstCategory(int a,int b,String id);
	int selectCountByFirstCategory(String id);
	int selectCountByScendCategory(String id);
}
