package com.training.bookapp;

import java.util.List;
import java.util.stream.Collectors;

import com.training.exceptions.BookNotFoundException;

public class BookDetails {

	BookService bookService;

	public void setBookService(BookService bookService) {
		this.bookService = bookService;

	}

	public List<Book> getBooksOnSale() {
		List<Book> bookList = bookService.getAllBooks();
		return bookList.stream().filter((book) -> book.getPrice() < 900)
				.sorted((book1, book2) -> book1.getTitle().compareTo(book2.getTitle())).collect(Collectors.toList());
	}

	public List<Book> getBooksByAuthor(String author) {
		List<Book> bookList = null;
		try {
			bookList = bookService.getBooksByAuthor(author);
		}catch (BookNotFoundException e){
			System.out.println(e.getMessage());
		}
		

		return bookList;
	}

	public String updateBook(String title, double price) {
		return null;
	}

}
