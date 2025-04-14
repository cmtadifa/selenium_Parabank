package testcase.pom;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

public class homepage {

    private WebDriver driver;

    private By registerLink =  By.linkText("Register");

    public homepage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickRegister() {
        driver.findElement(registerLink).click();
    }


}
