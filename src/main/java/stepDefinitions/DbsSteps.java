package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import pages.BasePage;
import pages.CardDetailsPage;
import pages.LandingPage;

import java.util.HashMap;
import java.util.Map;


public class DbsSteps {

    private BasePage basePage=new BasePage();
    private LandingPage landingPage=new LandingPage();
    private CardDetailsPage cardDetailsPage=new CardDetailsPage();
    static final Logger logger = LogManager.getLogger(DbsSteps.class);

    @Given("^the user navigate to DBS Landing Page$")
    public void theUserNavigateToDBSLandingPage() {
        basePage.launchApplication();
    }

    @And("^the user clicks on Cards Option")
    public void theUserClicksOnCardsOption() {
        landingPage.clickOnCards();
    }

    @And("^the user clicks on CreditCards Option$")
    public void theUserClicksOnCreditCardsOption() {
        landingPage.clickOnCreditCards();
    }

    @Then("^User Select Two Credit Cards (.+) and (.+)$")
    public void userSelectTwoCreditCards(String cardOne,String cardTwo) {
        basePage.genericWait();
        landingPage.selectCheckBox(cardOne);
        landingPage.selectCheckBox(cardTwo);
        landingPage.clickOnCompareButton();


    }

    @Then("^User Validates the Details of (.+) and (.+)$")
    public void userValidatesTheDetailsOfCardsSelected(String cardOne,String cardTwo) {

        Map<String,String> cardOneDetails=cardDetailsPage.getCardDetails(cardOne);
        Map<String,String> cardTwoDetails=cardDetailsPage.getCardDetails(cardTwo);

        SoftAssert softAssert=new SoftAssert();

        softAssert.assertEquals(cardOneDetails.get("BestFor"),"It's the fastest way to fly anywhere.");
        softAssert.assertEquals(cardTwoDetails.get("BestFor"),"Shopping is the new black");

        softAssert.assertEquals(cardOneDetails.get("CardType"),"VISA");
        softAssert.assertEquals(cardTwoDetails.get("CardType"),"VISA");

        softAssert.assertEquals(cardOneDetails.get("MinIncomePerAnnum"),"S$30,000");
        softAssert.assertEquals(cardTwoDetails.get("MinIncomePerAnnum"),"S$30,000");

        softAssert.assertEquals(cardOneDetails.get("MinIncomePerAnnumForeigner"),"S$45,000");
        softAssert.assertEquals(cardTwoDetails.get("MinIncomePerAnnumForeigner"),"S$45,000");

        softAssert.assertEquals(cardOneDetails.get("AnnualFeeWaiver"),"1 Year");
        softAssert.assertEquals(cardTwoDetails.get("AnnualFeeWaiver"),"1 Year");
        softAssert.assertAll();
        logger.info("Card Details Are Validated");

    }
    @After
    public void closeBrowsers()
    {
        basePage.quitDriver();
    }


}
