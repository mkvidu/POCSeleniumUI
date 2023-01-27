package com.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

public class TestRunner {

	    
	@CucumberOptions(tags = "", 
			         features = {"src/test/resources/features/LoginApp.feature"}, 
			         glue = {"com.stepdef"},
	                 plugin = {})
	    
	public class CucumberRunnerTests extends AbstractTestNGCucumberTests {
	    
	}
}
