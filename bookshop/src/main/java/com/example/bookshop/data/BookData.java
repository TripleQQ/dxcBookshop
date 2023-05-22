package com.example.bookshop.data;

import java.util.List;



public class BookData {
	private long bookId;
	
	private String isbn;

	private String title;
	

	private List<AuthorData> authors;
	

	private Integer year;
	

	private double price;
	

	private String genre;


	public String getIsbn() {
		return isbn;
	}


	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public List<AuthorData> getAuthors() {
		return authors;
	}


	public void setAuthors(List<AuthorData> authors) {
		this.authors = authors;
	}


	public Integer getYear() {
		return year;
	}


	public void setYear(Integer year) {
		this.year = year;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public String getGenre() {
		return genre;
	}


	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	
}
