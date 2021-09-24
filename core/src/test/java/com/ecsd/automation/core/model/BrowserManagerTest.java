package com.ecsd.automation.core.model;

import org.mockito.Answers;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

/**
 * @author olufemi on 2021-09-22
 */
public class BrowserManagerTest {

    private BrowserManager under_test;

    @Mock(answer = Answers.RETURNS_DEEP_STUBS)
    private WebDriver driver;


    @BeforeMethod
    public void setup() {
        MockitoAnnotations.initMocks(this);
        under_test = spy(BrowserManager.getInstance());
    }


    @Test
    public void test_getDriver_should_return_the_same_instance_when_used_in_the_same_test_case() {
        //GIVEN
        BrowserConfig config = BrowserConfig.newBuilder().withUrl("TestUrl").build();
        doReturn(driver).when(under_test).getDriver(config);

        //WHEN

        WebDriver driver1 = under_test.getDriver(config);
        WebDriver driver2 = under_test.getDriver(config);


        //THEN
        Assert.assertEquals(driver1, driver2);

    }
}
