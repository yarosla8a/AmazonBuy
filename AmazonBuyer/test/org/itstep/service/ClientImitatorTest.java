package org.itstep.service;

import static org.junit.Assert.*;

import org.itstep.model.AmazonAcc;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class ClientImitatorTest {

	

	@Test
	public void testLoginAmazonAccount() {
		AmazonAcc acc = new AmazonAcc("Kate", "Klown", "kov712@gmail.com", "qwe4444");

		ClientImitator imitator = new ClientImitator();

		WebDriver driver = imitator.registerAmazonAccount(acc);

		Timer.waitSeconds(20);

		// assertTrue(driver.getPageSource().contains("Helo, "));

		driver = imitator.addItemToWL(driver, "B01LBZTLN4");

		// assertTrue(driver.getPageSource().contains(""));

		driver.quit();
	}

}
