package TestComponents;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pageObjects.HowMuchICouldBorrowPage;

import java.time.Duration;


public class BaseTest {
    WebDriver driver;
    public WebDriver initializeDriver(){
        ChromeOptions option = new ChromeOptions();
        option.addArguments("--remote-allow-origins=*");

        //WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(option);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        return driver;
    }

    public HowMuchICouldBorrowPage launchApplication(){
        driver= initializeDriver();
        HowMuchICouldBorrowPage howMuchICouldBorrowPage = new HowMuchICouldBorrowPage(driver);
        howMuchICouldBorrowPage.goTo();
        return howMuchICouldBorrowPage;

    }
}


