package com.example.bookshop.persistence;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
@Entity
@Table(name="AUTHOR")
public class Author extends BaseTable{
	
	private static final long serialVersionUID = -4455265394355756752L;
	@Id
	@GeneratedValue(strategy= GenerationType.SEQUENCE, generator="author_id_sequence")
	@SequenceGenerator(name="author_id_sequence",sequenceName="SQ_AUTHOR",allocationSize =1)
	@Column(name="Id")
	private long id;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="BIRTHDAY")
	private LocalDate birthday;
	
	@ManyToOne
	@JoinColumn(name="BOOK_ID")
	private Book book;
	
}
