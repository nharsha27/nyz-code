package pageObjects;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import Exception.InvalidValuePassedException;
import java.time.Duration;
import static common.CommonConst.*;

public class HowMuchBorrowPage {

    private WebDriver driver;
    public static WebDriverWait wait;

    //By Locators
    private By Single = By.cssSelector("label[for='application_type_single']");
    private By Joint = By.cssSelector("label[for='application_type_joint']");
    private By Number_of_dependents = By.cssSelector("select[title='Number of dependants']");
    private By homeToLiveInProperty = By.cssSelector("label[for='borrow_type_home']");
    private By residentialInvestmentProperty = By.cssSelector("label[for='borrow_type_investment']");
    private By yourAnnualIncomeBeforeTax =By.cssSelector("input[aria-describedby$='q2q1i1 q2q1i2']");
    private By yourAnnualOtherIncome =By.cssSelector("input[aria-labelledby='q2q2']");
    private By secondApplicantAnnualIncome  = By.cssSelector("input[aria-labelledby='q2q3']");
    private By secondApplicantOtherAnnualIncome  =By.cssSelector("input[aria-labelledby='q2q4']");

    private By monthlyLivingExpense = By.cssSelector("input[aria-labelledby='q3q1']");
    private By homeLoanMonthlyRepayments = By.cssSelector("input[aria-labelledby='q3q2']");
    private By otherLoanMonthlyRepayment = By.cssSelector("input[aria-labelledby='q3q3']");
    private By otherMonthlyCommitments = By.cssSelector("input[aria-labelledby='q3q4']");
    private By totalCreditCardLimit = By.cssSelector("input[aria-labelledby='q3q5']");
    private By WorkOutHowMuchICouldBorrowButton = By.cssSelector("button#btnBorrowCalculater");
    private By EstimatedBorrowAmount = By.cssSelector("span#borrowResultTextAmount");
    private By StartOver = By.cssSelector("button[class='start-over']");
    private By ErrorText = By.cssSelector("div[class='borrow__error__text']");

    public HowMuchBorrowPage(WebDriver driver)
    {
        WebDriverManager.chromedriver().setup();
        this.driver = driver;
    }

    public  void selectApplicationType(String applicationType) throws InvalidValuePassedException {

        WebElement webElement = null;
        if(applicationType.equalsIgnoreCase(SINGLE_APPLICATION_TYPE))
        {
            webElement = driver.findElement(Single);
            webElement.click();
        }
        else if(applicationType.equalsIgnoreCase(JOINT_APPLICATION_TYPE))
        {
            webElement = driver.findElement(Joint);
            webElement.click();
        }
        else
        {
            throw new InvalidValuePassedException(INVALID_APPLICATION_TYPE);
        }

    }
    public  void setNumber_of_dependents(int dependents){
        WebElement numberOfDependents = driver.findElement(Number_of_dependents);
        numberOfDependents.sendKeys(String.valueOf(dependents));
    }
    public  void selectPropertyType(String propertyType) throws InvalidValuePassedException {
        if(propertyType.equalsIgnoreCase(HOME_TO_LIVE_IN_PROPERTY_TYPE))
        {            WebElement homeVal = driver.findElement(homeToLiveInProperty);
            homeVal.click();
        }
        else if(propertyType.equalsIgnoreCase(RESIDENTIAL_INVEST_PROPERTY_TYPE))
        {
            WebElement residentialVal = driver.findElement(residentialInvestmentProperty);
            residentialVal.click();
        }
        else
        {
            throw new InvalidValuePassedException(INVALID_PROPERTY_TYPE);
        }
    }

    /**
     * This block shares your monthly anual incode
     * @param enteredIncome entered income
     */
    public  void enterYourAnnualIncome(String enteredIncome)
    {
        WebElement annualIncome = driver.findElement(yourAnnualIncomeBeforeTax);
        annualIncome.sendKeys(String.valueOf(enteredIncome));
    }

    public  void enterYourAnnualOtherIncome(String annualOtherIncome)
    {
        WebElement yourAnnualOtherIncomeElement = driver.findElement(yourAnnualOtherIncome);
        yourAnnualOtherIncomeElement.sendKeys(String.valueOf(annualOtherIncome));
    }

    public  void enterMonthlyLivingExpenses(String monthlyExpense){
        WebElement monthlyExpenseElement = driver.findElement(monthlyLivingExpense);
        monthlyExpenseElement.sendKeys(monthlyExpense);
    }
    public  boolean checkIfMonthlyLivingExpensesIsEmpty(){
       WebElement monthlyExpense = driver.findElement(monthlyLivingExpense);
        return  monthlyExpense.getAttribute("value").equals("0") ;
    }
    public  void enterCurrentHomeLoanMonthlyRepayments(String homeLoanRepayment){
        WebElement currentHomeLoanRepaymentElement = driver.findElement(homeLoanMonthlyRepayments);
        currentHomeLoanRepaymentElement.sendKeys(String.valueOf(homeLoanRepayment));
    }

    public  void enterOtherLoanMonthlyRepayments(String otherLoanRepayments){
        WebElement otherLoanMonthlyRepaymentElement = driver.findElement(otherLoanMonthlyRepayment);
        otherLoanMonthlyRepaymentElement.sendKeys(String.valueOf(otherLoanRepayments));
    }

    public  void enterOtherMonthlyCommitments(String otherMonthlyComitVal){
        WebElement monthlyCommitments = driver.findElement(otherMonthlyCommitments);
        monthlyCommitments.sendKeys(String.valueOf(otherMonthlyComitVal));
    }

    public  void enterTotalCreditCardLimits(String totalCreditCardLimitVal){
        WebElement totalCreditCardLimitElement = driver.findElement(totalCreditCardLimit);
        totalCreditCardLimitElement.sendKeys(String.valueOf(totalCreditCardLimitVal));
    }

    public void clickWorkOutHowMuchICouldBorrowButton(){
            WebElement howMuchICouldBorrowButton = driver.findElement(WorkOutHowMuchICouldBorrowButton);
            howMuchICouldBorrowButton.click();
    }

    public String showEstimatedAmountThatCanBeBorrowed(){
        WebElement estimatedBorrowAmount = driver.findElement(EstimatedBorrowAmount);
        return estimatedBorrowAmount.getText();
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



