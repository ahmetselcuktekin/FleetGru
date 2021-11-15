package com.FleetGru.step_definitions;

import com.FleetGru.pages.LoginPage;
import com.FleetGru.utilities.BrowserUtils;
import com.FleetGru.utilities.ConfigurationReader;
import com.FleetGru.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class loginStepDefs {





    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        Driver.get().get(ConfigurationReader.get("url"));
    }

    @When("the user enters the driver information")
    public void the_user_enters_the_driver_information() {
        new LoginPage().driverLogin1();
    }

    @Then("the user should be able to login")
    public void the_user_should_be_able_to_login() {
        BrowserUtils.waitFor(3);
        String actualTitle = Driver.get().getTitle();
        Assert.assertEquals("Dashboard",actualTitle);
    }


}
