package com.zfnopCommerce.commons;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features={"src/test/java/com/zfnopCommerce/feature/LoginPage.feature"},
		glue="stepDefinitions",
		dryRun=false,
		monochrome=true
		)
public class TestRunner {
 
}