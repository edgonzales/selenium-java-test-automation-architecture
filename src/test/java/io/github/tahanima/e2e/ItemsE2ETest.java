package io.github.tahanima.e2e;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import io.github.tahanima.ui.page.BasePage;
import io.github.tahanima.ui.page.ItemsPage;
import io.github.tahanima.util.TestRetry;

import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.util.List;


/**
 * @author tahanima
 */

public final class ItemsE2ETest extends BaseE2ETest {

    ItemsPage itemsPage = new ItemsPage();

    @AfterMethod(alwaysRun = true)
    public void captureScreenshotOnFailure(ITestResult result) {
        ITestNGMethod method = result.getMethod();

        if (ITestResult.FAILURE == result.getStatus()) {
            loginPage.captureScreenshot(
                    String.format(
                            "%s_%s_%s",
                            method.getRealClass().getSimpleName(),
                            method.getMethodName(),
                            method.getParameterInvocationCount()));
        }
    }

    @Test(
            testName = "TC-100",
            enabled = false,
            groups = {"smoke", "regression"})
    public void testPageDisplays() {
        itemsPage.goToEcommerceSite("https://www.ebay.com/");
        assertThat(itemsPage.getTheUrl()).isEqualTo("https://www.ebay.com/");
        itemsPage.tearDownChrome();
    }

    @Test(
            testName = "TC-101",
            enabled = true,
            groups = {"smoke", "regression"}
            )
    public void searchForTerm()  {
        itemsPage.goToEcommerceSite("https://www.ebay.com/");
        assertThat(itemsPage.getTheUrl()).isEqualTo("https://www.ebay.com/");
        itemsPage.navigateToSearch();
        itemsPage.searchForTerm("socks");
        itemsPage.navigateToLastPage();
        itemsPage.addToCart();
        itemsPage.setQuantityToFive();

        // soft assert each title in the results section to check for a search term match
        //System.out.println(itemsPage.getListingCardTitles());

//        List<String>  titles = itemsPage.getTitlesForEachItem();
//        SoftAssertions softAssertions = new SoftAssertions();
//        String searchTerm = "calendar";
//
//        for (String title : titles) {
//            softAssertions.assertThat(title).contains(searchTerm);
//        }
//        softAssertions.assertAll();


        itemsPage.tearDownChrome();
    }






}