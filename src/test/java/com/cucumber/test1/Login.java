package com.cucumber.test1;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Login {

	WebDriver dr;

	@Given("^navigate to gmail page$")
	public void navigate() {
		dr = new FirefoxDriver();
		dr.get("http://www.gmail.com");
	}

	// user logged in using username as “utest(\\d+)andrei” and password as
	// “Madagascar(\\d+)”
	// @When("^user logged in using username as \"(.*)\" and password as
	// \"(.*)\"$")
	@When("^user logged in using username as “(.*\\d+.*)” and password as “(.*\\d+)”$")
	public void login(String username, String password) throws InterruptedException {
		try {
			dr.findElement(By.id("Email")).sendKeys(username);
			dr.findElement(By.id("next")).click();
			dr.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			dr.findElement(By.id("Passwd")).sendKeys(password);
			dr.findElement(By.id("signIn")).click();
			dr.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Then("^home page should be displayed$")
	public void verifySuccessful() {
		String expectedText = "Gmail";
		String actualText = dr.findElement(By.xpath("//*[@id=':j']/span")).getText();
		Assert.assertTrue("Login not successful", expectedText.equals(actualText));
	}

}
