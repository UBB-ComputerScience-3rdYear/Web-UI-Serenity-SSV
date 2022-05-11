package ssvv.steps.serenity;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import ssvv.pages.EmagPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class EmagEndUserSteps {

    EmagPage emagPage;

    @Step
    public void enters(String keyword) {
        emagPage.enter_keywords(keyword);
    }

    @Step
    public void starts_search() {
        emagPage.lookup_terms();
    }

    @Step
    public void should_see_result(String resultText) {
        assertThat(emagPage.getResultText(), containsString(resultText));
    }

    @Step
    public void should_not_see_result(String invalidResultText) {
        assertThat(emagPage.getResultText(), not(containsString(invalidResultText)));
    }

    @Step
    public void is_the_home_page() {
        emagPage.open();
    }

    @Step
    public void looks_for(String term) {
        enters(term);
        starts_search();
    }

    public void clicks_product() {
        emagPage.click_product();
    }

    public void clicks_add_to_basket() {
        emagPage.click_add_to_basket();
    }

    public void should_see_resultAdded(String resultText, WebDriver webDriver) {
        assertThat(emagPage.getProductAddedText(webDriver), containsString(resultText));
    }

    public void should_not_see_resultAdded(String invalidResultText, WebDriver webDriver) {
        assertThat(emagPage.getProductAddedText(webDriver), not(containsString(invalidResultText)));
    }
}