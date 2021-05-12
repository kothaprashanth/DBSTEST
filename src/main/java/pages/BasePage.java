package pages;

import io.cucumber.java.After;
import io.cucumber.java.lv.Ja;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

import java.util.List;

public class BasePage {

    private static WebDriver driver;

    public void loadDriver()
    {
          System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
          driver= new ChromeDriver();
    }

    private  WebDriver getDriver()
    {
        if(driver==null)
        {
            loadDriver();
        }
       return driver;
    }

    public void launchApplication()
    {
        getDriver().get("https://www.dbs.com.sg/personal/default.page");
        driver.manage().window().maximize();
    }

    protected WebElement getElement(By by)
    {
        return driver.findElement(by);
    }
    protected List<WebElement> getElements(By by)
    {
        return driver.findElements(by);
    }
    protected void scrollElementIntoView(WebElement element)
    {
        JavascriptExecutor js= (JavascriptExecutor)driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void waitUntilVisible(By by)
    {
        WebDriverWait wait=new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }
    public void genericWait()
    {
       try {
           Thread.sleep(5000);
       }
       catch (Exception e)
       {}
    }
    public void quitDriver()
    {
        driver.quit();
    }




}
