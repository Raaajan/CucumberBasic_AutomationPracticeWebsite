package Cucumber.AutomationParctice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {

	static WebDriver driver;
	static JavascriptExecutor js;
	static FileInputStream fi;
	static Properties pro;

	public static WebDriver openBrowser() {
		WebDriverManager.chromedriver().setup();
		return driver = new ChromeDriver();
	}
	
	public static Object scrollIntoView(WebElement elem) {
		js = (JavascriptExecutor) driver;
		return js.executeScript("arguments[0].scrollIntoView(true);", elem);
	}

	public static void loadProperty() throws IOException {
		 fi = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\cucumber.properties");
		 pro = new Properties();
		pro.load(fi);
	}
	
	public static String getProperty(String prokey) {
		return pro.getProperty(prokey);
	}
	
}
