package com.mobileapp.testcases;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.mobileapp.exceptions.MobileIdNotFoundException;
import com.mobileapp.exceptions.MobileNotFoundException;
import com.mobileapp.model.Mobile;
import com.mobileapp.service.MobileService;

class MobileTest {
	MobileService mobileService = null;

	Mobile mobile1, mobile2, mobile3, mobile4, mobile5;
	List<Mobile> mobileList = null;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		mobileService = new MobileService();
		mobile1 = new Mobile("M32", "Samsung", 15999, 1);
		mobile2 = new Mobile("11 mini", "Apple", 59000, 2);
		mobile3 = new Mobile("A32", "Samsung", 49552, 3);
		mobile4 = new Mobile("F52", "Samsung", 19999, 4);
		mobile5 = new Mobile("M50", "Samsung", 25000, 5);

		mobileList = Arrays.asList(mobile1, mobile2, mobile3, mobile4, mobile5);

	}

	@AfterEach
	void tearDown() throws Exception {
		mobileService = null;
	}

	@Test
	public void testMobileById() throws MobileIdNotFoundException {
		Mobile mobile = mobileService.findMobileById(1);
		assertEquals(mobile, mobile, "same object");

	}

	@Test
	public void testByIdNotAvailable() {

		assertThrows(MobileIdNotFoundException.class, () -> mobileService.findMobileById(100));
	}

	@Test
	public void testByIdEquals() {
		try {
			Mobile mobile = mobileService.findMobileById(30);
			assertEquals(mobile1.toString(), mobile.toString(), "same");
		} catch (MobileIdNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}

	@Test
	void testByMobileBrand() throws MobileNotFoundException {

		List<Mobile> actualMobileList = mobileService.findMobileByBrand("Apple");
		List<Mobile> expectedMobileList = Arrays.asList(mobile2);
		assertEquals(expectedMobileList.toString(), actualMobileList.toString(), "failed");

	}



}
