package com.flipkart.testcase;

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

	@Test(priority = 1)
	public void testMethod() {
		// here unable to close the modal window
		flipkartlogin.closeWindow();
		flipkartlogin.mouseHowerEle();
		flipkartlogin.verifyMI();
		flipkartlogin.slidePriceSliderDropdown();
		flipkartlogin.searhMobile();
		flipkartlogin.clickFirstproductList();
	}
}
