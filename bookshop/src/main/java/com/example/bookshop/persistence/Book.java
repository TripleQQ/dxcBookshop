package com.example.bookshop.persistence;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Column;
import jakarta.persistence.CascadeType;
@Entity
@Table(name="BOOK")
public class Book extends BaseTable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4355265394355756752L;

	@Id
	@GeneratedValue(strategy= GenerationType.SEQUENCE, generator="book_id_sequence")
	@SequenceGenerator(name="book_id_sequence",sequenceName="SQ_BOOK",allocationSize =1)
	@Column(name="Id")
	private long id;

	
	@Column(name="ISBN")
	private String isbn;
	
	@Column(name="TITLE")
	private String title;
	
	@OneToMany(cascade=CascadeType.ALL)
	private List<Author> authors;
	
	@Column(name="BOOKYEAR")
	private Integer year;
	
	@Column(name="PRICE")
	private double price;
	
	@Column(name="GENRE")
	private String genre;
	

}
