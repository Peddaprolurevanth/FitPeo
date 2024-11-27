package fitPeo.slider;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

@Test
public class Slider {
	@FindBy(xpath="//span[@data-index='0']")
	WebElement slider;

	@FindBy(xpath="//*[@type=\"number\"]")
	WebElement TextFieldbox;

	@FindBy(xpath="(//input[@type='checkbox'])[1]")
	WebElement checkbox1;

	@FindBy(xpath="(//input[@type='checkbox'])[2]")
	WebElement checkbox2;

	@FindBy(xpath="(//input[@type='checkbox'])[3]")
	WebElement checkbox3;

	@FindBy(xpath="(//input[@type='checkbox'])[8]")
	WebElement checkbox4;
	WebDriver driver;


	@FindBy(xpath="(//input[@type='checkbox'])[8]")
	WebElement totalReimbursement;
@Test
	public void scrollToSlider() {
		
		JavascriptExecutor jse = (JavascriptExecutor) driver;

		try {
			jse.executeScript("window.scrollTo(0,550)");
		} catch (Exception e) {
			System.out.println("Scroll is not Working");
		}
		
	}
@Test
	public void sliderOperation() throws InterruptedException {
		
		Actions act=new Actions(driver);
        act.dragAndDropBy(slider, 93, 0).keyDown(Keys.ARROW_UP).keyDown(Keys.ARROW_UP).keyDown(Keys.ARROW_UP).keyDown(Keys.ARROW_UP)
        .perform();
        Thread.sleep(3000);
		
	}
@Test
	public void TestField() throws InterruptedException {
		TextFieldbox.clear();
		Actions act = new Actions(driver);
		act.dragAndDropBy(slider, -150, 0).perform();
		Thread.sleep(3000);
		int myValue = 560;
		try {
			TextFieldbox.sendKeys("560");
		} catch (Exception e) {
			System.out.println("Unable to Enter the Value");
		}
		
		
	}
@Test
	public void ValidateValue() {
		String expectedValue= "560";
		String actualValue= TextFieldbox.getAttribute("value");
		assertEquals(actualValue, expectedValue);

	}
@Test
	public void checkboxes() {
		checkbox1.click();
		checkbox2.click();
		checkbox3.click();
		checkbox4.click();
	}
@Test
	public void ValidateReimbursement() {
		totalReimbursement.isDisplayed();
	}
@Test
	public void verifyReimbursement() {
		String actualValue= totalReimbursement.getText();
		System.out.println(actualValue);
		String expectedReimbursementValue="110700";
		assertEquals(actualValue, expectedReimbursementValue);

	}

	public Slider(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
}
