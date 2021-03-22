package com.flipkart.pages;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.flipkart.testbase.FlipkartTestBase;

public class FlipkartLogin extends FlipkartTestBase {
	
	

	@FindBy(xpath = ".//*[@class='_2KpZ6l _2doB4z']")
	WebElement modalWindowEle;

	@FindBy(xpath = "//div[contains(text(),'Mobiles')]")
	WebElement mobileEle;

	@FindBy(xpath = "//span[contains(text(),'Electronics')]")
	WebElement electronics;
	
	@FindBy(xpath = "//a[contains(text(),'Redmi Go')]")
	WebElement redMiTitle;
	
	@FindBy(xpath = "//div[@class='HQL4QS _28DFQy']//div[@class='_3FdLqY']")
	WebElement slider;
	
	@FindBy(xpath = "//div[@class='_3uDYxP']//select[@class='_2YxCDZ']")
	WebElement dropdown;
	
	@FindBy(xpath ="//input[@placeholder='Search for products, brands and more']")
	WebElement searchMobileEle;
	
	@FindBy(xpath ="//button[@type='submit']//*[local-name()='svg']")
	WebElement submitEle;
	
	@FindBy(xpath ="//div[normalize-space()='Redmi Go (Black, 8 GB)']")
	WebElement firstElementList;
	
	@FindBy(xpath ="//div[@class='_30jeq3 _16Jk6d']")
	WebElement amountElement;
	
	@FindBy(xpath = "//div[@class='_3g-Cpg']")
	WebElement videoEle;
	
	@FindBy(id ="pincodeInputId")
	WebElement pincodeEle;
	
	
	Actions action = new Actions(driver);

	public FlipkartLogin() {
		PageFactory.initElements(driver, this);
	}

	public void closeWindow() {
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		modalWindowEle.click();
	}

	public void mouseHowerEle() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		mobileEle.click();
		action.moveToElement(electronics).build().perform();
		WebDriverWait wait = new WebDriverWait(driver, 5);
		WebElement miLink = wait.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText("Mi")));
		miLink.click();
	}

	public void verifyMI() {
		
		String title = redMiTitle.getText();
		System.out.println("Latest from MI  : " + title);
	}
	
	public void slidePriceSliderDropdown() {
		action.dragAndDropBy(slider, 0, 300);
		Select select = new Select(dropdown);
		select.selectByIndex(2);
	}

	public void searhMobile() {
		searchMobileEle.sendKeys(prop.getProperty("Redmi"));
		submitEle.click();
	}

	public void clickFirstproductList() {
		firstElementList.click();
		String parentWindow = driver.getWindowHandle();
		Set<String> childWindow = driver.getWindowHandles();
		Iterator<String> it = childWindow.iterator();
		
		while(it.hasNext()) {
			String childwindowValue = it.next(); 
			if (!parentWindow.equalsIgnoreCase(childwindowValue)) {
				driver.switchTo().window(childwindowValue);
				driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
				String valuenew = amountElement.getText();
				String skuasu = valuenew. replaceAll("[?,]", "");
				String amtValue = skuasu.substring(1);
				int amount = Integer.parseInt(amtValue);
				if(amount >= 0) {
					driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
					videoEle.click();
					pincodeEle.sendKeys("560037");
					driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
					JavascriptExecutor js = (JavascriptExecutor) driver;
					js.executeScript("window.scrollBy(0,170)");
					WebElement newVar = driver.findElement(By.xpath("//div[contains(text(),'View Details')]"));
					JavascriptExecutor executor = (JavascriptExecutor)driver;
					executor.executeScript("arguments[0].click();", newVar);
					driver.findElement(By.xpath(".//*[@class='_2KpZ6l _1KAjNd']")).click();
				}
				
			}
			driver.switchTo().window(parentWindow);
			// unable to add to cart because the pin code supply is not there 
		}
		
	}
}
