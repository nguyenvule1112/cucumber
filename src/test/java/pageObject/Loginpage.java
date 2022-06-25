package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Loginpage {
    @FindBy(css = "input[type=\"email\"]")
    WebElement tbUsername;
    @FindBy(css = "input[type=\"password\"]")
    WebElement tbPassword;
    @FindBy(css = "div.row-command button")
    WebElement btnLogin;

    By locpopupMsg = By.cssSelector("div.body-message b");

    WebDriver driver;
    public Loginpage(WebDriver driver)
    {
        this.driver = driver;
    }

    public void open(){
        this.driver.get("http://www.testmaster.vn/admin");
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        PageFactory.initElements(this.driver,this);
    }

    public void inputUsername(String username)
    {
        this.tbUsername.sendKeys(username);
    }

    public void inputPassword(String password)
    {
        this.tbPassword.sendKeys(password);
    }

    public void loginwithUsernameandPassword(String username,String password)
    {
        this.tbUsername.sendKeys(username);
        this.tbPassword.sendKeys(password);
        btnLogin.click();
    }

    public String getPopupMsg()
    {
        WebDriverWait wait= new WebDriverWait(this.driver,Duration.ofSeconds(15));
        WebElement lbMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(locpopupMsg));
        return lbMsg.getText();
    }
}
