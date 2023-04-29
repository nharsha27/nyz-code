package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;

public class HowMuchICouldBorrowPage {

    private WebDriver driver;
    public static WebDriverWait wait;

    //By Locators
    private By Single = By.cssSelector("label[for='application_type_single']");
    private By Joint = By.cssSelector("label[for='application_type_joint']");
    private By Number_of_dependents = By.cssSelector("select[title='Number of dependants']");
    private By Home_to_live_in = By.cssSelector("label[for='borrow_type_home']");
    private By Residential_Investment = By.cssSelector("label[for='borrow_type_investment']");
    private By Your_annual_income =By.cssSelector("input[aria-describedby$='q2q1i1 q2q1i2']");
    private By Monthly_living_expenses = By.cssSelector("input[aria-labelledby='q2q2']");
    private By Current_home_loan_monthly_repayments = By.cssSelector("input[aria-labelledby='q2q2']");
    private By Other_loan_monthly_repayments = By.cssSelector("input[aria-labelledby='q2q2']");
    private By Other_monthly_commitments = By.cssSelector("input[aria-labelledby='q2q2']");
    private By Total_credit_card_limits = By.cssSelector("input[aria-labelledby='q2q2']");
    private By WorkOutHowMuchICouldBorrowButton = By.cssSelector("button#btnBorrowCalculater");
    private By StartOver = By.cssSelector("button[class='start-over']");

    public  void selectApplicationType(String applicationType){
        if(applicationType.equalsIgnoreCase("Single")){
            WebElement singleType = driver.findElement(Single);
            singleType.click();
        }else {
            WebElement jointType = driver.findElement(Joint);
            jointType.click();
        }
    }
    public  void setNumber_of_dependents(int dependents){
        WebElement numberOfDependents = driver.findElement(Number_of_dependents);
        numberOfDependents.sendKeys("dependents");
    }
    public  void selectPropertyType(String propertyType){
        if(propertyType.equalsIgnoreCase("Home To Live In")){
        WebElement homeToLiveIn = driver.findElement(Home_to_live_in);
        homeToLiveIn.click();
    }else {
            WebElement residentialInvestment = driver.findElement(Residential_Investment);
            residentialInvestment.click();
        }
    }
    public  void enterYourAnnualIncome(int annualIncome){
        WebElement yourAnnualIncome = driver.findElement(Your_annual_income);
        yourAnnualIncome.sendKeys("annualIncome");
    }

    public  void enterYourAnnualOtherIncome(int annualOtherIncome){
        WebElement yourAnnualOtherIncome = driver.findElement(Your_annual_income);
        yourAnnualOtherIncome.sendKeys("annualOtherIncome");
    }

    public  void enterMonthlyLivingExpenses(int monthlyExpenses){
        WebElement monthlyLivingExpenses = driver.findElement(Monthly_living_expenses);
        monthlyLivingExpenses.sendKeys("monthlyExpenses");
    }

    public  void enterCurrentHomeLoanMonthlyRepayments(int homeLoanRepayments){
        WebElement currentHomeLoanMonthlyRepayments = driver.findElement(Current_home_loan_monthly_repayments);
        currentHomeLoanMonthlyRepayments.sendKeys("homeLoanRepayments");
    }

    public  void enterOtherLoanMonthlyRepayments(int otherLoanRepayments){
        WebElement otherLoanMonthlyRepayments = driver.findElement(Other_loan_monthly_repayments);
        otherLoanMonthlyRepayments.sendKeys("otherLoanRepayments");
    }

    public  void enterOtherMonthlyCommitments(int otherMonthlyCommitments){
        WebElement monthlyCommitments = driver.findElement(Other_monthly_commitments);
        monthlyCommitments.sendKeys("otherMonthlyCommitments");
    }

    public  void enterTotalCreditCardLimits(int totalCreditCardLimits){
        WebElement totalCreditCardLimit = driver.findElement(Other_loan_monthly_repayments);
        totalCreditCardLimit.sendKeys("totalCreditCardLimits");
    }

    public void clickWorkOutHowMuchICouldBorrowButton(){
            WebElement howMuchICouldBorrowButton = driver.findElement(WorkOutHowMuchICouldBorrowButton);
            howMuchICouldBorrowButton.click();
    }

    public void clickStartOver(){
        WebElement startOver = driver.findElement(StartOver);
        visibilityOfElementLocated(startOver);


       }

    public void setExplicitWait(int seconds){
         wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
    }
    public void visibilityOfElementLocated(WebElement webElement) {
        setExplicitWait(100);
        wait.until(ExpectedConditions.elementToBeClickable(webElement)).click();

    }

        }



