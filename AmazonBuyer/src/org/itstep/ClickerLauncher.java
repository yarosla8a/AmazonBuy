package org.itstep;

import org.itstep.model.AmazonAcc;
import org.itstep.service.ClientImitator;
import org.openqa.selenium.WebDriver;

public class ClickerLauncher {
	

	public static void main(String[] args) {

		AmazonAcc acc = new AmazonAcc("Varfolomey", "Visilovich", "Varfolich@gmail.com", "Varfolichent");

		ClientImitator imitator = new ClientImitator();

		WebDriver driver = imitator.loginAmazonAccount(acc);

    }

}
