package com.baizhi.action;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.taglibs.standard.lang.jstl.test.beans.PublicBean1;

import com.baizhi.entity.Book;
import com.baizhi.service.BookService;
import com.baizhi.service.BookServiceImpl;
import com.opensymphony.xwork2.ActionSupport;

public class BookAction extends ActionSupport{
	private BookService bs =new BookServiceImpl();
	//展示图书所用的集合
	private List<Book> booksList;
	//添加图书用
	private Book book;
	//接收封面
	private File cover;
	//封面的文件名
	private String coverFileName;
	//  文件的类型  文件 +ContentType
	private String coverContentType;
	// 上传的文件夹名称
	private String fileFolderName;
	private String directory;
	//模糊查询方式
	private String key;
	//模糊查询关键字
	private String content; 
	//要修改的图书的id
	private String id;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public File getCover() {
		return cover;
	}
	public void setCover(File cover) {
		this.cover = cover;
	}
	public String getCoverFileName() {
		return coverFileName;
	}
	public void setCoverFileName(String coverFileName) {
		this.coverFileName = coverFileName;
	}
	public String getCoverContentType() {
		return coverContentType;
	}
	public void setCoverContentType(String coverContentType) {
		this.coverContentType = coverContentType;
	}
	public String getFileFolderName() {
		return fileFolderName;
	}
	public void setFileFolderName(String fileFolderName) {
		this.fileFolderName = fileFolderName;
	}
	public String getDirectory() {
		return directory;
	}
	public void setDirectory(String directory) {
		this.directory = directory;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public List<Book> getBooksList() {
		return booksList;
	}
	public void setBooksList(List<Book> booksList) {
		this.booksList = booksList;
	}
	//展示所有图书
	public String showAllBooks(){
		booksList=bs.queryAllBooks();
		return "showAllBooksSuccess";
	}
	//添加图书
	public String addBook() throws IOException{
		HttpServletRequest request = ServletActionContext.getRequest();
		String realPath = request.getSession().getServletContext().getRealPath("/bookcover");
		//System.out.println("添加路径"+realPath);
		String imageName=UUID.randomUUID().toString()+coverFileName;
		FileUtils.copyFile(cover, new File(realPath+"/"+imageName));
		
		String contextPath = request.getContextPath();
		
		String coverString= contextPath+"/bookcover"+"/"+imageName;;
		System.out.println(coverString);
		book.setCover(coverString);
		bs.addBook(book);
		return "addBookSuccess";
	}
	//模糊查询
	public String showBooksByFactor(){
		booksList = bs.queryBooksByFactor(key, content);
		return "showBooksByFactorSuccess";
	}
	//修改前的查询
	public String qureyBookById(){
		book =bs.queryBookById(id);
		return "qureyBookByIdSuccess";
	}
	//修改图书
	public String updateBook() throws IOException{
		if (coverFileName!=null) {
			HttpServletRequest request = ServletActionContext.getRequest();
			String realPath = request.getSession().getServletContext().getRealPath("/bookcover");
			
			String imageName=UUID.randomUUID().toString()+coverFileName;
			FileUtils.copyFile(cover, new File(realPath+"/"+imageName));
			
			String contextPath = request.getContextPath();
			
			String coverString= contextPath+"/bookcover"+"/"+imageName;;
			//System.out.println(coverString);
			book.setCover(coverString);
		}
		
		System.out.println(book);
		bs.updateBook(book);
		
		return "updateBookSuccess";
	}
	public String removeBook(){
		bs.deleteBook(id);
		return "removeBookSuccess";
	}
	
}
