package com.eb.sample.actions;

import com.eb.sample.pages.ToDoPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class ToDoActions {
    ToDoPage page;

    public ToDoActions(){
        page = new ToDoPage();
    }

    public ToDoPage getPage() {
        return page;
    }


    public void loadPage() throws InterruptedException {
        String webDriverType = "webdriver.chrome.driver";
        String webDriverPath = "/Users/eranbrand/Downloads/chromedriver";

        System.setProperty(webDriverType, webDriverPath);

        page.getDrv().get("http://todomvc.com/examples/react/#/");
        Thread.sleep(500);
    }
    public void createTask(String str){
        page.getTxtBx().sendKeys(str);
        page.getTxtBx().sendKeys(Keys.ENTER);
    }

    public String getPlaceHolderText(){
        return page.getTxtBx().getAttribute("placeholder");
    }

    public String getFirstTodoText(){
        return page.getFirstTodo().getText();
    }

    public String getNthTodoText(int n){
        return page.getDrv().findElement(By.cssSelector("body > section > div > section > ul > li:nth-child(" + n + ") > div > label")).getText();
    }

    public void closePage(){
        page.getDrv().close();
        page.getDrv().quit();
    }
}
