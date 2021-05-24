package Cucumber.AutomationParctice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Homepage {

	WebDriver driver;

	String logo = "//div[@id='header_logo']/a/img";
	String bestsellertab = "//a[@class='blockbestsellers']";
	String allbestselleritemlist = "//ul[@id='blockbestsellers']/li";
	String buttoncontainer = "//div[@class='button-container']/a";
	String itemadded = "(//div[@id='layer_cart']//h2)[1]";
	String contshoppingbtn = "//div[@id='layer_cart']//div[@class='button-container']/span";
	String proceedcheckoutbtn = "//div[@id='layer_cart']//div[@class='button-container']/a";
	String carttitle = "//h1[@id='cart_title']";
	String cartcount = "//h1[@id='cart_title']/span";
	String addqnty = "//div/a[contains(@class,'cart_quantity_up')]";

	public Homepage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getLogo() {

		return driver.findElement(By.xpath(logo));
	}

	public WebElement getBestSellerTab() {
		return driver.findElement(By.xpath(bestsellertab));
	}

	public List<WebElement> getBestSellerAllItems() {
		return driver.findElements(By.xpath(allbestselleritemlist));
	}

	public WebElement getAddToCart(Integer position) {
		return driver.findElement(By.xpath(allbestselleritemlist + "[" + position + "]" + buttoncontainer));

	}

	public WebElement getItemAdded() {
		return driver.findElement(By.xpath(itemadded));
	}

	public WebElement getContShoppBtn() {
		return driver.findElement(By.xpath(contshoppingbtn));
	}

	public WebElement getProccedChckoutBtn() {
		return driver.findElement(By.xpath(proceedcheckoutbtn));
	}

	public WebElement getCartTitle() {
		return driver.findElement(By.xpath(carttitle));
	}

	public WebElement getCartCount() {
		return driver.findElement(By.xpath(cartcount));
	}

	public WebElement getAddQnty() {
		return driver.findElement(By.xpath(addqnty));
	}

}
