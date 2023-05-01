package stepDefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import pageObjects.HowMuchICouldBorrowPage;

import java.time.Duration;

public class HowMuchCouldIBorrowStepDefinition {
    private WebDriver driver;
    private HowMuchICouldBorrowPage howMuchICouldBorrowPage;


    @Before
    public void setup()
    {
        ChromeOptions option = new ChromeOptions();
        option.addArguments("--remote-allow-origins=*");

          WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver(option);
    }


    @Given("I landed on Calculate How much I could borrow page")
    public void i_landed_on_calculate_how_much_i_could_borrow_page() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        driver.get("https://www.anz.com.au/personal/home-loans/calculators-tools/much-borrow/");

    }

    @Given("I have entered person's following details: {string},  {int},  {string} ,{string}, {string}, {string}, {string}, {string}, {string}, {string}")
    public void i_have_entered_person_s_following_details(String applicationType, Integer NumberOfDependants, String propertyType, String annualIncome, String annualOtherIncome, String MonthlyLivingExpenses, String CurrentHomeLoanMonthlyRepayments, String OtherLoanMonthlyRepayments, String OtherMonthlyCommitments, String TotalCreditCardLimits)
    {
        howMuchICouldBorrowPage = new HowMuchICouldBorrowPage(driver);
        howMuchICouldBorrowPage.selectApplicationType(applicationType);
        howMuchICouldBorrowPage.setNumber_of_dependents(NumberOfDependants);
        howMuchICouldBorrowPage.selectPropertyType(propertyType);
        howMuchICouldBorrowPage.enterYourAnnualIncome(annualIncome);
        howMuchICouldBorrowPage.enterYourAnnualOtherIncome(annualOtherIncome);
        howMuchICouldBorrowPage.enterMonthlyLivingExpenses(MonthlyLivingExpenses);
        howMuchICouldBorrowPage.enterCurrentHomeLoanMonthlyRepayments(CurrentHomeLoanMonthlyRepayments);
        howMuchICouldBorrowPage.enterOtherLoanMonthlyRepayments(OtherLoanMonthlyRepayments);
        howMuchICouldBorrowPage.enterOtherMonthlyCommitments(OtherMonthlyCommitments);
        howMuchICouldBorrowPage.enterTotalCreditCardLimits(TotalCreditCardLimits);

    }
    @When("I click on Work Out how much I could borrow button")
    public void i_click_on_work_out_how_much_i_could_borrow_button() {
        howMuchICouldBorrowPage.clickWorkOutHowMuchICouldBorrowButton();
    }

    @Then("Borrowing estimate is displayed on the screen {string}")
    public void borrowing_estimate_is_displayed_on_the_screen(String input) throws InterruptedException {
        Thread.sleep(5000);
        String result = howMuchICouldBorrowPage.showEstimatedAmountThatCanBeBorrowed();
        Assert.assertEquals(input,result);
    }


    @Given("I have entered person's following details:{string}")
    public void i_have_entered_persons_following_details(String MonthlyLivingExpenses)throws InterruptedException
    {
        howMuchICouldBorrowPage = new HowMuchICouldBorrowPage(driver);
        howMuchICouldBorrowPage.enterMonthlyLivingExpenses(MonthlyLivingExpenses);

    }
    @Then("Borrowing Error is displayed : {string}")
    public void borrowing_error_is_displayed(String input) throws InterruptedException {
        Thread.sleep(5000);
        String result = howMuchICouldBorrowPage.checkErrorMessage();
        Assert.assertEquals(input,result);
    }











}