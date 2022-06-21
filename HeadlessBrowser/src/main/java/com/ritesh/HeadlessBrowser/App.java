package com.ritesh.HeadlessBrowser;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class App {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\BrowserDrivers\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		// options.addArguments("headless");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://www.mecallapi.com/crud/");
		List<WebElement> login = driver.findElements(By.className("btn-secondary"));
		for (WebElement element : login) {

			if (element.getText().equals("Create")) {

				element.click();
				try {
					Thread.sleep(5);
				} catch (Exception ex) {

					System.out.println(ex.getMessage());
				}

				WebElement first = driver.findElement(By.id("fname"));
				WebElement last = driver.findElement(By.id("lname"));
				WebElement username = driver.findElement(By.id("username"));
				WebElement email = driver.findElement(By.id("email"));

				List<WebElement> okBtn = driver.findElements(By.className("swal2-confirm"));
				for (WebElement btnEle : okBtn) {

					if (btnEle.getText().equals("OK")) {
						first.sendKeys("Rit");
						last.sendKeys("Kal");
						username.sendKeys("rit_kal");
						email.sendKeys("ritkal@gmail.com");
						btnEle.click();
						// System.out.println("Elements are :::" + first + " " + last + " " + username +
						// " " + email);
						try {
							Thread.sleep(5);
						} catch (Exception ex) {

							System.out.println(ex.getMessage());
						}

						/*
						 * List<WebElement> finalOk =
						 * driver.findElements(By.className("swal2-confirm")); for (WebElement
						 * finalbtnEle : finalOk) { if (finalbtnEle.getText().equals("OK")) {
						 * finalbtnEle.click();
						 * 
						 * } }
						 */

					}
				}

			}

		}

	}
}
