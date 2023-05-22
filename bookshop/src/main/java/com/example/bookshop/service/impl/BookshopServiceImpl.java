package com.example.bookshop.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.example.bookshop.constant.BookConstant;
import com.example.bookshop.data.BookData;
import com.example.bookshop.data.BookResponse;
import com.example.bookshop.mapper.BookshopMapperService;
import com.example.bookshop.persistence.Book;
import com.example.bookshop.repository.BookRepository;
import com.example.bookshop.service.BookshopService;

import io.micrometer.common.util.StringUtils;
import jakarta.transaction.Transactional;

@Service("bookshopServiceImpl")
public class BookshopServiceImpl implements BookshopService{
    
	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private BookshopMapperService bookshopMapperService;
	
	@Transactional
	@Override
	public boolean addNewBook(BookData bookData) {
		Optional<Book> bookOptional=bookRepository.findByIsbn(bookData.getIsbn());
		if(bookOptional.isEmpty()) {
			Book book = bookshopMapperService.mapBookDataToBook(bookData);
			bookRepository.save(book);
			return true;
		}
		return false;
	}
    @Transactional
	@Override
	public boolean updateBook(long bookId, BookData bookData) {
		Optional<Book> bookOptional=bookRepository.findById(bookId);
		if(bookOptional.isPresent()) {
			Book book=bookOptional.get();
			book = bookshopMapperService.mapBookDataToBook(bookData);
			bookRepository.save(book);
			return true;
		}
		return false;
	}

	@Override
	public List<BookData> findBook(String title, String authorName) {
		List<Book> books = null ;
		if(!StringUtils.isBlank(title)&&!StringUtils.isBlank(title)) {
			books=bookRepository.findByTitleAndAuthorsName(title, authorName);
		}else if(!StringUtils.isBlank(title)) {
			books=bookRepository.findByTitle(title);
		}else if(!StringUtils.isBlank(authorName)) {
			books=bookRepository.findByAuthorsName(authorName);
		}
		if(!CollectionUtils.isEmpty(books)) {
			List<BookData> bookDatas=new ArrayList(books.size());
			books.forEach(book->{bookDatas.add(bookshopMapperService.mapBookToBookData(book));});
			return bookDatas;
		}
			return null;
	}
	@Transactional
	@Override
	public boolean deleteBook(long bookId) {
		Optional<Book> bookOptional=bookRepository.findById(bookId);
		if(bookOptional.isPresent()) {
			Book book=bookOptional.get();
			bookRepository.delete(book);
			return true;
		}
		return false;
	}

}
