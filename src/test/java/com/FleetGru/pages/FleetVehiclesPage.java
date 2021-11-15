package com.FleetGru.pages;

import com.FleetGru.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class FleetVehiclesPage extends BasePage{
    @FindBy(xpath = "//a[@*='Filters']")
    public WebElement filterButton_Locator;

    @FindBy(xpath = "//button/a")
    public WebElement manageFiltersButton_Locator;

    @FindBy(xpath = "//li//label")
    public List<WebElement> allManageFiltersItem_Locator;

    @FindBy(xpath = "//tbody/tr/td[7]")
    public List<WebElement> LastOdometerTableColumn_Locator;

    @FindBy(xpath = "//div[@class='filter-start']/input")
    public WebElement BetweenStartInputBox_Locator;

    @FindBy(xpath = "//div[@class='filter-end']/input")
    public WebElement BetweenEndInputBox_Locator;

    @FindBy(xpath = "//button[text()='Update']")
    public WebElement BetweenUpdateButton_Locator;


@FindBy(xpath = "//button[contains(text(),'between')]")
public WebElement FiltersItemControlBoxFirstElement_Locator;

@FindBy(xpath = "//button[contains(text(),'between')]/../ul/li")
public List<WebElement> FiltersItemControlBoxAllElement_Locator;

@FindBy(xpath = "(//label[@class='dib'])[3]")
public WebElement totalItem_Locator;





public int totalItem(){
    String[] str=totalItem_Locator.getText().split(" ");
    int b=Integer.parseInt(str[2]);
    return b;
}
    public List<String> allManageFiltersName(){
        List<String> allItem=new ArrayList<>();
        for(int i=0; i<allManageFiltersItem_Locator.size(); i++){
            allItem.add(allManageFiltersItem_Locator.get(i).getText());
        }
        return allItem;
    }

    public WebElement getManageFiltersItemCheckbox(String item){

        WebElement a= Driver.get().findElement(By.xpath("//label[@title='"+item+"']/input"));
        return a;
    }

    public WebElement getFiltersItemControlBox(String item){
        WebElement a= Driver.get().findElement(By.xpath("//div[contains(text(),'"+item+"')]"));
        return a;

    }

}
