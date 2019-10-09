package com.baizhi.action;

import java.util.List;

import com.baizhi.entity.Book;
import com.baizhi.entity.Category;
import com.baizhi.service.BookService;
import com.baizhi.service.BookServiceImpl;
import com.baizhi.service.CategoryService;
import com.baizhi.service.CategoryServiceImpl;
import com.opensymphony.xwork2.ActionSupport;

public class MainAction extends ActionSupport{
	CategoryService cs = new CategoryServiceImpl();
	BookService bs = new BookServiceImpl();
	//前台展示的分类集合
	private List<Category> categoryList;
	//按照销量展示前八个图书
	private List<Book> saleBook;
	//展示最新上架图示
	private List<Book> dateBook;
	//展示最新和热卖图书
	private List<Book> sdBooks;
	//随机展示的图书
	private List<Book> radomBook;
	//接收前台的一级分类ID
	private String parentId;
	//二级页面展示图书集合
	private List<Book> categoryBooks;
	//接收前台的二级分类ID
	private String childId;
	//接收前台要展示的图书ID
	private String bookId;
	//要展示的图书
	private Book book;
	//共几页
	private int endpage;
	
	public int getEndpage() {
		return endpage;
	}
	public void setEndpage(int endpage) {
		this.endpage = endpage;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	public String getChildId() {
		return childId;
	}
	public void setChildId(String childId) {
		this.childId = childId;
	}
	public List<Book> getCategoryBooks() {
		return categoryBooks;
	}
	public void setCategoryBooks(List<Book> categoryBooks) {
		this.categoryBooks = categoryBooks;
	}
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	//展示二级页面的一级分类
	private Category parentCategory;
	//一级分类下的所有图书数量
	private int parentCount;
	//页数
	private int page;
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getParentCount() {
		return parentCount;
	}
	public void setParentCount(int parentCount) {
		this.parentCount = parentCount;
	}
	public Category getParentCategory() {
		return parentCategory;
	}
	public void setParentCategory(Category parentCategory) {
		this.parentCategory = parentCategory;
	}
	public List<Book> getRadomBook() {
		return radomBook;
	}
	public void setRadomBook(List<Book> radomBook) {
		this.radomBook = radomBook;
	}
	public List<Book> getSdBooks() {
		return sdBooks;
	}
	public void setSdBooks(List<Book> sdBooks) {
		this.sdBooks = sdBooks;
	}
	public List<Book> getDateBook() {
		return dateBook;
	}
	public void setDateBook(List<Book> dateBook) {
		this.dateBook = dateBook;
	}
	public List<Book> getSaleBook() {
		return saleBook;
	}
	public void setSaleBook(List<Book> saleBook) {
		this.saleBook = saleBook;
	}
	public List<Category> getCategoryList() {
		return categoryList;
	}
	public void setCategoryList(List<Category> categoryList) {
		this.categoryList = categoryList;
	}
	public String showOnFront(){
		categoryList=cs.queryAllOnFront();
		saleBook = bs.queryBooksBySalt();
		dateBook = bs.queryBooksByDate();
		sdBooks = bs.queryBooksByDateAndDate();
		radomBook = bs.queryBooksByNothing();
		return "showOnFrontSuccess";
	}
	public String scendAction(){
		if (childId.equals("0")) {
			parentCount = bs.queryCountByFirst(parentId);
			if (parentCount%3==0) {
				endpage=parentCount/3;
				System.out.println("一级图书页数"+endpage);
			}else {
				endpage=parentCount/3+1;
				System.out.println("一级图书页数"+endpage);
			}
			categoryBooks =bs.queryBooksByFirstCategory(page,parentId);	
		}else {
			System.out.println("二级分类id"+childId);
			int count = bs.queryCountByScend(childId);
			if (count%3==0) {
				endpage=count/3;
				System.out.println("二级图书页数"+endpage);
			}else {
				endpage=count/3+1;
				System.out.println("二级图书页数"+endpage);
			}
			System.out.println("二级"+page);
			parentCount = bs.queryCountByFirst(parentId);
			categoryBooks =bs.queryBooksByScendCategory(page,childId);
			
		}
		parentCategory = cs.queryCategoryByID(parentId);
		return "scendActionSuccess";
	}
	public String showBookAction(){
		book=bs.queryBookById(bookId);
		return "showBookActionSuccess";
	}
}
