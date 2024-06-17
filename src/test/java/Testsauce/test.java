package Testsauce;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import Mainmethod.MainClass;
import io.github.bonigarcia.wdm.WebDriverManager;

public class test {

	static WebDriver driver;

	@BeforeMethod
	public void launch() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}

	@Test
	public void login() {
		System.out.println("login");
		MainClass.login("standard_user", "secret_sauce", driver);
	}

	@Test
	public void Home() {
		System.out.println("Home");
		MainClass.login("standard_user", "secret_sauce", driver);
		MainClass.Homepage(driver);

	}

	@Test
	public void Cart() {
		System.out.println("Cart");
		MainClass.login("standard_user", "secret_sauce", driver);
		MainClass.Homepage(driver);
		MainClass.Cartpage(driver);
	}

	@Test
	public void form() {
		System.out.println("form");
		MainClass.login("standard_user", "secret_sauce", driver);
		MainClass.Homepage(driver);
		MainClass.Cartpage(driver);
		MainClass.Formpage(driver);
	}

	@Test
	public void Checkout() throws InterruptedException {
		System.out.println("Checkout");
		MainClass.login("standard_user", "secret_sauce", driver);
		MainClass.Homepage(driver);
		MainClass.Cartpage(driver);
		MainClass.Formpage(driver);
		MainClass.CheckoutPage(driver);
	}

	@Test
	public void thanks() throws InterruptedException {
		System.out.println("thanks");
		MainClass.login("standard_user", "secret_sauce", driver);
		MainClass.Homepage(driver);
		MainClass.Cartpage(driver);
		MainClass.Formpage(driver);
		MainClass.CheckoutPage(driver);
		MainClass.ThnkyouPage(driver);
	}

	@AfterMethod
	public void close() {
		driver.close();
	}

}
