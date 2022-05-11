package ssvv.features.search;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.annotations.Qualifier;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ssvv.steps.serenity.EmagEndUserSteps;

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom("src/test/resources/EmagAddTestData.csv")
public class EmagAddToBasketDdt {

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @ManagedPages(defaultUrl = "https://www.emag.ro")
    public Pages pages;

    public String name;
    public String resultText;

    public String invalidResultText;


    @Qualifier
    public String getQualifier() {
        return name;
    }

    @Steps
    public EmagEndUserSteps endUser;

    @Issue("#EMAG-1")
    @Test
    public void addEmagTestDDT() {
        endUser.is_the_home_page();
        endUser.looks_for(getName());
        endUser.clicks_product();
        webdriver.findElement(By.className("main-button")).click();
//        endUser.clicks_add_to_basket();
//        webdriver.getWindowHandle()
//        webdriver.switchTo().activeElement();
        final String mainWindowHandle = webdriver.getWindowHandle();
        for (String activeHandle : webdriver.getWindowHandles()) {
            if (!activeHandle.equals(mainWindowHandle)) {
                webdriver.switchTo().window(activeHandle);
            }
        }

        endUser.should_see_resultAdded(getResultText(),webdriver);
        endUser.should_not_see_resultAdded(getInvalidResultText(),webdriver);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getResultText() {
        return resultText;
    }

    public void setResultText(String resultText) {
        this.resultText = resultText;
    }

    public String getInvalidResultText() {
        return invalidResultText;
    }

    public void setInvalidResultText(String invalidResultText) {
        this.invalidResultText = invalidResultText;
    }

}
