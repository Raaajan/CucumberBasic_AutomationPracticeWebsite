package stepDefinition;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Shopping {
	
	WebDriver driver;
	JavascriptExecutor js;
	
	 @Given("^I am automationpractice website$")
	    public void i_am_automationpractice_website() throws Throwable {
		
		 WebDriverManager.chromedriver().setup(); 
		  driver = new ChromeDriver();
		 driver.get("http://automationpractice.com/");
		 driver.manage().window().maximize();
	    }

	    @And("^verify logo$")
	    public void verify_logo() throws Throwable {
	          WebElement logo = driver.findElement(By.xpath("//div[@id='header_logo']/a/img"));
	          try {
	        	  boolean l = logo.isDisplayed();
	        	  Assert.assertTrue(l);
	          }
	          catch(Exception e) {
	        	  Assert.assertTrue(false);
	          }    
	         
	    }

	    @And("^check bestseller tab is enabled and click on it$")
	    public void check_bestseller_tab_is_enabled_and_click_on_it() throws Throwable {
	    	
	    	 js = (JavascriptExecutor)driver;
	        WebElement bestsel = driver.findElement(By.xpath("//a[@class='blockbestsellers']"));
	        js.executeScript("arguments[0].scrollIntoView(true);", bestsel);
	          try {
	        	  boolean bs = bestsel.isEnabled();
	        	  Assert.assertTrue(bs);
	        	  bestsel.click();
	          }
	          catch(Exception e) {
	        	  Assert.assertTrue(false);
	          } 
	     
	    }

	    @And("^mouseover and click on addcart for any image$")
	    public void mouseover_and_click_on_addcart_for_any_image() throws Throwable {
	    	
	    	Actions ac = new Actions(driver);
	    	
	    	List<WebElement> allitm = driver.findElements(By.xpath("//ul[@id='blockbestsellers']/li"));
	    	
	    	WebElement firstimg = allitm.get(0);
	    	ac.moveToElement(firstimg).perform();
	    	Thread.sleep(2000);
	    	driver.findElement(By.xpath("(//ul[@id='blockbestsellers']/li)[1]//div[@class='button-container']/a")).click();
	    	Thread.sleep(3000);
	      
	    }

	    @And("^verify popup msg for producht successfully added$")
	    public void verify_popup_msg_for_producht_successfully_added() throws Throwable {
	    	
	    	WebElement itmadded = driver.findElement(By.xpath("(//div[@id='layer_cart']//h2)[1]"));
	    	String itmadtxt = itmadded.getText();
	    	Assert.assertEquals("failed to clickon addcart", "Product successfully added to your shopping cart", itmadtxt);
	        
	    }

	    @And("^verify continue shopping and checkout button enabled and click on proceed btn$")
	    public void verify_continue_shopping_and_checkout_button_enabled() throws Throwable {
	    	
	    	WebElement cntshopbtn = driver.findElement(By.xpath("//div[@id='layer_cart']//div[@class='button-container']/span"));
	    	WebElement prochekoutbtn = driver.findElement(By.xpath("//div[@id='layer_cart']//div[@class='button-container']/a"));
	    	
	        try {
	        	  boolean shopbtn = cntshopbtn.isEnabled();
	        	  Assert.assertTrue(shopbtn);
	          }
	          catch(Exception e) {
	        	  Assert.assertTrue(false);
	          } 
	        
	        try {
	        	  boolean prcdchkbtn = prochekoutbtn.isEnabled();
	        	  Assert.assertTrue(prcdchkbtn);
	        	  prochekoutbtn.click();
	       	  		Thread.sleep(1000);
	          }
	          catch(Exception e) {
	        	  Assert.assertTrue(false);
	          } 
	    	
	      
	    }


	    @And("^verify page header as shopping cart summery$")
	    public void verify_page_header_as_shopping_cart_summery() throws Throwable {
	      
	    	String crttitle = driver.findElement(By.xpath("//h1[@id='cart_title']")).getText();
	    	boolean carttit = crttitle.contains("SHOPPING-CART SUMMARY");
	    	Assert.assertTrue(carttit);
	    
	    }

	    @And("^verify your shopping cart contains \"([^\"]*)\" product$")
	    public void verify_your_shopping_cart_contains_something_product(String prodcnt) throws Throwable {
	   
	    	String prdcnt = driver.findElement(By.xpath("//h1[@id='cart_title']/span")).getText();
	    	if(prodcnt.equals("1")) {
	    	Assert.assertEquals("count does not match", "Your shopping cart contains: "+prodcnt+" Product", prdcnt);
	    	}
	    	else {
	    		Assert.assertEquals("count does not match", "Your shopping cart contains: "+prodcnt+" Products", prdcnt);
	    	}
	    	
	    }

	    @And("^click on plus icon$")
	    public void click_on_icon() throws Throwable {
	    	
	    	driver.findElement(By.xpath("//table[@id='cart_summary']//tbody/tr/td[5]/div/a[contains(@class,'cart_quantity_up')]")).click();
	    	Thread.sleep(2000);
	        
	    }

	    @And("^close browser$")
	    public void close_browser() throws Throwable {
	        driver.close();
	    }

}
