package com.cucumber.test1;

import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(format={"pretty","html:reports/test-report"},tags= "@selenium",features="src/test" )
public class Runner {

}
