package pages;

import exceptions.InvalidInputException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.Map;

public class CardDetailsPage extends BasePage {

    public static class GUIMap{

        static By eltCardName= By.xpath("//div[contains(@id,'comparisonResults')]/div/div[contains(@class,'container-header')]");

        static By cardContainer=By.xpath("./parent::div[contains(@id,'card')]");

        static By relBestFor=By.xpath("./div[contains(@class,'section-seperator')][1]/div[@class='sub-header' and contains(@style,'height')][1]");
        static By relCardType=By.xpath("./div[contains(@class,'section-seperator')][1]/div[@class='sub-header' and contains(@style,'height')][2]");
        static By relMinIncomePerAnnum=By.xpath("./div[contains(@class,'section-seperator')][1]/div[@class='sub-header' and contains(@style,'height')][3]");
        static By relMinIncomePerAnnumForeigner=By.xpath("./div[contains(@class,'section-seperator')][1]/div[@class='sub-header' and contains(@style,'height')][4]");
        static By relAnnualFeeWaiver=By.xpath("./div[contains(@class,'section-seperator')][1]/div[@class='sub-header' and contains(@style,'height')][5]");

    }


    private WebElement getCardElement(String cardName)
    {
        for (WebElement element:getElements(GUIMap.eltCardName))
        {
            if(element.getText().trim().equals(cardName.trim()))
            {
                return element.findElement(GUIMap.cardContainer);
            }
        }
        throw new InvalidInputException("CardName Not Matched.Please Check The Input");
    }

    public Map<String,String> getCardDetails(String cardName)
    {
        WebElement cardElement=getCardElement(cardName);
        Map<String,String> cardDetails=new HashMap<>();
        cardDetails.put("BestFor",cardElement.findElement(GUIMap.relBestFor).getText());
        cardDetails.put("CardType",cardElement.findElement(GUIMap.relCardType).getText());
        cardDetails.put("MinIncomePerAnnum",cardElement.findElement(GUIMap.relMinIncomePerAnnum).getText());
        cardDetails.put("MinIncomePerAnnumForeigner",cardElement.findElement(GUIMap.relMinIncomePerAnnumForeigner).getText());
        cardDetails.put("AnnualFeeWaiver",cardElement.findElement(GUIMap.relAnnualFeeWaiver).getText());

        return cardDetails;


    }






}


