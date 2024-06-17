package Mainmethod;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class MainClass {

	

	public static void login(String u, String p,WebDriver driver) {
		WebElement Uname = driver.findElement(By.id("user-name"));
		Uname.click();
		Uname.sendKeys(u);
		WebElement Upass = driver.findElement(By.id("password"));
		Upass.click();
		Upass.sendKeys(p);
		driver.findElement(By.id("login-button")).click();
	}

	public static void Homepage(WebDriver driver) {

		WebElement pText = driver.findElement(By.xpath("//span[@class='title']"));
		String actual = pText.getText();
		Assert.assertEquals("Products", actual);

		driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
		driver.findElement(By.id("add-to-cart-sauce-labs-fleece-jacket")).click();

		boolean P1 = driver.findElement(By.id("remove-sauce-labs-backpack")).isDisplayed();
		boolean P2 = driver.findElement(By.id("remove-sauce-labs-fleece-jacket")).isDisplayed();
		Assert.assertTrue(P1);
		Assert.assertTrue(P2);

		driver.findElement(By.id("shopping_cart_container")).click();
		WebElement CartText = driver.findElement(By.xpath("//span[@class='title']"));
		String Cartactual = CartText.getText();
		Assert.assertEquals("Your Cart", Cartactual);
	}
		
		public static void Cartpage(WebDriver driver)  {
		
		driver.findElement(By.id("remove-sauce-labs-fleece-jacket")).click();

		driver.findElement(By.id("checkout")).click();

		}
		
		public static void Formpage(WebDriver driver)  {
			
		driver.findElement(By.id("first-name")).sendKeys("Abhishek");
		driver.findElement(By.id("last-name")).sendKeys("Kandalkar");
		driver.findElement(By.id("postal-code")).sendKeys("444603");
		driver.findElement(By.id("continue")).click();

	
		}
		
		public  static void CheckoutPage(WebDriver driver) throws InterruptedException  {

		WebElement CheckText = driver.findElement(By.xpath("//div[@class='inventory_item_name']"));
		String checkactual = CheckText.getText();
		Assert.assertEquals("Sauce Labs Backpack", checkactual);
		
		driver.findElement(By.id("finish")).click();
		
		}
		
		public  static void ThnkyouPage(WebDriver driver) throws InterruptedException {
		WebElement TText = driver.findElement(By.xpath("//h2[@class='complete-header']"));
		String Endactual = TText.getText();
		Assert.assertEquals("Thank you for your order!", Endactual);
		Thread.sleep(2000);

		driver.findElement(By.id("back-to-products")).click();

	}

}
