package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;

public class FirstTestClass extends BaseTest{

  @Test(dataProvider = "getUserNames")
  public void firstTest(String userName) throws InterruptedException {
    LoginPage loginPage = new LoginPage();
    loginPage.enterUserName(userName);
  }

  @DataProvider(name = "getUserNames")
  public Object[][] getUserNames(){
    return new Object[][]{
        {"Oleg"},
        {"ojdsfpo"},
        {"Ivan"},
        {"2323232323"}
    };
  }




//  @Test
//  public void secondTest(){
//    LoginPage loginPage = new LoginPage();
//    loginPage.enterUserName("standard_user")
//        .enterPassword("secret_sauce")
//        .clickLoginButton();
//  }
//
//  @Test
//  public void thirdTest(){
//    LoginPage loginPage = new LoginPage();
//    loginPage.enterUserName("standard_user")
//        .enterPassword("secret_sauce")
//        .clickLoginButton();
//  }
//
//  @Test
//  public void fourthTest(){
//    LoginPage loginPage = new LoginPage();
//    loginPage.enterUserName("standard_user")
//        .enterPassword("secret_sauce")
//        .clickLoginButton();
//  }

}
