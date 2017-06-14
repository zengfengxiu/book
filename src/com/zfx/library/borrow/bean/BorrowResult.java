package com.zfx.library.borrow.bean;

import java.util.Date;

public class BorrowResult {
	private Integer bookId;
	private String bookNo;
	private String bookName;
	private Integer typeId;
	private String typeName;
	private Double price;
	private Integer readerId;
	private String readerNo;
	private String readerName;
	private Date borrowDate;
	private Date returnDate;
	private String oper;

	public BorrowResult() {
		super();
	}

	public BorrowResult(Integer bookId, String bookNo, String bookName,
			Integer typeId, String typeName, Double price, Integer readerId,
			String readerNo, String readerName, Date borrowDate,
			Date returnDate, String oper) {
		super();
		this.bookId = bookId;
		this.bookNo = bookNo;
		this.bookName = bookName;
		this.typeId = typeId;
		this.typeName = typeName;
		this.price = price;
		this.readerId = readerId;
		this.readerNo = readerNo;
		this.readerName = readerName;
		this.borrowDate = borrowDate;
		this.returnDate = returnDate;
		this.oper = oper;
	}

	public Integer getBookId() {
		return bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	public String getBookNo() {
		return bookNo;
	}

	public void setBookNo(String bookNo) {
		this.bookNo = bookNo;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public Integer getTypeId() {
		return typeId;
	}

	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getReaderId() {
		return readerId;
	}

	public void setReaderId(Integer readerId) {
		this.readerId = readerId;
	}

	public String getReaderNo() {
		return readerNo;
	}

	public void setReaderNo(String readerNo) {
		this.readerNo = readerNo;
	}

	public String getReaderName() {
		return readerName;
	}

	public void setReaderName(String readerName) {
		this.readerName = readerName;
	}

	public Date getBorrowDate() {
		return borrowDate;
	}

	public void setBorrowDate(Date borrowDate) {
		this.borrowDate = borrowDate;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	public String getOper() {
		return oper;
	}

	public void setOper(String oper) {
		this.oper = oper;
	}
}
