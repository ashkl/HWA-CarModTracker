package com.qa.hwa.user;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.Ignore;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;

@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
@Sql(scripts = {"classpath:hwa-schema.sql", "classpath:hwa-data.sql"}, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles("test")
class ModificationCRUDUserTest {
	
	private static WebDriver driver;
	private static String URL = "http://localhost:8080/";
	
	@BeforeAll
	public static void init() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chrome/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		driver = new ChromeDriver( options );
	}
	
	@AfterAll
	public static void cleanup() {
		driver.quit();
	}
	
	//@Ignore
	@Test
	void getMods() throws InterruptedException {
		driver.get(URL);
		//Thread.sleep(10000000);
		
	    driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		
		WebElement targ1 = driver.findElement(By.xpath("//*[@id=\"output\"]/div[1]/div/div[2]/table/tbody/tr"));
		WebElement targ2 = driver.findElement(By.xpath("//*[@id=\"output\"]/div[2]/div/div[2]/table/tbody/tr[1]"));
		WebElement targ3 = driver.findElement(By.xpath("//*[@id=\"output\"]/div[2]/div/div[2]/table/tbody/tr[2]"));
		
		String mod1 = targ1.getText();
		String mod2 = targ2.getText();
		String mod3 = targ3.getText();
		
		assertEquals("Spoiler M4 Style Spoiler 15/06/2021 135000 54.99", mod1);
		assertEquals("Exhaust Catback Exhaust 15/11/2018 40000 370", mod2);
		assertEquals("Splitter TRC Front Splitter 26/01/2020 60000 370", mod3);
	}
	
	//@Ignore
	@Test
	void createMod() throws InterruptedException {
		driver.get(URL);
		//Thread.sleep(100000000);
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
	    
		WebElement targ = driver.findElement(By.xpath("//*[@id=\"navbarDropdownAddMod\"]"));
		targ.click();
		
		targ = driver.findElement(By.xpath("//*[@id=\"selectCar\"]"));
		targ = driver.findElement(By.xpath("//*[@id=\"selectCar\"]/option[3]"));
		targ.click();
		
		targ = driver.findElement(By.xpath("//*[@id=\"addModName\"]"));
		targ.click();
		targ.sendKeys("MHD");
		
		targ = driver.findElement(By.xpath("//*[@id=\"addModDesc\"]"));
		targ.click();
		targ.sendKeys("S55 Remap");
		
		targ = driver.findElement(By.xpath("//*[@id=\"addInstallDate\"]"));
		targ.click();
		targ.sendKeys("23/04/2021");
		
		targ = driver.findElement(By.xpath("//*[@id=\"addInstallMileage\"]"));
		targ.click();
		targ.sendKeys("22000");
		
		targ = driver.findElement(By.xpath("//*[@id=\"addModPrice\"]"));
		targ.click();
		targ.sendKeys("299.99");
		
		targ = driver.findElement(By.xpath("//*[@id=\"newMod\"]/div[7]/button"));
		targ.click();
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.stalenessOf(targ));

	    targ = driver.findElement(By.xpath("//*[@id=\"output\"]/div[3]/div/div[2]/table/tbody/tr"));
	    String newMod = targ.getText();
	    
	    assertEquals("MHD S55 Remap 23/04/2021 22000 299.99", newMod);
	}
	
	//@Ignore
	@Test
	void updateMod() throws InterruptedException {
		driver.get(URL);
		
		//Thread.sleep(100000000);
		
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);

		WebElement targ = driver.findElement(By.xpath("//*[@id=\"navbarDropdownUpdateMod\"]"));
		targ.click();
		
		targ = driver.findElement(By.xpath("//*[@id=\"selectUpdateMod\"]"));
		targ = driver.findElement(By.xpath("//*[@id=\"selectUpdateMod\"]/option[2]"));
		targ.click();
		
		targ = driver.findElement(By.xpath("//*[@id=\"updateModName\"]"));
		targ.click();
		targ.sendKeys("Full Exhaust");
		
		targ = driver.findElement(By.xpath("//*[@id=\"updateModDesc\"]"));
		targ.click();
		targ.sendKeys("Turbo back exhaust");
		
		targ = driver.findElement(By.xpath("//*[@id=\"updateInstallDate\"]"));
		targ.click();
		targ.sendKeys("13/08/2020");
		
		targ = driver.findElement(By.xpath("//*[@id=\"updateInstallMileage\"]"));
		targ.click();
		targ.sendKeys("65000");
		
		targ = driver.findElement(By.xpath("//*[@id=\"updateModPrice\"]"));
		targ.click();
		targ.sendKeys("549.99");

		targ = driver.findElement(By.xpath("//*[@id=\"updateMod\"]/div[7]/button"));
		targ.click();
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.stalenessOf(targ));
			
		targ = driver.findElement(By.xpath("//*[@id=\"output\"]/div[2]/div/div[2]/table/tbody/tr[1]"));
	    String updatedMod = targ.getText();
	    
	    assertEquals("Full Exhaust Turbo back exhaust 13/08/2020 65000 549.99", updatedMod);
	}
	
	//@Ignore
	@Test 
	void removeMod() throws InterruptedException {
		driver.get(URL);
		
		//Thread.sleep(1000000);
		
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		
		WebElement targ = driver.findElement(By.xpath("//*[@id=\"navbarDropdownDeleteMod\"]"));
		targ.click();
		
		targ = driver.findElement(By.xpath("//*[@id=\"selectDeleteMod\"]"));
		targ = driver.findElement(By.xpath("//*[@id=\"selectDeleteMod\"]/option[2]"));
		targ.click();
		
		
		targ = driver.findElement(By.xpath("//*[@id=\"deleteMod\"]/div[2]/button"));
		targ.click();
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.stalenessOf(targ));
		
		targ = driver.findElement(By.xpath("//*[@id=\"output\"]/div[2]/div/div[2]/table/tbody/tr"));
		
		assertEquals("Splitter TRC Front Splitter 26/01/2020 60000 370", targ.getText());
		
		targ = driver.findElement(By.xpath("//*[@id=\"output\"]/div[2]/div/div[3]/h5"));

		assertEquals("Total Spent: £370", targ.getText());
		
	}

}
