package com.eb.sample.gui.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.eb.sample.gui.actions.ToDoActions;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@DisplayName("GUITest")
public class GUITest
{

    static ToDoActions actions;

    @BeforeClass
    public static void setup() throws InterruptedException {
        System.setProperty("javax.xml.bind.JAXBContextFactory", "org.eclipse.persistence.jaxb.JAXBContextFactory");
        actions = new ToDoActions();
        actions.loadPage();
    }

    @AfterClass
    public static void tearDown(){
        actions.closePage();
    }


    @Step
    @Feature("Some feature")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void test01checkPlaceHolder() throws InterruptedException {
        String placeHolder = actions.getPlaceHolderText();
        assertEquals("Place holder value not as expected", "What needs to be done?", placeHolder);
        System.out.println(placeHolder);
    }

    @Step
    @Feature("Some feature")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void test02addASingleTodo() throws InterruptedException {
        String str = "Get almonds";
        actions.createTask(str);
        String txt = actions.getFirstTodoText();
        assertEquals("The todo item text is not as entered", str, txt);
    }

    @Step
    @Feature("Some feature")
    @Severity(SeverityLevel.CRITICAL)
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
        assertEquals("The 2nd todo item text is not as entered", str01, txt01);
        assertEquals("The 3rd todo item text is not as entered", str02, txt02);
        assertEquals("The 4th todo item text is not as entered", str03, txt03);
    }

    @Step
    @Feature("Some feature")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void test04addSpecialTextTodos() throws InterruptedException {
        actions.createTask("לקנות אוכל");
        actions.createTask("1234");
        actions.createTask("@#$%");
        actions.createTask("    ");
        actions.createTask("אחרון");
    }

    @Step
    @Feature("Some feature")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void test05toggleCheckBox() throws InterruptedException {
        actions.toggleNthCheckBx(4);
        boolean checked = actions.isCheckBxChecked(4);
        assertTrue("Checkbox 4 is supposed to be cheked", checked);
        actions.toggleNthCheckBx(4);
        checked = actions.isCheckBxChecked(4);
        assertFalse("Checkbox 4 is supposed to be uncheked", checked);
//        actions.deleteNthTodo(4);
    }

}
