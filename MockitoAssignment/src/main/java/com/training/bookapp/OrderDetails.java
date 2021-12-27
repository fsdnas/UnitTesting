package com.training.bookapp;

public class OrderDetails {
	BookService bookService;

	public BookService getBookService() {
		return bookService;
	}

	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}
	public double getTotalOrder(Book book, int quantity) {
		double price = bookService.getDiscountedPrice(book);
		return price*quantity;
	}
	
	
}
