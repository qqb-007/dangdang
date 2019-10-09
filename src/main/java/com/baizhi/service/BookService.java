package com.baizhi.service;

import java.util.List;

import com.baizhi.entity.Book;

public interface BookService {
	List<Book> queryAllBooks();
	void addBook(Book book);
	List<Book> queryBooksByFactor(String key,String content);
	Book queryBookById(String id);
	void updateBook(Book book);
	void deleteBook(String id);
	List<Book> queryBooksBySalt();
	List<Book> queryBooksByDate();
	List<Book> queryBooksByDateAndDate();
	List<Book> queryBooksByNothing();
	List<Book> queryBooksByScendCategory(int page,String id);
	List<Book> queryBooksByFirstCategory(int page,String id);
	int queryCountByFirst(String id);
	int queryCountByScend(String id);
}
