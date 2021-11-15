package com.FleetGru.pages;

import com.FleetGru.utilities.ConfigurationReader;
import com.FleetGru.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage  {
  public LoginPage(){ PageFactory.initElements(Driver.get(), this);}

                                        //ALL LOCATOR

    @FindBy(id="prependedInput")
    public  WebElement usernameBox;

    @FindBy(id="prependedInput2")
    public  WebElement passwordBox;

    @FindBy(id="_submit")
    public WebElement loginButton;


                                        //ALL METHODS

        public  void driverLogin1(){        //Can't be static because; Web Elements can be static but not action
        usernameBox.sendKeys(ConfigurationReader.get("driver_username"));
        passwordBox.sendKeys(ConfigurationReader.get("driver_password"));
        loginButton.click();
        }
        public static void driverLogin() {
        LoginPage loginPage=new LoginPage();
        loginPage.driverLogin1();
    }
        public  void salesManagerLogin1(){     //Can't be static because; Web Elements can be static but not action
        usernameBox.sendKeys(ConfigurationReader.get("salesmanager_username"));
        passwordBox.sendKeys(ConfigurationReader.get("salesmanager_password"));
        loginButton.click();
        }
        public static void salesManagerLogin() {
        LoginPage loginPage=new LoginPage();
        loginPage.salesManagerLogin1();
    }
        public  void  storeManagerLogin1(){   //Can't be static because; Web Elements can be static but not action
        usernameBox.sendKeys(ConfigurationReader.get("storemanager_username"));
        passwordBox.sendKeys(ConfigurationReader.get("storemanager_password"));
        loginButton.click();
        }

        public static void storeManagerLogin() {
        LoginPage loginPage=new LoginPage();
        loginPage.storeManagerLogin1();
    }

        public void  login1(String username,String password){  //Can't be static because; Web Elements can be static but not action
         usernameBox.sendKeys(username);
         passwordBox.sendKeys(password);
         loginButton.click();
        }

        public static void login(String username, String password) {
        LoginPage loginPage=new LoginPage();
        loginPage.login1(username, password);
    }


}
