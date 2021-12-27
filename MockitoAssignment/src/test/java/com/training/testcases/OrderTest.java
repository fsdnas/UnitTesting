package com.training.testcases;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.*;

import com.training.bookapp.Book;
import com.training.bookapp.BookService;
import com.training.bookapp.OrderDetails;



@RunWith (MockitoJUnitRunner.class)
public class OrderTest {
	@Mock
	BookService bookService;
	
	@InjectMocks
	OrderDetails orderDetails;
	
	@Before
	public void setup() {
		orderDetails = new OrderDetails();
		orderDetails.setBookService(bookService);
	}
	
	@Test
	public void testTotal() {
		Book book = new Book("Java","kathy",900);
		when(bookService.getDiscountedPrice(book)).thenReturn(900.0);
		double amount = orderDetails.getTotalOrder(book, 50);
		assertEquals("Incorrect",45000,amount,1.0);
	}
	@After
	public void teardown() {
		orderDetails = null;
	}

	
	
}
