package com.tayara.base;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.ietf.jgss.Oid;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;


//import com.beust.jcommander.Parameter;
//import com.tayara.actiondriver.Action;
//import com.tayara.utility.ExtentManager;

public class BaseClass {
	public static Properties prop;	
	//public static WebDriver driver;
	public static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();

	
	//loadConfig method is to load the configuration
		@BeforeSuite
		public void loadConfig() {
			//ExtentManager.setExtent();
			//DOMConfigurator.configure("log4j.xml");

			try {
				prop = new Properties();
				FileInputStream ip = new FileInputStream(
						System.getProperty("user.dir") + "\\Configuration\\config.properties");
				prop.load(ip);

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		
		public static WebDriver getDriver() {
			// Get Driver from threadLocalmap
			return driver.get();
		}
		
		public void launchApp(String browserName) {
			 //String browserName = prop.getProperty("browser");
			if (browserName.equalsIgnoreCase("Chrome")) {
				WebDriverManager.chromedriver().setup();
				// Set Browser to ThreadLocalMap
				driver.set(new ChromeDriver());
			} else if (browserName.equalsIgnoreCase("FireFox")) {
				WebDriverManager.firefoxdriver().setup();
				driver.set(new FirefoxDriver());
			} else if (browserName.equalsIgnoreCase("IE")) {
				WebDriverManager.iedriver().setup();
				driver.set(new InternetExplorerDriver());
			}
			
			getDriver().manage().window().maximize();
			//Delete all the cookies
			getDriver().manage().deleteAllCookies();
			//Launching the URL
			getDriver().get(prop.getProperty("url"));
}
}
