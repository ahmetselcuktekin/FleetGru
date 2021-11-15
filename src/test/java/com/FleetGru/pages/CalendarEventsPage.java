package com.FleetGru.pages;

import com.FleetGru.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


public class CalendarEventsPage extends BasePage {

    public CalendarEventsPage()  {
        PageFactory.initElements(Driver.get(), this);
    }

                            //ALL LOCATOR

    @FindBy( xpath = "//ul[@class='icons-holder']/li[2]/input")
    public WebElement pageNumberLocator;

    @FindBy(xpath = "(//div[@data-toggle='dropdown'])[2]")
    public WebElement optionsTextLocator;

    @FindBy(xpath = "(//div[@class='btn-group'])[2]")
    public WebElement ViewPerPageLocator;

     @FindBy(xpath = "//tbody[@class='grid-body']")
    public WebElement tableLocator;

     @FindBy(xpath = "(//label[@class='dib'])[3]")
     public WebElement numberOfRecordsTextLocator;

     @FindBy(xpath = "(//input[@type='checkbox'])[7]")
     public WebElement selectAllCheckboxLocator;

     @FindBy(xpath = "//tbody[@class='grid-body']/tr/td[1]/input")
     public List<WebElement> allCheckboxLocator;

     @FindBy(xpath = "//tbody[@class='grid-body']/tr/td[text()='Testers Meeting']")
     public WebElement mailTesterMeetingLocator;

     @FindBy(xpath = "(//div[@class='row-fluid'])[1]/div/div/div/div/div/label")
     public List<WebElement> TesterMeetingTitleColumnsLocator;

     @FindBy(xpath = "(//div[@class='row-fluid'])[1]/div/div/div/div/div/div/div")  //or css="div.control-label"
     public List<WebElement> TesterMeetingColumnsLocator;

                                 //ALL METHODS

     public int NumberOfRecord(){
         String[] s = numberOfRecordsTextLocator.getText().trim().split(" ");
         return Integer.parseInt(s[2]);
     }

     public int getTableRow(){
     List<WebElement> tableRows = tableLocator.findElements(By.tagName("tr"));
     return tableRows.size();
     }


}




