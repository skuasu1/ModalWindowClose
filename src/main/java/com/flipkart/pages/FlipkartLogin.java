package com.flipkart.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.flipkart.testbase.FlipkartTestBase;

public class FlipkartLogin extends FlipkartTestBase {

	@FindBy(xpath = ".//*[@class='_2KpZ6l _2doB4z']")
	WebElement modalWindowEle;

	public void closeWindow() {
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		modalWindowEle.click();
	}

	// method to verify the title
	public String verifyTitle() {
		return driver.getTitle();
	}

}
