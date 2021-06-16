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
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;

@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
@Sql(scripts = {"classpath:hwa-schema.sql", "classpath:hwa-data.sql"}, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles("test")
public class CarCRUDUserTest {
	
	private static WebDriver driver;
	private static String URL = "http://localhost:8080/";
	
	@BeforeAll
	public static void init() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chrome/chromedriver.exe");
		driver = new ChromeDriver();

	}
	
	@AfterAll
	public static void cleanup() {
		driver.quit();
	}
	
	@Test
	public void getCars() throws InterruptedException {
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

}