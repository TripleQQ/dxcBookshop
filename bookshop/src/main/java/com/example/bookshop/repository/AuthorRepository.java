package com.example.bookshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bookshop.persistence.Author;
import org.springframework.data.jpa.repository.Query;

public interface AuthorRepository extends JpaRepository<Author,Long>{

}
