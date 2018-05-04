package com.eb.sample.tests;

import static org.junit.Assert.assertEquals;
import com.eb.sample.actions.ToDoActions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AppTest
{
    static ToDoActions actions;

    @BeforeClass
    public static void setup() throws InterruptedException {
        actions = new ToDoActions();
        actions.loadPage();
    }

    @AfterClass
    public static void tearDown(){
        actions.closePage();
    }



    @Test
    public void test01checkPlaceHolder() throws InterruptedException {
        String placeHolder = actions.getPlaceHolderText();
        assertEquals("Place holder value not as expected", "What needs to be done?", placeHolder);
        System.out.println(placeHolder);
    }

    @Test
    public void test02addASingleTodo() throws InterruptedException {
        String str = "Get almonds";
        actions.createTask(str);
        String txt = actions.getFirstTodoText();
        assertEquals("The todo item text is not as entered", str, txt);
    }
    
    @Test
    public void test03addMultipleTodos() throws InterruptedException {
        String str01 = "Get bananas";
        actions.createTask(str01);
        String txt01 = actions.getNthTodoText(2);
        String str02 = "Get coffee";
        actions.createTask(str02);
        String txt02 = actions.getNthTodoText(3);
        String str03 = "Get detergents";
        actions.createTask(str03);
        String txt03 = actions.getNthTodoText(4);
        assertEquals("The 1st todo item text is not as entered", str01, txt01);
        assertEquals("The 1st todo item text is not as entered", str02, txt02);
        assertEquals("The 1st todo item text is not as entered", str03, txt03);
    }

    @Test
    public void test04addSpecialTextTodos() throws InterruptedException {
        actions.createTask("לקנות אוכל");
        actions.createTask("1234");
        actions.createTask("@#$%");
        actions.createTask("    ");
        actions.createTask("אחרון");
    }

}