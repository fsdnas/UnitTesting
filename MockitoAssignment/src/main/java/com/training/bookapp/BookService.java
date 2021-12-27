package com.training.bookapp;

import java.util.List;

import com.training.exceptions.BookNotFoundException;

public interface BookService {
	Double getDiscountedPrice(Book book);

	List<Book> getAllBooks();

	List<Book> getBooksByAuthor(String author) throws BookNotFoundException;
	
}
