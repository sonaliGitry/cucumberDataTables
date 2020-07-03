package com.stepdefinition;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Steps {

	WebDriver driver;

	@Given("^: user is already on login page$")
	public void user_is_already_on_login_page() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("http://demowebshop.tricentis.com/login");
		
		System.out.print("from  second branch");
	}

	@When("^: user enters username and password$")
	public void user_enters_username_and_password(DataTable arg1) throws Throwable {
		List<List<String>> data = arg1.raw();
		driver.findElement(By.id("Email")).sendKeys(data.get(0).get(0));
		driver.findElement(By.id("Password")).sendKeys(data.get(0).get(1));

	}

	@Then("^user clicks on login button$")
	public void user_clicks_on_login_button() throws Throwable {
		WebElement loginBtn = driver.findElement(
				By.xpath("//input[@type='submit' and @value='Log in']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", loginBtn);

	}

	@Then("^users moves computers and selects desktop$")
	public void users_moves_computers_and_selects_desktop() throws Throwable {
		// Write code here that turns the phrase above into concrete actions

		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//ul[@class='top-menu']//a[contains(text(),'Computers')]"))).build()
				.perform();
		driver.findElement(By.xpath("//ul[@class='top-menu']//a[contains(text(),'Desktops')]")).click();
	}

	@Then("^select desktop  having price and put in cart$")
	public void select_desktop_having_price_and_put_in_cart(DataTable arg1) throws Throwable {
		String value = driver.findElement(By.xpath(
				"//div[@class='master-wrapper-content']//div[1]//div[1]//div[2]//div[3]//div[1]//span[1]"))
				.getText();
System.out.println("value"+value);
		driver.findElement(
				By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div[2]/div[2]/div[3]/div[1]/div/div[2]/h2/a")).click();
		driver.findElement(By.id("add-to-cart-button-72")).click();
	}

}
