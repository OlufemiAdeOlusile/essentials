package com.ecsd.automation.pageobjects.pages;

import com.ecsd.automation.brand.Calculations;
import com.ecsd.automation.pageobjects.BasePageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static com.ecsd.automation.core.dsl.WebDriverDsl.*;

/**
 * @author olufemi on 2021-09-22
 */
public class HomePage extends BasePageObject<HomePage> {

    public static final String SUCCESS_KEYWORD = "correct";
    private static String SUBMIT_CHALLENGE = "[data-test-id='submit-%s']";
    @FindBy(css = "[data-test-id='render-challenge']")
    private WebElement renderTheChallengeButton;
    @FindBy(css = "[data-test-id='submit-1']")
    private WebElement submitChallenge1;
    @FindBy(css = "[data-test-id='table-row']")
    private List<WebElement> challengeTableRows;
    @FindBy(css = "[data-test-id='submit-answers']")
    private WebElement submitAnswers;
    @FindBy(css = "[data-test-id='success-message']")
    private WebElement successMessage;
    @FindBy(css = "[data-test-id='close-button']")
    private WebElement closeButton;
    private Calculations calculations = new Calculations();


    public void open() {
        openUrl(URL);
        waitForPage();
    }

    @Override
    public HomePage waitForPage() {
        waitForNewPage(renderTheChallengeButton);
        return this;
    }

    public HomePage renderTheChallenge() {
        clickUntilElementVisible(renderTheChallengeButton, submitChallenge1);
        return this;
    }

    public HomePage submitChallenge(String name, String successKeyWord) {
        AtomicInteger submitChallengeRowNumber = new AtomicInteger();
        String indexOfBalancedArray = "0";

        for (WebElement f : challengeTableRows) {
            int[] arrayOfValuesFromRow = getArrayOfValuesFromRow(f);
            int length = arrayOfValuesFromRow.length;

            if (successKeyWord.equals(SUCCESS_KEYWORD)) {
                indexOfBalancedArray = (calculations.getIndexOfBalancedArray(length, arrayOfValuesFromRow));
            }

            WebElement submitChallenge = getSubmitChallengeTextField(submitChallengeRowNumber.addAndGet(1));

            fillText(submitChallenge, indexOfBalancedArray);
        }

        fillText(getSubmitChallengeTextField(challengeTableRows.size() + 1), name);

        submitAnswers.click();

        return this;
    }


    public HomePage verifyMessage(String message) {
        waitForElementToBeVisible(successMessage);

        /*
         Success Message shows wrong message for a few milli seconds before the correct one
         We have inserted a wait to ensure we wait for the page to display the correct message
         We can consider this a bug.
         */
        delayFor3Seconds();
        Assert.assertTrue(successMessage.getText().contains(message));

        closeButton.click();
        waitForElementToNotBeVisible(successMessage);
        return this;
    }


    private int[] getArrayOfValuesFromRow(WebElement element) {
        return element.findElements(By.tagName("td")).stream().mapToInt(f -> Integer.valueOf(f.getText())).toArray();
    }

    private WebElement getSubmitChallengeTextField(int number) {
        return driver.findElement(By.cssSelector(String.format(SUBMIT_CHALLENGE, number)));
    }


}
