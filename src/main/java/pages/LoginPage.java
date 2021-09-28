package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

  @FindBy(id = "user-name")
  private WebElement userNameField;

  @FindBy(id = "password")
  private WebElement passwordField;

  @FindBy(id = "login-button")
  private WebElement loginButtonField;


  public LoginPage() {
    PageFactory.initElements(getDriver(), this);
  }

  public void enterUserName(String userName) throws InterruptedException {
    userNameField.sendKeys(userName);
      Thread.sleep(2000);
    userNameField.clear();
    Thread.sleep(2000);
  }

  public LoginPage enterPassword(String password) {
    passwordField.sendKeys(password);
    return this;
  }

  public MainPage clickLoginButton() {
    loginButtonField.click();
    return new MainPage();
  }

}
