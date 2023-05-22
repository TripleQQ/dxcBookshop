package com.example.bookshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.bookshop.constant.BookConstant;
import com.example.bookshop.data.BookData;
import com.example.bookshop.data.BookResponse;
import com.example.bookshop.service.BookshopService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@RestController
@RequestMapping(value="/bookshop")
@CrossOrigin(origins="*")
public class BookController {
	
	@Autowired
	private BookshopService bookshopServiceImpl;
	private static final Logger logger = LoggerFactory.getLogger(BookController.class);

	@GetMapping(value="/findbooks?title={title}&author={author}")
	public ResponseEntity<?> findBookByTitleOrAuthor(  @RequestParam(required = false) String title,
            @RequestParam(required = false) String author){
		BookResponse bookResponse =new BookResponse();
		try {
			logger.info("Receive request to find book for tilte:{}, author:{}",title,author);
			List<BookData> bookList = bookshopServiceImpl.findBook(title,author);
			if(CollectionUtils.isEmpty(bookList)) {
				bookResponse.setStatus(false);
				bookResponse.setErrorMsg(BookConstant.ErrorMessage.UNABLE_TO_BOOK);
				logger.error("unable to find book for  tilte:{}, author:{}",title,author);
			}else {
				logger.info("book has been found, proceed to send booklist back to client ");
				bookResponse.setStatus(true);
				bookResponse.setBooks(bookList);
				
			}
			 return ResponseEntity.ok(bookResponse);
			
			
		}catch(Exception e) {
			logger.error("Techical error happen due to:{} ",e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(BookConstant.ErrorMessage.TECHNICAL_ERROR);
		}
		
		
	}
	
	
	@PostMapping(value="/updatebook/{bookId}")
	public ResponseEntity<?> updateBook(  @PathVariable long bookId,
            @RequestBody BookData updatedBookData){
		try {
			logger.info("Receive request to update book for bookId:{}",bookId);
		     boolean result = bookshopServiceImpl.updateBook(bookId,updatedBookData);
		     BookResponse bookResponse =new BookResponse();
		     bookResponse.setStatus(result);
		     if(!result) {
		    	 bookResponse.setErrorMsg(BookConstant.ErrorMessage.UNABLE_TO_BOOK);
		     }
			 return ResponseEntity.ok(bookResponse);
			
		}catch(Exception e) {
			logger.error("Techical error happen due to:{} ",e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(BookConstant.ErrorMessage.TECHNICAL_ERROR);
		}
		
	}
	

	
	@PostMapping(value="/addnewbook")
	public ResponseEntity<?> addNewBook(@RequestBody BookData bookData){
		try { logger.info("Receive request to add book for isbn:{}",bookData.getIsbn());

			BookResponse bookResponse =new BookResponse();
			boolean result = bookshopServiceImpl.addNewBook(bookData);
			bookResponse.setStatus(result);
			if(result) {
				bookResponse.setErrorMsg(BookConstant.ErrorMessage.DUPLICATE_BOOK_ERROR);
			}
			 return ResponseEntity.status(HttpStatus.CREATED).body(bookResponse);
		}catch(Exception e) {
			logger.error("Techical error happen due to:{} ",e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(BookConstant.ErrorMessage.TECHNICAL_ERROR);
		}
		
		
	}
	
	@DeleteMapping(value="/deletebook/{bookId}")
	@PreAuthorize("hasRole('AuthorizedRole')")
	public  ResponseEntity<?>  deleteBook(@PathVariable long bookId){
		try { 
			 logger.info("Receive request to delete book for BookId:{}",bookId);
			BookResponse bookResponse =new BookResponse();
			boolean result = bookshopServiceImpl.deleteBook(bookId);
			bookResponse.setStatus(result);
			if(result) {
				bookResponse.setErrorMsg(BookConstant.ErrorMessage.UNABLE_TO_BOOK);
			}
			 return ResponseEntity.status(HttpStatus.OK).body(bookResponse);
		}catch(Exception e) {
			logger.error("Techical error happen due to:{} ",e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(BookConstant.ErrorMessage.TECHNICAL_ERROR);
		}
		
	}


}
