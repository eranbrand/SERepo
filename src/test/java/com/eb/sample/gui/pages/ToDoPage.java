package com.eb.sample.gui.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;


import static java.util.concurrent.TimeUnit.SECONDS;

public class ToDoPage {

    WebDriver drv = new ChromeDriver();
    private FluentWait<WebDriver> fluentWait;

    public ToDoPage(){
        PageFactory.initElements(drv,this);
        fluentWait = new FluentWait<WebDriver>(drv).withTimeout(10,SECONDS).pollingEvery(1,SECONDS).ignoring(NoSuchElementException.class);
    }


    public WebDriver getDrv() {
        return drv;
    }



    @FindBy(className = "new-todo")
    private WebElement txtBx;
    public WebElement getTxtBx() {
        waitUntilAvaiable(txtBx);
        return txtBx;
    }

    @FindBy(css = "body > section > div > section > ul > li:nth-child(1) > div > label")
    private WebElement firstTodo;
    public WebElement getFirstTodo() {
        waitUntilAvaiable(firstTodo);
        return firstTodo;
    }


    public WebElement getNthCheckBx(int n) {
        WebElement nthCheckBx = drv.findElement(By.cssSelector("body > section > div > section > ul > li:nth-child(" + n + ") > div > input"));
        waitUntilAvaiable(nthCheckBx);
        return nthCheckBx;
    }


    protected void waitUntilAvaiable(final WebElement element) {
        WebDriverWait wait = new WebDriverWait(drv,10);
        try {
            fluentWait.until(new com.google.common.base.Function<WebDriver, WebElement>() {
                public WebElement apply(WebDriver driver) {
                    return element;
                }
            });
            wait.until(ExpectedConditions.visibilityOf(element));
            wait.until(ExpectedConditions.elementToBeClickable(element));
        } catch (StaleElementReferenceException | TimeoutException e) {
            System.out.println("Stale element found");
        }
    }

}
