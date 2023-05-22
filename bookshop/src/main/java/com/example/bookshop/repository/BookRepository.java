package com.example.bookshop.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.bookshop.persistence.Book;

@Repository
public interface BookRepository extends JpaRepository<Book,Long>{
	
	    List<Book> findByTitle(String title);
	    
	    List<Book> findByAuthorsName(String authorName);
	    
	    List<Book> findByTitleAndAuthorsName(String title, String authorName);

		Optional<Book> findByIsbn(String isbn);

}
