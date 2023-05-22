package com.example.bookshop.data;

import java.util.List;

public class BookResponse {
	private boolean status;
	private List<BookData> books;
	private String errorMsg;
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public List<BookData> getBooks() {
		return books;
	}
	public void setBooks(List<BookData> books) {
		this.books = books;
	}
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

}
