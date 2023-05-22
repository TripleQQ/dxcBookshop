package com.example.bookshop.service;

import java.util.List;

import com.example.bookshop.data.BookData;

public interface BookshopService {
	
	boolean addNewBook(BookData bookData);
	boolean updateBook(long bookId, BookData bookData);
	
	List<BookData> findBook(String title, String author);
	
	boolean deleteBook(long bookId);

}
