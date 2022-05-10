package ssvv.steps.serenity;

import net.thucydides.core.annotations.Step;
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
}