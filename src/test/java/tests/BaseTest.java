package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.BasePage;

public class BaseTest {


  @BeforeClass
  public synchronized void setUp() {

    String browser = System.getProperty("browser");

    WebDriver driver;

    if (browser == null) {
      WebDriverManager.chromedriver().setup();
      driver = new ChromeDriver();
    } else {
      switch (browser) {
        case "firefox":
          WebDriverManager.firefoxdriver().setup();
          driver = new FirefoxDriver();
          break;
        case "safari":
          WebDriverManager.safaridriver().setup();
          driver = new SafariDriver();
          break;
        default:
          throw new IllegalStateException("Wrong browser");
      }
    }
    driver.get("https://www.saucedemo.com/");
    driver.manage().window().maximize();
    BasePage.setThreadLocalDriver(driver);
  }

  @AfterClass(alwaysRun = true)
  public void quite() {
    BasePage.getDriver().quit();
    BasePage.getThreadLocalDriver().remove();

  }

}
