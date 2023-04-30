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
    private By homeToLiveIn = By.cssSelector("label[for='borrow_type_home']");
    private By residentialInvestment = By.cssSelector("label[for='borrow_type_investment']");
    private By yourAnnualIncome =By.cssSelector("input[aria-describedby$='q2q1i1 q2q1i2']");
    private By yourAnnualOtherIncome =By.cssSelector("input[aria-labelledby='q2q2']");
    private By secondApplicantAnnualIncome  = By.cssSelector("input[aria-labelledby='q2q3']");
    private By secondApplicantOtherAnnualIncome  =By.cssSelector("input[aria-labelledby='q2q4']");

    private By monthlyLivingExpenses = By.cssSelector("input[aria-labelledby='q2q2']");
    private By currentHomeLoanMonthlyRepayments = By.cssSelector("input[aria-labelledby='q2q2']");
    private By Other_loan_monthly_repayments = By.cssSelector("input[aria-labelledby='q2q2']");
    private By Other_monthly_commitments = By.cssSelector("input[aria-labelledby='q2q2']");
    private By Total_credit_card_limits = By.cssSelector("input[aria-labelledby='q2q2']");
    private By WorkOutHowMuchICouldBorrowButton = By.cssSelector("button#btnBorrowCalculater");
    private By EstimatedBorrowAmount = By.cssSelector("span#borrowResultTextAmount");
    private By StartOver = By.cssSelector("button[class='start-over']");
    private By ErrorText = By.cssSelector("div[class='borrow__error__text']");

    public HowMuchICouldBorrowPage(WebDriver driver) {
        this.driver = driver;
    }

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
        WebElement homeToLiveIn = driver.findElement(this.homeToLiveIn);
        homeToLiveIn.click();
    }else {
            WebElement residentialInvestment = driver.findElement(this.residentialInvestment);
            residentialInvestment.click();
        }
    }
    public  void enterYourAnnualIncome(int annualIncome){
        WebElement yourAnnualIncome = driver.findElement(this.yourAnnualIncome);
        yourAnnualIncome.sendKeys("annualIncome");
    }

    public  void enterYourAnnualOtherIncome(int annualOtherIncome){
        WebElement yourAnnualOtherIncome = driver.findElement(yourAnnualIncome);
        yourAnnualOtherIncome.sendKeys("annualOtherIncome");
    }

    public  void enterMonthlyLivingExpenses(int monthlyExpense){
        WebElement monthlyExpenses = driver.findElement(monthlyLivingExpenses);
        monthlyExpenses.sendKeys("monthlyExpense");
    }
    public  boolean checkIfMonthlyLivingExpensesIsEmpty(){
       WebElement monthlyExpense = driver.findElement(monthlyLivingExpenses);
        return  monthlyExpense.getAttribute("value").equals("0") ;
    }
    public  void enterCurrentHomeLoanMonthlyRepayments(int homeLoanRepayments){
        WebElement currentHomeLoanMonthlyRepayments = driver.findElement(this.currentHomeLoanMonthlyRepayments);
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

    public boolean showEstimatedAmountThatCanBeBorrowed(){
        WebElement estimatedBorrowAmount = driver.findElement(EstimatedBorrowAmount);
        return estimatedBorrowAmount.isDisplayed();

       // estimatedBorrowAmount.getText();

    }

    public void clickStartOver(){
        WebElement startOver = driver.findElement(StartOver);
        visibilityOfElementLocated(startOver);
       }



       public String checkErrorMessage(){
           WebElement errorMessage = driver.findElement(ErrorText);
           String error= errorMessage.getText();
           return error;
       }

    public void setExplicitWait(int seconds){
         wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
    }
    public void visibilityOfElementLocated(WebElement webElement) {
        setExplicitWait(100);
        wait.until(ExpectedConditions.elementToBeClickable(webElement)).click();

    }

        }



