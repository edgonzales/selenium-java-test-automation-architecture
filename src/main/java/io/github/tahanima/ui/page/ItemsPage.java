package io.github.tahanima.ui.page;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;

public final class ItemsPage extends BasePage {

    public WebDriver driver = new ChromeDriver();
    JavascriptExecutor js = (JavascriptExecutor) driver;



//    private void typeText(WebElement elem, String text) {
//        elem.sendKeys(text);
//    }

    public String getTheUrl(){
        return driver.getCurrentUrl();
    }

    public void goToEcommerceSite(String url){
        driver.manage().window().fullscreen();
        driver.get(url);
    }

    public void navigateToSearch(){
        driver.findElement(By.linkText("Brand Outlet")).click();
        driver.findElement(By.cssSelector("#s0-17-12-0-1\\[0\\]-0-0-0-27\\[0\\]-0-toggle-button > .b-accordion-text")).click();
        driver.findElement(By.linkText("Champion")).click();
    }

    public void searchForTerm(String searchTerm){
        driver.findElement(By.name("_bkw")).click();
        driver.findElement(By.name("_bkw")).sendKeys(searchTerm);
        driver.findElement(By.name("_bkw")).sendKeys(Keys.ENTER);
    }

    public void navigateToLastPage(){
        driver.manage().window().setSize(new Dimension(1254, 1016));
        js.executeScript("window.scrollTo(0,4092.5)");
    }

    public void addToCart(){
        driver.findElement(By.cssSelector("#s0-28-9-0-1\\[0\\]-0-0 > div.b-pagination > nav > ol > li:nth-child(2)")).click();
        driver.manage().window().setSize(new Dimension(1254, 1016));
        js.executeScript("window.scrollTo(0,3095.5)");
        driver.findElement(By.cssSelector(".s-item:nth-child(17) .s-item__image-wrapper")).click();
        driver.findElement(By.cssSelector(".x-atc-action .ux-call-to-action__text")).click();
    }

    public void setQuantityToFive(){
        driver.switchTo().frame(1);
        driver.findElement((By.cssSelector("#mainContent > div.vim.d-vi-region.x-atf-center-river--buybox > div > div.x-buybox__section > div.x-buybox__cta-section > ul > li:nth-child(2) > div > div > div.lightbox-dialog__window.lightbox-dialog__window--animate.keyboard-trap--active > div.lightbox-dialog__main.ht > div > div > div.app-atc-layer-header-wrapper > div > div > button")))
        //driver.findElement(By.linkText("Go to cart")).click();
    }

    public void tearDownChrome(){
        driver.quit();
    }

//    public List<String> getTitlesForEachItem() {
//        List<String> titles = new ArrayList<>();
//        for (WebElement element : listingCardTitles) {
//            titles.add(element.getText());
//        }
//        System.out.println(titles);
//        return titles;
//    }
//
//    public List<String> checkTitlesForEachItem(){
//        return getTitlesForEachItem();
//    }
}
