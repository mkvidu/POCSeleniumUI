package com.stepdef;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import com.stepdef.ReadObject;

import org.apache.log4j.Logger;


public class Loginpage {

	    private static WebDriver driver;       
	    public final static int TIMEOUT = 30;
	     
	    final Logger logger = Loggers.getLogData(Loggers.class.getName());
	    ReadObject object = new ReadObject();
       
	    @Before
	    public void setUp() {
	 
	        WebDriverManager.chromedriver().setup();
	        driver = new ChromeDriver();
	        logger.info("chromedriver will get started");
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TIMEOUT));
	        logger.info("waited for chromedriver started");
	        driver.manage().window().maximize();
	        logger.info("browser window maximized");
	    }
	 
	    @Given("User is on HRMLogin page {string}")
	    public void loginTest(String url) {
	         
	        driver.get(object.getApplicationUrl());
	       
	        logger.info("browser url navigation");
	    }
	  
	    @When("User enters username as {string} and password as {string}")
	    public void goToHomePage(String userName, String passWord) {
	  
	        // login to application
	        driver.findElement(By.name("username")).sendKeys(object.getUserName(userName));
	        driver.findElement(By.name("password")).sendKeys(object.getPassword(passWord));      
	        driver.findElement(By.xpath("//*[@id='app']/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).submit();
	  
	        // go the next page
	      
	         
	    }
	     
	    @Then("User login sucessfully and new page open")
	    public void verifyLogin() {
	  
	         String homePageHeading = driver.findElement(By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div[1]/div[1]/div[1]/h5")).getText();
	          
	         //Verify new page - HomePage
	         Assert.assertEquals(homePageHeading,"Employee Information");
	  
	    }
	     
	    @Then("User able to see error message {string}")
	    public void verifyErrorMessage(String expectedErrorMessage) {
	  
	        String actualErrorMessage = driver.findElement(By.xpath("//*[@id='app']/div[1]/div/div[1]/div/div[2]/div[2]/div/div[1]/div[1]/p")).getText();
	         
	        // Verify Error Message
	        Assert.assertEquals(actualErrorMessage,expectedErrorMessage);
	  
	    }
	    
	    @Then("User will click on {string}")
	    public void clickOnLink(String linktoClick) {
	  
	        driver.findElement(By.linkText("/web/index.php/pim/viewMyDetails")).click();
	         
	  
	  
	    }
	    @Then("User will edit value for {string} with {string}")
	    public void editTextValue(String linktoClick, String value) {
	  
	        driver.findElement(By.className("oxd-input oxd-input--active")).sendKeys(value);         
	  
	  
	    }
	    
	    @Then("User will save data for person")
	    public void saveData() {
	  
	        driver.findElement(By.className("oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space")).submit();	         
	  
	  
	    }
	     
	     
	    @After
	    public void teardown() {
	  
	        driver.quit();
	        logger.info("browser logout");
	    }
	       
	
}
