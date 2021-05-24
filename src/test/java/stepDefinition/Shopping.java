package stepDefinition;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import Cucumber.AutomationParctice.Base;
import Cucumber.AutomationParctice.Homepage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

public class Shopping {

	WebDriver driver;
	
	Homepage hp;

	@Given("^I am automationpractice website$")
	public void i_am_automationpractice_website() throws Throwable {
		driver = Base.openBrowser();
		Base.loadProperty();
		driver.get(Base.getProperty("APurl"));
	}

	@And("^verify logo$")
	public void verify_logo() throws Throwable {

		hp = new Homepage(driver);

		WebElement logo = hp.getLogo();

		try {
			boolean l = logo.isDisplayed();
			Assert.assertTrue(l);
		} catch (Exception e) {
			Assert.assertTrue(false);
		}

	}

	@And("^check bestseller tab is enabled and click on it$")
	public void check_bestseller_tab_is_enabled_and_click_on_it() throws Throwable {

	
		WebElement bestsel = hp.getBestSellerTab();
		
		Base.scrollIntoView(bestsel);
		
		try {
			boolean bs = bestsel.isEnabled();
			Assert.assertTrue(bs);
			bestsel.click();
		} catch (Exception e) {
			Assert.assertTrue(false);
		}

	}

	@And("mouseover and click on addcart for image at {int}")
	public void mouseover_and_click_on_addcart_for_image_at(Integer position) throws InterruptedException {
		Actions ac = new Actions(driver);

		List<WebElement> allitm = hp.getBestSellerAllItems();

		WebElement firstimg = allitm.get(position - 1);
		ac.moveToElement(firstimg).perform();
		Thread.sleep(2000);
		hp.getAddToCart(position).click();
		Thread.sleep(3000);
	}

	@And("^verify popup msg for producht successfully added$")
	public void verify_popup_msg_for_producht_successfully_added() throws Throwable {

		WebElement itmadded = hp.getItemAdded();

		String itmadtxt = itmadded.getText();
		Assert.assertEquals("failed to clickon addcart", "Product successfully added to your shopping cart", itmadtxt);

	}

	@And("^verify continue shopping and checkout button enabled and click on proceed btn$")
	public void verify_continue_shopping_and_checkout_button_enabled() throws Throwable {

		WebElement cntshopbtn = hp.getContShoppBtn();

		WebElement prochekoutbtn = hp.getProccedChckoutBtn();

		try {
			boolean shopbtn = cntshopbtn.isEnabled();
			Assert.assertTrue(shopbtn);
		} catch (Exception e) {
			Assert.assertTrue(false);
		}

		try {
			boolean prcdchkbtn = prochekoutbtn.isEnabled();
			Assert.assertTrue(prcdchkbtn);
			prochekoutbtn.click();
			Thread.sleep(1000);
		} catch (Exception e) {
			Assert.assertTrue(false);
		}

	}

	@And("^verify page header as shopping cart summery$")
	public void verify_page_header_as_shopping_cart_summery() throws Throwable {

		String crttitle = hp.getCartTitle().getText();

		boolean carttit = crttitle.contains("SHOPPING-CART SUMMARY");
		Assert.assertTrue(carttit);

	}

	@And("^verify your shopping cart contains \"([^\"]*)\" product$")
	public void verify_your_shopping_cart_contains_something_product(String prodcnt) throws Throwable {

		String prdcnt = hp.getCartCount().getText();

		if (prodcnt.equals("1")) {
			Assert.assertEquals("count does not match", "Your shopping cart contains: " + prodcnt + " Product", prdcnt);
		} else {
			Assert.assertEquals("count does not match", "Your shopping cart contains: " + prodcnt + " Products",
					prdcnt);
		}

	}

	@And("^click on plus icon$")
	public void click_on_icon() throws Throwable {

		hp.getAddQnty().click();

		Thread.sleep(2000);

	}

	@And("^close browser$")
	public void close_browser() throws Throwable {
		driver.close();
	}

}
