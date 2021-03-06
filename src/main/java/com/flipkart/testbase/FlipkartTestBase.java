package com.flipkart.testbase;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.flipkart.utils.FlipkartUtils;

public class FlipkartTestBase {

	// need to have class level variablesfor the property file

	public static Properties prop;// here we need to make prop as static so i can access this variable without any
	public static WebDriver driver;

	// need to have constructor to load the property file since this method need not
	// be called explicitly

	public FlipkartTestBase() {
		// Need to load using try and catch block to catch for exceptions
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					System.getProperty("user.dir") + "/src/main/java/com/flipkart/config/config.properties");
			prop.load(ip);
		} catch (Exception e) {
			e.printStackTrace();
			e.getMessage();
			System.out.println("unable to load the property file");
		}
	}

	public void initialization() {
		String localvariable = prop.getProperty("browser");
		if (localvariable.equals("chrome")) {
			String currentdir = System.getProperty("user.dir");
			// chrome driver.exe is in this particular location
			System.setProperty("webdriver.chrome.driver", currentdir + "\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(FlipkartUtils.PAGE_LOAD_TIME_OUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(FlipkartUtils.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}
}
