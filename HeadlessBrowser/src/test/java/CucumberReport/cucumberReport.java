package CucumberReport;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class cucumberReport {

	WebDriver driver = null;
	ChromeOptions options = new ChromeOptions();

	@Given("^I have open the browser$")
	public void openBrowser() {

		options.addArguments("headless");
		driver = new ChromeDriver(options);
	}

	@When("^I open crud website$")
	public void goToCRUD() {
		driver.navigate().to("https://www.mecallapi.com/crud/");
	}

	@Then("^CREATE button should exist$")
	public void createButton() {
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
						first.sendKeys("Khris");
						last.sendKeys("Ronaldo");
						username.sendKeys("Khris_Ronaldo");
						email.sendKeys("ritkal@gmail.com");
						btnEle.click();
						System.out.println("Test 1 pass....");
						// System.out.println("Elements are :::" + first + " " + last + " " + username +
						// " " + email);
						try {
							Thread.sleep(5);
						} catch (Exception ex) {

							System.out.println(ex.getMessage());
						}

					}
				}

			}

		}

	}

	@Then("^CREATE button should not exist$")
	public void NoCreateButton() {
		List<WebElement> NoLogin = driver.findElements(By.className("btn-secondary"));
		for (WebElement element : NoLogin) {
			System.out.println("element...." + element.getText());
			if (element.getText().equals("Create")) {
				System.out.println("Test 2 Pass.....");
			}
			else {
				
				System.out.println("Test 2 Fail.....");
			}
		}
	}

}
