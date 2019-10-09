package com.baizhi.entity;

import java.io.Serializable;
import java.util.Date;

public class Book implements Serializable{
	private String id;
	private String name;
	private String author;
	private String cover;
	private String press;
	private Date pressDate;
	private String edition;
	private Date printDate;
	private String impression;
	private String isbn;
	private String wordNum;
	private String pageNum;
	private String size;
	private String paper;
	private String pack;
	private String price;
	private String dprice;
	private Date createDate;
	private String editorRecommend;
	private String contentAbstract;
	private String authorAbstract;
	private String director;
	private String mediaCommentary;
	private String sale;
	private String stock;
	private String categoryId;
	private String categoryName;
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getCover() {
		return cover;
	}
	public void setCover(String cover) {
		this.cover = cover;
	}
	public String getPress() {
		return press;
	}
	public void setPress(String press) {
		this.press = press;
	}
	public java.sql.Date getPressDate() {
		
		long time = pressDate.getTime();
		java.sql.Date sqlPressDate = new java.sql.Date(time);
		return sqlPressDate;
	}
	public void setPressDate(Date pressDate) {
		this.pressDate = pressDate;
	}
	public String getEdition() {
		return edition;
	}
	public void setEdition(String edition) {
		this.edition = edition;
	}
	public java.sql.Date getPrintDate() {
		
		long time = printDate.getTime();
		java.sql.Date sqlPrintDate=new java.sql.Date(time);
		
		return sqlPrintDate;
	}
	public void setPrintDate(Date printDate) {
		this.printDate = printDate;
	}
	public String getImpression() {
		return impression;
	}
	public void setImpression(String impression) {
		this.impression = impression;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getWordNum() {
		return wordNum;
	}
	public void setWordNum(String wordNum) {
		this.wordNum = wordNum;
	}
	public String getPageNum() {
		return pageNum;
	}
	public void setPageNum(String pageNum) {
		this.pageNum = pageNum;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getPaper() {
		return paper;
	}
	public void setPaper(String paper) {
		this.paper = paper;
	}
	public String getPack() {
		return pack;
	}
	public void setPack(String pack) {
		this.pack = pack;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getDprice() {
		return dprice;
	}
	public void setDprice(String dprice) {
		this.dprice = dprice;
	}
	public java.sql.Date getCreateDate() {
		long time =createDate.getTime();
		java.sql.Date sqlCreateDate=new java.sql.Date(time);
		return sqlCreateDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getEditorRecommend() {
		return editorRecommend;
	}
	public void setEditorRecommend(String editorRecommend) {
		this.editorRecommend = editorRecommend;
	}
	public String getContentAbstract() {
		return contentAbstract;
	}
	public void setContentAbstract(String contentAbstract) {
		this.contentAbstract = contentAbstract;
	}
	public String getAuthorAbstract() {
		return authorAbstract;
	}
	public void setAuthorAbstract(String authorAbstract) {
		this.authorAbstract = authorAbstract;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getMediaCommentary() {
		return mediaCommentary;
	}
	public void setMediaCommentary(String mediaCommentary) {
		this.mediaCommentary = mediaCommentary;
	}
	public String getSale() {
		return sale;
	}
	public void setSale(String sale) {
		this.sale = sale;
	}
	public String getStock() {
		return stock;
	}
	public void setStock(String stock) {
		this.stock = stock;
	}
	public String getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	public Book() {
		super();
	}
	public Book(String id, String name, String author, String cover,
			String press, Date pressDate, String edition, Date printDate,
			String impression, String isbn, String wordNum, String pageNum,
			String size, String paper, String pack, String price,
			String dprice, Date createDate, String editorRecommend,
			String contentAbstract, String authorAbstract, String director,
			String mediaCommentary, String sale, String stock,
			String categoryId, String categoryName) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
		this.cover = cover;
		this.press = press;
		this.pressDate = pressDate;
		this.edition = edition;
		this.printDate = printDate;
		this.impression = impression;
		this.isbn = isbn;
		this.wordNum = wordNum;
		this.pageNum = pageNum;
		this.size = size;
		this.paper = paper;
		this.pack = pack;
		this.price = price;
		this.dprice = dprice;
		this.createDate = createDate;
		this.editorRecommend = editorRecommend;
		this.contentAbstract = contentAbstract;
		this.authorAbstract = authorAbstract;
		this.director = director;
		this.mediaCommentary = mediaCommentary;
		this.sale = sale;
		this.stock = stock;
		this.categoryId = categoryId;
		this.categoryName = categoryName;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result
				+ ((authorAbstract == null) ? 0 : authorAbstract.hashCode());
		result = prime * result
				+ ((categoryId == null) ? 0 : categoryId.hashCode());
		result = prime * result
				+ ((categoryName == null) ? 0 : categoryName.hashCode());
		result = prime * result
				+ ((contentAbstract == null) ? 0 : contentAbstract.hashCode());
		result = prime * result + ((cover == null) ? 0 : cover.hashCode());
		result = prime * result
				+ ((createDate == null) ? 0 : createDate.hashCode());
		result = prime * result
				+ ((director == null) ? 0 : director.hashCode());
		result = prime * result + ((dprice == null) ? 0 : dprice.hashCode());
		result = prime * result + ((edition == null) ? 0 : edition.hashCode());
		result = prime * result
				+ ((editorRecommend == null) ? 0 : editorRecommend.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((impression == null) ? 0 : impression.hashCode());
		result = prime * result + ((isbn == null) ? 0 : isbn.hashCode());
		result = prime * result
				+ ((mediaCommentary == null) ? 0 : mediaCommentary.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((pack == null) ? 0 : pack.hashCode());
		result = prime * result + ((pageNum == null) ? 0 : pageNum.hashCode());
		result = prime * result + ((paper == null) ? 0 : paper.hashCode());
		result = prime * result + ((press == null) ? 0 : press.hashCode());
		result = prime * result
				+ ((pressDate == null) ? 0 : pressDate.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result
				+ ((printDate == null) ? 0 : printDate.hashCode());
		result = prime * result + ((sale == null) ? 0 : sale.hashCode());
		result = prime * result + ((size == null) ? 0 : size.hashCode());
		result = prime * result + ((stock == null) ? 0 : stock.hashCode());
		result = prime * result + ((wordNum == null) ? 0 : wordNum.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (authorAbstract == null) {
			if (other.authorAbstract != null)
				return false;
		} else if (!authorAbstract.equals(other.authorAbstract))
			return false;
		if (categoryId == null) {
			if (other.categoryId != null)
				return false;
		} else if (!categoryId.equals(other.categoryId))
			return false;
		if (categoryName == null) {
			if (other.categoryName != null)
				return false;
		} else if (!categoryName.equals(other.categoryName))
			return false;
		if (contentAbstract == null) {
			if (other.contentAbstract != null)
				return false;
		} else if (!contentAbstract.equals(other.contentAbstract))
			return false;
		if (cover == null) {
			if (other.cover != null)
				return false;
		} else if (!cover.equals(other.cover))
			return false;
		if (createDate == null) {
			if (other.createDate != null)
				return false;
		} else if (!createDate.equals(other.createDate))
			return false;
		if (director == null) {
			if (other.director != null)
				return false;
		} else if (!director.equals(other.director))
			return false;
		if (dprice == null) {
			if (other.dprice != null)
				return false;
		} else if (!dprice.equals(other.dprice))
			return false;
		if (edition == null) {
			if (other.edition != null)
				return false;
		} else if (!edition.equals(other.edition))
			return false;
		if (editorRecommend == null) {
			if (other.editorRecommend != null)
				return false;
		} else if (!editorRecommend.equals(other.editorRecommend))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (impression == null) {
			if (other.impression != null)
				return false;
		} else if (!impression.equals(other.impression))
			return false;
		if (isbn == null) {
			if (other.isbn != null)
				return false;
		} else if (!isbn.equals(other.isbn))
			return false;
		if (mediaCommentary == null) {
			if (other.mediaCommentary != null)
				return false;
		} else if (!mediaCommentary.equals(other.mediaCommentary))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (pack == null) {
			if (other.pack != null)
				return false;
		} else if (!pack.equals(other.pack))
			return false;
		if (pageNum == null) {
			if (other.pageNum != null)
				return false;
		} else if (!pageNum.equals(other.pageNum))
			return false;
		if (paper == null) {
			if (other.paper != null)
				return false;
		} else if (!paper.equals(other.paper))
			return false;
		if (press == null) {
			if (other.press != null)
				return false;
		} else if (!press.equals(other.press))
			return false;
		if (pressDate == null) {
			if (other.pressDate != null)
				return false;
		} else if (!pressDate.equals(other.pressDate))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (printDate == null) {
			if (other.printDate != null)
				return false;
		} else if (!printDate.equals(other.printDate))
			return false;
		if (sale == null) {
			if (other.sale != null)
				return false;
		} else if (!sale.equals(other.sale))
			return false;
		if (size == null) {
			if (other.size != null)
				return false;
		} else if (!size.equals(other.size))
			return false;
		if (stock == null) {
			if (other.stock != null)
				return false;
		} else if (!stock.equals(other.stock))
			return false;
		if (wordNum == null) {
			if (other.wordNum != null)
				return false;
		} else if (!wordNum.equals(other.wordNum))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", author=" + author
				+ ", cover=" + cover + ", press=" + press + ", pressDate="
				+ pressDate + ", edition=" + edition + ", printDate="
				+ printDate + ", impression=" + impression + ", isbn=" + isbn
				+ ", wordNum=" + wordNum + ", pageNum=" + pageNum + ", size="
				+ size + ", paper=" + paper + ", pack=" + pack + ", price="
				+ price + ", dprice=" + dprice + ", createDate=" + createDate
				+ ", editorRecommend=" + editorRecommend + ", contentAbstract="
				+ contentAbstract + ", authorAbstract=" + authorAbstract
				+ ", director=" + director + ", mediaCommentary="
				+ mediaCommentary + ", sale=" + sale + ", stock=" + stock
				+ ", categoryId=" + categoryId + ", categoryName="
				+ categoryName + "]";
	}
	
	
}
