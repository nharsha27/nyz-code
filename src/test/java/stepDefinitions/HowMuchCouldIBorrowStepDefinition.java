package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import pageObjects.HowMuchICouldBorrowPage;

import java.math.BigDecimal;
import java.time.Duration;

public class HowMuchCouldIBorrowStepDefinition {
    private WebDriver driver;
    private HowMuchICouldBorrowPage howMuchICouldBorrowPage;


    @Before
    public void setup()
    {
        ChromeOptions option = new ChromeOptions();
        option.addArguments("--remote-allow-origins=*");

      //  WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver(option);
    }


    @Given("I landed on Calculate How much I could borrow page")
    public void i_landed_on_calculate_how_much_i_could_borrow_page() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        driver.get("https://www.anz.com.au/personal/home-loans/calculators-tools/much-borrow/");
        howMuchICouldBorrowPage = new HowMuchICouldBorrowPage(driver);
    }

    @Given("I have entered person's following details: {string},  {int},  {string} ,{BigDecimal}, {int}, {int}, {int}, {int}, {int}, {int}")
    public void i_have_entered_person_s_following_details(String applicationType, Integer NumberOfDependants, String propertyType, BigDecimal annualIncome, Integer annualOtherIncome, Integer MonthlyLivingExpenses, Integer CurrentHomeLoanMonthlyRepayments, Integer OtherLoanMonthlyRepayments, Integer OtherMonthlyCommitments, Integer TotalCreditCardLimits)
    {
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
    public void borrowing_estimate_is_displayed_on_the_screen(String input) {
        Assert.assertEquals(howMuchICouldBorrowPage.showEstimatedAmountThatCanBeBorrowed(),true);
    }

    @When("I click on start over button")
    public void i_click_on_start_over_button() {
        howMuchICouldBorrowPage.clickStartOver();
    }


/*
    @Then("Form is cleared")
    public void form_is_cleared() {
    Assert.assertTrue(howMuchICouldBorrowPage.checkIfMonthlyLivingExpensesIsEmpty());
    }
*/

    @Given("I enter {int} for Living Expense")
    public void i_enter_for_living_expense(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Given("Leaving other fields empty")
    public void leaving_other_fields_empty() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("I get Borrow Error Message")
    public void i_get_borrow_error_message() {
        String expectedError = "Based on the details you've entered, we're unable to give you an estimate of your borrowing power with this calculator. For questions, call us on 1800 035 500.";
        Assert.assertEquals(howMuchICouldBorrowPage.checkErrorMessage(), expectedError);

    }

}
