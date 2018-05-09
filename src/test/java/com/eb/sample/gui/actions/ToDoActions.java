package com.eb.sample.gui.actions;

import com.eb.sample.gui.pages.ToDoPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class ToDoActions {
    ToDoPage page;

    public ToDoActions(){
        page = new ToDoPage();
    }

    public ToDoPage getPage() {
        return page;
    }


    public void loadPage() throws InterruptedException {
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

    public void toggleNthCheckBx(int n) {
        WebElement checkBx = page.getNthCheckBx(n);
        checkBx.click();
    }

    public boolean isCheckBxChecked(int n){
        WebElement checkBx = page.getNthCheckBx(n);
        return checkBx.isSelected();
    }

//    public void deleteNthTodo(int n){
//        WebElement deleteBtn = page.getNthDeleteBtn(n);
//        deleteBtn.click();
//    }

    public void closePage(){
        page.getDrv().close();
        page.getDrv().quit();
    }
}
