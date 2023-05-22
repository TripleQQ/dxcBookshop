package com.example.bookshop.mapper;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Qualifier;
import org.springframework.util.ObjectUtils;

import com.example.bookshop.data.BookData;
import com.example.bookshop.persistence.Book;

@Mapper(componentModel = "spring", imports= {Object.class}) 
public interface BookshopMapperService {
//qualifiedBy=EmptyStringIfNull
	
	//@Mapping(target ="",source="" expression("java(className.methodName(param)"))
	@Mapping(target ="isbn",source="book.isbn" )
	@Mapping(target ="title",source="book.title" )
	@Mapping(target ="year",source="book.year" )
	@Mapping(target ="price",source="book.price" )
	@Mapping(target ="genre",source="book.genre")
	@Mapping(target ="authors.name",source="book.authors.name" )
	@Mapping(target ="authors.birthday",source="book.authors.birthday" )
	BookData mapBookToBookData(Book book);
	

	@Mapping(target ="isbn",source="bookData.isbn" )
	@Mapping(target ="title",source="bookData.title" )
	@Mapping(target ="year",source="bookData.year" )
	@Mapping(target ="price",source="bookData.price" )
	@Mapping(target ="genre",source="bookData.genre")
	@Mapping(target ="authors.name",source="bbookDataook.authors.name" )
	@Mapping(target ="authors.birthday",source="bookData.authors.birthday" )
	Book mapBookDataToBook(BookData bookData);
}
