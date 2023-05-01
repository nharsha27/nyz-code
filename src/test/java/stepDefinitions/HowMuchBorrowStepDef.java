package stepDefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageObjects.HowMuchBorrowPage;
import util.TestUtil;
import Exception.InvalidValuePassedException;

import java.text.ParseException;

public class HowMuchBorrowStepDef {
    private WebDriver driver;
    private HowMuchBorrowPage howMuchBorrowPage;


    @Before
    public void setup()
    {
        this.driver = TestUtil.setChromeDriver();
    }


    @Given("I landed on Calculate How much I could borrow page")
    public void i_landed_on_calculate_how_much_i_could_borrow_page() {
        driver.get("https://www.anz.com.au/personal/home-loans/calculators-tools/much-borrow/");
    }

    @Given("I have entered person's following details: {string},  {int},  {string} ,{string}, {string}, {string}, {string}, {string}, {string}, {string}")
    public void i_have_entered_person_s_following_details(String applicationType, Integer NumberOfDependants, String propertyType, String annualIncome, String annualOtherIncome, String MonthlyLivingExpenses, String CurrentHomeLoanMonthlyRepayments, String OtherLoanMonthlyRepayments, String OtherMonthlyCommitments, String TotalCreditCardLimits) throws ParseException, InvalidValuePassedException {
        howMuchBorrowPage = new HowMuchBorrowPage(driver);
        howMuchBorrowPage.selectApplicationType(applicationType);
        howMuchBorrowPage.setNumber_of_dependents(NumberOfDependants);
        howMuchBorrowPage.selectPropertyType(propertyType);
        howMuchBorrowPage.enterYourAnnualIncome(TestUtil.getValue(annualIncome));
        howMuchBorrowPage.enterYourAnnualOtherIncome(TestUtil.getValue(annualOtherIncome));
        howMuchBorrowPage.enterMonthlyLivingExpenses(TestUtil.getValue(MonthlyLivingExpenses));
        howMuchBorrowPage.enterCurrentHomeLoanMonthlyRepayments(TestUtil.getValue(CurrentHomeLoanMonthlyRepayments));
        howMuchBorrowPage.enterOtherLoanMonthlyRepayments(TestUtil.getValue(OtherLoanMonthlyRepayments));
        howMuchBorrowPage.enterOtherMonthlyCommitments(TestUtil.getValue(OtherMonthlyCommitments));
        howMuchBorrowPage.enterTotalCreditCardLimits(TestUtil.getValue(TotalCreditCardLimits));

    }

    @Given("I have entered person's living expense {string}")
    public void i_have_entered_person_s_living_expense(String livingExpense) throws ParseException {
        howMuchBorrowPage = new HowMuchBorrowPage(driver);
        howMuchBorrowPage.enterMonthlyLivingExpenses(TestUtil.getValue(livingExpense));
    }

    @When("I click on Work Out how much I could borrow button")
    public void i_click_on_work_out_how_much_i_could_borrow_button() {
        howMuchBorrowPage = new HowMuchBorrowPage(driver);
        howMuchBorrowPage.clickWorkOutHowMuchICouldBorrowButton();
    }

    @Then("Borrowing estimate is displayed on the screen {string}")
    public void borrowing_estimate_is_displayed_on_the_screen(String input) throws InterruptedException {
        Thread.sleep(5000);
        String result = howMuchBorrowPage.showEstimatedAmountThatCanBeBorrowed();
        Assert.assertEquals(input,result);
    }

    @When("I click on start over button")
    public void i_click_on_start_over_button()
    {
        howMuchBorrowPage.clickStartOver();
    }

    @Then("Form is cleared")
    public void form_is_cleared() {
    Assert.assertTrue(howMuchBorrowPage.checkIfMonthlyLivingExpensesIsEmpty());
    }

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

    @Then("I get Borrow Error Message {string}")
    public void i_get_borrow_error_message(String input) throws InterruptedException {
        Thread.sleep(5000);
        String result = howMuchBorrowPage.checkErrorMessage();
        Assert.assertEquals(input,result);

    }

}
