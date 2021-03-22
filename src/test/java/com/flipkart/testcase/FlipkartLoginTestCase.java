package com.flipkart.testcase;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.flipkart.pages.FlipkartLogin;
import com.flipkart.testbase.FlipkartTestBase;

public class FlipkartLoginTestCase extends FlipkartTestBase {

	FlipkartLogin flipkartlogin;

	public FlipkartLoginTestCase() {
		super();
	}

	@BeforeMethod
	public void init() {
		initialization();
		flipkartlogin = new FlipkartLogin();
	}
	
	/*
	 * @Test(priority = 1) public void verifyTitleNew() { String title =
	 * flipkartlogin.verifyTitle(); if (title == "Facebook") {
	 * Assert.assertEquals(title, "Facebook"); } }
	 */
	@Test(priority = 1)
	public void closeModalWindow() {
		// here unable to close the modal window
		flipkartlogin.closeWindow();
	}

	/*
	 * @AfterMethod public void tearDown() { driver.close(); }
	 */

}
