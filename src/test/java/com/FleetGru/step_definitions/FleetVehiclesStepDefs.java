package com.FleetGru.step_definitions;

import com.FleetGru.pages.DashboardPage;
import com.FleetGru.pages.FleetVehiclesPage;
import com.FleetGru.utilities.BrowserUtils;
import com.FleetGru.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class FleetVehiclesStepDefs {
    @When("the user select {string} {string} from the top bar")
    public void the_user_select_from_the_top_bar(String string, String string2) {
        new DashboardPage().navigateToModule(string,string2);
        BrowserUtils.waitFor(2);
    }


    @Then("the user should see Fleet-Vehicles page")
    public void the_user_should_see_Fleet_Vehicles_page() {
        String actualTitle=Driver.get().getTitle();
        String expectedTitle="Car - Entities - System - Car - Entities - System";
        Assert.assertEquals(expectedTitle,actualTitle);
    }
    @When("the user click the Filter button")
    public void the_user_click_the_Filter_button() {
        BrowserUtils.waitFor(2);
        if(!new FleetVehiclesPage().manageFiltersButton_Locator.isDisplayed()) {
            FleetVehiclesPage page = new FleetVehiclesPage();
            page.filterButton_Locator.click();
            BrowserUtils.waitFor(1);
        }
    }
    @When("the user click Manage Filter")
    public void the_user_click_Manage_Filter() {
       new FleetVehiclesPage().manageFiltersButton_Locator.click();
    }
    @Then("the user select {string} filter")
    public void the_user_select_filter(String item) {

        FleetVehiclesPage page=new FleetVehiclesPage();
      if(!page.getManageFiltersItemCheckbox(item).isSelected()) {
          page.getManageFiltersItemCheckbox(item).click();
          BrowserUtils.waitFor(2);
          Assert.assertTrue(page.getManageFiltersItemCheckbox(item).isSelected());
      }
      else {
          page.getManageFiltersItemCheckbox(item).click();
          BrowserUtils.waitFor(2);
          Assert.assertFalse(page.getManageFiltersItemCheckbox(item).isSelected());
      }


    }

    //Scenario 2

    @Then("the user click {string} box")
    public void the_user_click_box(String string) {
        new FleetVehiclesPage().getFiltersItemControlBox(string).click();
    }

    @Then("the user click choose button")
    public void the_user_click_choose_button() {
        new FleetVehiclesPage().FiltersItemControlBoxFirstElement_Locator.click();
    }

    @Then("content of list should have to following  types")
    public void content_of_list_should_have_to_following_types(List<String> expectedList) {
        List<String> actualList=BrowserUtils.getElementsText(new FleetVehiclesPage().FiltersItemControlBoxAllElement_Locator);

        Assert.assertEquals(expectedList,actualList);

    }


    //Scenario 3

    @Then("user selects {string} method")
    public void user_selects_method(String string) {
        List<String> actualList=BrowserUtils.getElementsText(new FleetVehiclesPage().FiltersItemControlBoxAllElement_Locator);
        for(int i=0; i<actualList.size(); i++){


            if(actualList.get(i).equals(string)){
                new FleetVehiclesPage().FiltersItemControlBoxAllElement_Locator.get(i).click();
                break;
            }
        }
    }

    @Then("the user enters start value {string} end value {string}")
    public void the_user_enters_start_value_end_value(String string, String string2) {
        new FleetVehiclesPage().BetweenStartInputBox_Locator.sendKeys(string);
        new FleetVehiclesPage().BetweenEndInputBox_Locator.sendKeys(string2);

    }

    @Then("click the Update button")
    public void click_the_Update_button() {
     new FleetVehiclesPage().BetweenUpdateButton_Locator.click();
     BrowserUtils.waitFor(2);


    }

    @Then("results table should only show Last Odometer between {string} to {string}")
    public void results_table_should_only_show_Last_Odometer_between_to(String string, String string2) {
       double start=Double.parseDouble(string.replace(",",""));
       double end=Double.parseDouble(string2.replace(",",""));

       for(WebElement a: new FleetVehiclesPage().LastOdometerTableColumn_Locator){
           if(start<=Double.parseDouble(a.getText().replace(",",""))&&end>=Double.parseDouble(a.getText().replace(",",""))){
               Assert.assertTrue(true);
           }
           else{Assert.assertTrue(false);}
       }

    }

    //Scenario 3
    @Then("the user enters value {string}")
    public void the_user_enters_value(String string) {
        new FleetVehiclesPage().BetweenStartInputBox_Locator.sendKeys(string);
    }

    @Then("All the results should match {string} exactly")
    public void all_the_results_should_match_exactly(String string) {
        double equalitem = Double.parseDouble(string.replace(",",""));
        List<String> actualList = BrowserUtils.getElementsText(new FleetVehiclesPage().LastOdometerTableColumn_Locator);

        if (!actualList.isEmpty()) {
            for (WebElement a : new FleetVehiclesPage().LastOdometerTableColumn_Locator) {
                if (equalitem == Double.parseDouble(a.getText().replace(",",""))) {
                    Assert.assertTrue(true);
                } else {
                    Assert.assertTrue(false);
                }
            }
        }
        else {
          Assert.assertTrue(true);
        }
    }

    @Then("All the results should be more than {string} value")
    public void all_the_results_should_be_more_than_value(String string) {
      if(string.contains(",")) string.replace(",","");
        double item = Double.parseDouble(string);

        List<String> actualList = BrowserUtils.getElementsText(new FleetVehiclesPage().LastOdometerTableColumn_Locator);

        if (!actualList.isEmpty()) {
            for (WebElement a : new FleetVehiclesPage().LastOdometerTableColumn_Locator) {
                if (item < Double.parseDouble(a.getText().replace(",",""))) {
                    Assert.assertTrue(true);
                } else {
                    Assert.assertTrue(false);
                }
            }
        }
        else {
            Assert.assertTrue(true);
        }



    }
    @Then("All the results should be less than {string} value")
    public void all_the_results_should_be_less_than_value(String string) {
        if(string.contains(",")) string.replace(",","");
        double item = Double.parseDouble(string);
        List<String> actualList=new ArrayList<>();
        for (String a  :BrowserUtils.getElementsText(new FleetVehiclesPage().LastOdometerTableColumn_Locator) ) {
           if(a.contains(",")) a.replace(",","");
           actualList.add(a);
        }

        if (!actualList.isEmpty()) {
            for (String a : actualList) {
                if (item > Double.parseDouble(a)) {
                    Assert.assertTrue(true);
                } else {
                    Assert.assertTrue(false);
                }
            }
        }
        else {
            Assert.assertTrue(true);
        }
    }
    @Then("only empty values should be displayed")
    public void only_empty_values_should_be_displayed() {
        List<String> actualList=BrowserUtils.getElementsText(new FleetVehiclesPage().LastOdometerTableColumn_Locator);

        if (!actualList.isEmpty()) {
            for (String a : actualList) {
                if (a.isEmpty()) {
                    Assert.assertTrue(true);
                } else {
                    Assert.assertTrue(false);
                }
            }
        }
        else {
            Assert.assertTrue(true);
        }
    }

    @Then("click the Update button and result table should not change")
    public void click_the_Update_button_and_result_table_should_not_change() {
        int total_first=new FleetVehiclesPage().totalItem();
        new FleetVehiclesPage().BetweenUpdateButton_Locator.click();
        BrowserUtils.waitFor(1);
        int total_last=new FleetVehiclesPage().totalItem();
        Assert.assertEquals(total_last,total_first);

    }

}


