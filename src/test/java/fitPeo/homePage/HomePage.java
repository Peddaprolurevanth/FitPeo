package fitPeo.homePage;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import fitPeo.calculator.Calculator;
import fitPeo.slider.Slider;
@Test
public class HomePage {
	WebDriver driver;
	static String url ="https://www.fitpeo.com/";
	public static void homapageBrowserSetup() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		try {
			driver.get(url);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Calculator calculator = new Calculator(driver);
		calculator.revenueCalculator();
		Slider slider = new Slider(driver);
		slider.scrollToSlider();
		slider.sliderOperation();
		slider.TestField();
		slider.ValidateValue();
		slider.checkboxes();
		slider.ValidateReimbursement();
		slider.verifyReimbursement();
		
	}
}
