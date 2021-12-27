package com.training.testcases;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.training.bookapp.Book;
import com.training.bookapp.BookDetails;
import com.training.bookapp.BookService;
import com.training.exceptions.BookNotFoundException;

@RunWith (MockitoJUnitRunner.class)
public class BookTest {
	@Mock
	BookService bookService;
	
	
	@InjectMocks
	
	BookDetails bookDetails;
	List<Book> bookList;
	Book book1,book2,book3,book4,book5;
	@Before
	public void setup() {
		bookDetails = new BookDetails();
		bookDetails.setBookService(bookService);
		book1 = new Book("Java", "kathy",400);
		book2 = new Book("Spring", "kathi",300);
		book3 = new Book("Servlets", "kathalu",1800);
		book4 = new Book("Node", "bramhi",1000);
		book5 = new Book("JavaScript", "bramhi",420);
		bookList = Arrays.asList(book1,book2,book3,book4,book5);
	}
	
	@Test
	public void testgetBooksOnSale() {
		when(bookService.getAllBooks()).thenReturn(bookList);
		List<Book> allBooks = bookDetails.getBooksOnSale();
		assertEquals(4,allBooks.size());
	}
	
	@Test
	public void testgetBooksByAuthor() {
		String author = "bramhi";
		List<Book> allBooks = null;
		try {
			when(bookService.getBooksByAuthor(author)).thenReturn(Arrays.asList(book4,book5));
			allBooks = bookDetails.getBooksByAuthor(author);
			assertEquals(3, allBooks.size());
		} catch (BookNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	
		
	}
	
	@After
	public void teardown() {
		bookDetails = null;
	}
}	
