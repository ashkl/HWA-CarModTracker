package com.qa.hwa.user;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.Ignore;
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
public class ModificationCRUDUserTest {
	
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
	public void getMods() throws InterruptedException {
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
	
	

}
