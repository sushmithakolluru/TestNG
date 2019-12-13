import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TransferwiseText {

	WebDriver driver = null;

	@BeforeTest

	public void LaunchBrowser() {

		// Initialising chrome browser and giving its location

		System.setProperty("webdriver.chrome.driver", "C:\\Test Automation\\TestNG\\libs\\chromedriver.exe");

		// Declaring driver as it inherits all the properties of driver to chrome
		// browser

		driver = new ChromeDriver();

		// Maximizing the window
		driver.manage().window().maximize();
	}
	
	@Test (priority=0)
	
	public void Transferwise() throws InterruptedException {
		
		Thread.sleep(2000);
		driver.get("http://www.transferwise.com");
		
	WebElement Text = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/main/div/div/div[1]/div[1]/h1"));
	
	System.out.println("The text is : " + Text.getText()  );
	
	Assert.assertEquals(Text.isDisplayed(), true);
	Assert.assertEquals(Text.getText(), "The cheap, fast way to send money abroad." );
	
	
	
	
	}

}
