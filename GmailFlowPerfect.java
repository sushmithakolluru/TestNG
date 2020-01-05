import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GmailFlowPerfect {

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

	@Test(priority = 0)

	// creating a method called gmail login

	public void GmailLoginScreen() throws InterruptedException {

		Thread.sleep(2000);

		// Giving the URL

		driver.get("http://www.gmail.com");

		WebElement Inloggen = driver.findElement(By.xpath("//*[@id=\"headingText\"]/span"));

		Assert.assertEquals(Inloggen.isDisplayed(), true);
		Assert.assertEquals(Inloggen.getText(), "Inloggen");

		Thread.sleep(2000);

		driver.findElement(By.name("identifier")).sendKeys("sushmitha.kolluru15@gmail.com");
		WebElement Next = driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/span/span"));

		Next.click();

		Assert.assertEquals(Next.isDisplayed(), true);

		// WebElement Password =
		// driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div[2]/div/div/div[2]/div/div[1]/div/form/span/section/div/div/div[1]/div[1]/div/div/div/div/div[1]/div/div[1]/input"));

		// Assert.assertEquals(Password.isDisplayed(), true);

		Thread.sleep(2000);

		driver.findElement(By.xpath(
				"/html/body/div[1]/div[1]/div[2]/div[2]/div/div/div[2]/div/div[1]/div/form/span/section/div/div/div[1]/div[1]/div/div/div/div/div[1]/div/div[1]/input"))
				.sendKeys("SUSHMITHA92");

		WebElement Submit = driver.findElement(
				By.xpath("/html/body/div[1]/div[1]/div[2]/div[2]/div/div/div[2]/div/div[2]/div/div[1]/div/span/span"));

		Assert.assertEquals(Submit.isDisplayed(), true);

		Submit.click();

	}

	@Test(priority = 1)

	public void GmailComposeEmail() throws InterruptedException {

		// Test Case 1- Clicking Compose Email

		Thread.sleep(4000);

		WebElement Button = driver.findElement(
				By.xpath("/html/body/div[7]/div[3]/div/div[2]/div[1]/div[1]/div[1]/div/div/div/div[1]/div/div"));

		System.out.println("The text is : " + Button.getText());

		driver.findElement(
				By.xpath("/html/body/div[7]/div[3]/div/div[2]/div[1]/div[1]/div[1]/div/div/div/div[1]/div/div"))
				.click();

		Assert.assertEquals(Button.isDisplayed(), true);

		// Test Case 2 - Checking To value TextBox

		Thread.sleep(4000);

		WebElement TextBox = driver.findElement(By.name("to"));

		TextBox.click();

		TextBox.sendKeys("sushmitha.kolluru15@gmail.com");

		Thread.sleep(4000);

		TextBox.sendKeys(Keys.ENTER);

		// Assert.assertEquals(TextBox.isEnabled(), true);

		// Thread.sleep(2000);

		// TextBox.sendKeys(Keys.TAB);

//		// Test Case 3 - Giving subject

		// Thread.sleep(2000);

		WebElement Subject = driver.findElement(By.name("subjectbox"));

		Subject.click();

		Subject.sendKeys("Trial Mail");

		Thread.sleep(4000);

		Assert.assertEquals(Subject.getAttribute("value"), "Trial Mail");

		WebElement Send = driver.findElement(By.xpath(
				"/html/body/div[22]/div/div/div/div[1]/div[3]/div[1]/div[1]/div/div/div/div[3]/div/div/div[4]/table/tbody/tr/td[2]/table/tbody/tr[2]/td/div/div/div[4]/table/tbody/tr/td[1]/div/div[2]/div[1]"));

		Send.click();

	}

	@Test(priority = 2)

	public void selectAnEmail() throws InterruptedException {
		
		Thread.sleep(4000);

		WebElement mailtable = driver.findElement(By.xpath(
				"/html/body/div[7]/div[3]/div/div[2]/div[1]/div[2]/div/div/div/div/div[2]/div/div[1]/div/div/div[6]/div/div[1]/div[3]/div/table"));

		List<WebElement> rowdata = driver.findElements(By.xpath(
				"/html/body/div[7]/div[3]/div/div[2]/div[1]/div[2]/div/div/div/div/div[2]/div/div[1]/div/div/div[6]/div/div[1]/div[3]/div/table/tbody/tr"));

		System.out.println(rowdata.size());
		
		Thread.sleep(4000);

		for (int i = 1; i < rowdata.size(); i++) {

			WebElement subjectdata = driver.findElement(By.xpath(
					"/html/body/div[7]/div[3]/div/div[2]/div[1]/div[2]/div/div/div/div/div[2]/div/div[1]/div/div/div[6]/div/div[1]/div[3]/div/table/tbody/tr["
							+ i + "]/td[6]/div/div/div"));
			
			System.out.println(subjectdata.getText());

			if (subjectdata.getText().contains("Trial Mail")) {

				System.out.println(subjectdata.getText());
			}
			
			

			WebElement checkbox = driver.findElement(By.xpath(
					"/html/body/div[7]/div[3]/div/div[2]/div[1]/div[2]/div/div/div/div/div[2]/div/div[1]/div/div/div[6]/div/div[1]/div[3]/div/table/tbody/tr["
							+ i + "]/td[2]/div"));

			if (subjectdata.getText().contains("Trial Mail")) {

				checkbox.click();
			}

		}
	}

	@Test(priority = 3)

	public void deleteEmail() throws InterruptedException {
		
		Thread.sleep(4000);

		WebElement delete = driver.findElement(By.xpath(
				"/html/body/div[7]/div[3]/div/div[2]/div[1]/div[2]/div/div/div/div/div[1]/div/div[1]/div[1]/div/div/div[2]/div[3]/div"));

		
		Thread.sleep(4000);
		
		delete.click();
	}

	@Test(priority = 4)

	public void signOut() throws InterruptedException {
		
		Thread.sleep(4000);

		driver.findElement(
				By.xpath("/html/body/div[7]/div[3]/div/div[1]/div[3]/header/div[2]/div[3]/div/div[2]/div/a/span"))
				.click();
		
		Thread.sleep(4000);

		driver.findElement(By.xpath("/html/body/div[7]/div[3]/div/div[1]/div[3]/header/div[2]/div[5]/div[4]/a"))
				.click();
	}

	@AfterTest

	public void closeTheBrowser() {

		driver.close();

	}
}
