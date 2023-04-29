package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;



import java.time.Duration;
import java.util.List;
import java.util.Set;

public class Calculator {
    public static void main(String[] args) throws InterruptedException {

        ChromeOptions option = new ChromeOptions();
        option.addArguments("--remote-allow-origins=*");

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(option);
       // WebDriverManager.chromedriver().setup();
        //WebDriver driver= new ChromeDriver();
       // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.anz.com.au/personal/home-loans/calculators-tools/much-borrow/");
        driver.findElement(By.cssSelector("label[for='application_type_single']")).click();
        driver.findElement(By.cssSelector("select[title='Number of dependants']")).sendKeys("4");
        driver.findElement(By.cssSelector("input[aria-describedby$='q2q1i1 q2q1i2']")).sendKeys("80000");
        driver.findElement(By.cssSelector("input[aria-labelledby='q2q2']")).sendKeys("10000");
        driver.findElement(By.cssSelector("input[aria-labelledby='q3q1']")).sendKeys("500");
        driver.findElement(By.cssSelector("input[aria-labelledby='q3q2']")).sendKeys("0");
        driver.findElement(By.cssSelector("input[aria-labelledby='q3q3']")).sendKeys("100");
        driver.findElement(By.cssSelector("input[aria-labelledby='q3q4']")).sendKeys("0");
        driver.findElement(By.cssSelector("input[aria-labelledby='q3q5']")).sendKeys("10000");
        driver.findElement(By.cssSelector("button#btnBorrowCalculater")).click();
        Thread.sleep(5000);
        String estimated_borrow_amount= driver.findElement(By.cssSelector("span#borrowResultTextAmount")).getText();
        System.out.println(estimated_borrow_amount);
        Assert.assertEquals(estimated_borrow_amount, "$180,000");
        Assert
        Thread.sleep(5000);

        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(1000));
     // wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='start-over']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[class='start-over']"))).click();

        Thread.sleep(5000);
        driver.findElement(By.cssSelector("input[aria-labelledby='q3q1']")).sendKeys("500");
        driver.findElement(By.cssSelector("button#btnBorrowCalculater")).click();



      //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[normalize-space()='Apply online now']"))).click();
      //  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='result__restart']//button[@class='start-over']"))).click();



        //driver.findElement(By.xpath("//a[normalize-space()='Apply online now']")).click();
       // new WebDriverWait(driver, 20).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt((By.XPATH,"//iframe[@id='iframe']")))
        //new WebDriverWait(driver, 20).until(EC.element_to_be_clickable((By.XPATH, "//a[text()='Shop Now']"))).click()

            }
}
