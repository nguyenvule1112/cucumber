package stepdeginitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Hooks {
    public static WebDriver driver;

    @Before
    public void setup(){
        String browser = "chrome";
        switch (browser)
        {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOption = new ChromeOptions();
                chromeOption.addArguments("--user-data-dir=C:\\Users\\admin\\AppData\\Local\\Google\\Chrome\\User Data\\");
                chromeOption.addArguments("--profile-directory=Profile 4");

                driver = new ChromeDriver(chromeOption);
                break;
            case  "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            default:
                throw new RuntimeException("The driver name is not supported");
        }
    }

    @After
    public void tearDown(Scenario scenario)
    {
        if(scenario.isFailed())
        {
            byte[] img= ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(img, "image/png","error");
        }
        driver.quit();
    }
}
