package fitPeo.calculator;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import dev.failsafe.internal.util.Assert;

public class Calculator {

	WebDriver driver;
	@FindBy(xpath="//div[text()='Revenue Calculator']")
	WebElement Revenue;
	public Calculator(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void revenueCalculator() {
		Revenue.click();
	}
}
