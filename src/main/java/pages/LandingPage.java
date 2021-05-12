package pages;

import com.google.inject.Guice;
import exceptions.InvalidInputException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LandingPage extends BasePage {

    public static class GUIMap{

        static By eltCards=By.xpath("//div[@class='navbar-inner']/div[contains(@class,'navbar-links')]/ul/li/a[contains(@href,'personal/cards')]");
        static By eltCreditCards=By.xpath("//a[contains(@data-ajax,'personal/cards/cards-comparator')]");
        static By eltCardContainer=By.xpath("//div[contains(@class,'cardContainer')]");

        //Relative to Card Container
        static By relativeName=By.xpath("./div/div[contains(@class,'header')]");
        static By relativeCheckBox=By.xpath("./div[contains(@class,'footer')]/div/label/div/span");


        static By eltCompareBtn=By.xpath("//button[contains(@id,'cardCompareBtn')]");


    }

    public void clickOnCards()
    {
        getElement(GUIMap.eltCards).click();

    }

    public void clickOnCreditCards()
    {
        getElement(GUIMap.eltCreditCards).click();
    }

    public void selectCheckBox(String cardName)
    {
        getWebElement(cardName).findElement(GUIMap.relativeCheckBox).click();
    }

    public WebElement getWebElement(String cardName)
    {
        for (WebElement element:getElements(GUIMap.eltCardContainer))
        {
            if(element.findElement(GUIMap.relativeName).getText().trim().equals(cardName.trim()))
            {
                scrollElementIntoView(element);
                return element;
            }
        }
        throw new InvalidInputException("CardName Doesn't Match.Please check the Input");
    }

    public void clickOnCompareButton()
    {
        getElement(GUIMap.eltCompareBtn).click();
    }

}
