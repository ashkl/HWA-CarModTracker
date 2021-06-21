package com.qa.hwa.user;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
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
class CarCRUDUserTest {
	
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
	

	@Test
	void getCars() throws InterruptedException {
		driver.get(URL);
		
	    driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		
		WebElement targ1 = driver.findElement(By.xpath("//*[@id=\"output\"]/div[1]/div/div[1]/h4"));
		WebElement targ2 = driver.findElement(By.xpath("//*[@id=\"output\"]/div[2]/div/div[1]/h4"));
		WebElement targ3 = driver.findElement(By.xpath("//*[@id=\"output\"]/div[3]/div/div[1]/h4"));
		WebElement targ4 = driver.findElement(By.xpath("//*[@id=\"output\"]/div[4]/div/div[1]/h4"));
		
		String cardTitle = targ1.getText();
		String cardTitle2 = targ2.getText();
		String cardTitle3 = targ3.getText();
		String cardTitle4 = targ4.getText();
		
		assertEquals("2005 BMW 320cd", cardTitle);
		assertEquals("2012 VW Polo TSI", cardTitle2);
		assertEquals("2017 BMW M2", cardTitle3);
		assertEquals("2017 Audi RS3", cardTitle4);
	}
	

	@Test
	void createCar() throws InterruptedException {
		driver.get(URL);
		
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
	    
		WebElement targ = driver.findElement(By.xpath("//*[@id=\"navbarDropdownAddCar\"]"));
		targ.click();
		
		targ = driver.findElement(By.xpath("//*[@id=\"addMake\"]"));
		targ.click();
		targ.sendKeys("BMW");
		
		targ = driver.findElement(By.xpath("//*[@id=\"addModel\"]"));
		targ.click();
		targ.sendKeys("135i");
		
		targ = driver.findElement(By.xpath("//*[@id=\"addYear\"]"));
		targ.click();
		targ.sendKeys("2010");
		
		targ = driver.findElement(By.xpath("//*[@id=\"addColour\"]"));
		targ.click();
		targ.sendKeys("Alpine White");
		
		targ = driver.findElement(By.xpath("//*[@id=\"addTrans\"]"));
		targ = driver.findElement(By.xpath("//*[@id=\"addTrans\"]/option[2]"));
		targ.click();
		
		targ = driver.findElement(By.xpath("//*[@id=\"addFuel\"]"));
		targ = driver.findElement(By.xpath("//*[@id=\"addFuel\"]/option[1]"));
		targ.click();
		
		targ = driver.findElement(By.xpath("//*[@id=\"addBhp\"]"));
		targ.click();
		targ.sendKeys("306");
		
		targ = driver.findElement(By.xpath("//*[@id=\"addBoughtMileage\"]"));
		targ.click();
		targ.sendKeys("108500");
		
		targ = driver.findElement(By.xpath("//*[@id=\"newCar\"]/div[9]/button"));
		targ.click();
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.stalenessOf(targ));

	    targ = driver.findElement(By.xpath("//*[@id=\"output\"]/div[5]/div/div[1]/h4"));
	    String cardTitle = targ.getText();
	    
	    assertEquals("2010 BMW 135i", cardTitle);
	}
	
	@Test
	void updateCar() throws InterruptedException {
		driver.get(URL);
		
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		
		WebElement targ = driver.findElement(By.xpath("//*[@id=\"navbarDropdownUpdateCar\"]"));
		targ.click();
		
		targ = driver.findElement(By.xpath("//*[@id=\"selectUpdateCar\"]"));
		targ = driver.findElement(By.xpath("//*[@id=\"selectUpdateCar\"]/option[3]"));
		targ.click();
		
		targ = driver.findElement(By.xpath("//*[@id=\"updateMake\"]"));
		targ.click();
		targ.sendKeys("BMW");
		
		targ = driver.findElement(By.xpath("//*[@id=\"updateModel\"]"));
		targ.click();
		targ.sendKeys("M2 CS");
		
		targ = driver.findElement(By.xpath("//*[@id=\"updateYear\"]"));
		targ.click();
		targ.sendKeys("2019");
		
		targ = driver.findElement(By.xpath("//*[@id=\"updateColour\"]"));
		targ.click();
		targ.sendKeys("Hockenheim Silver");
		
		targ = driver.findElement(By.xpath("//*[@id=\"updateTrans\"]"));
		targ = driver.findElement(By.xpath("//*[@id=\"updateTrans\"]/option[1]"));
		targ.click();
		
		targ = driver.findElement(By.xpath("//*[@id=\"updateFuel\"]"));
		targ = driver.findElement(By.xpath("//*[@id=\"updateFuel\"]/option[1]"));
		targ.click();
		
		targ = driver.findElement(By.xpath("//*[@id=\"updateBhp\"]"));
		targ.click();
		targ.sendKeys("444");
		
		targ = driver.findElement(By.xpath("//*[@id=\"updateBoughtMileage\"]"));
		targ.click();
		targ.sendKeys("5000");

		targ = driver.findElement(By.xpath("//*[@id=\"updateCar\"]/div[10]/button"));
		targ.click();
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.stalenessOf(targ));
		
	    targ = driver.findElement(By.xpath("//*[@id=\"output\"]/div[3]/div/div[1]/h4"));
	    String cardText = targ.getText();
	    
	    assertEquals("2019 BMW M2 CS", cardText);
	}
	
	@Test 
	void removeCar() throws InterruptedException {
		driver.get(URL);
		
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		
		WebElement targ = driver.findElement(By.xpath("//*[@id=\"navbarDropdownDeleteCar\"]"));
		targ.click();
		
		targ = driver.findElement(By.xpath("//*[@id=\"selectDeleteCar\"]"));
		targ = driver.findElement(By.xpath("//*[@id=\"selectDeleteCar\"]/option[2]"));
		targ.click();
		
		
		targ = driver.findElement(By.xpath("//*[@id=\"deleteCar\"]/div[2]/button"));
		targ.click();
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.stalenessOf(targ));
		
		targ = driver.findElement(By.xpath("//*[@id=\"output\"]/div[2]/div/div[1]/h4"));
		
		assertEquals("2017 BMW M2", targ.getText());
		
	}

}
