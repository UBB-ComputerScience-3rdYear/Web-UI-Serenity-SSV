package ssvv.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.xml.datatype.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@DefaultUrl("https://www.emag.ro")
public class EmagPage extends PageObject {


    @FindBy(name = "query")
    private WebElementFacade searchTerms;

    @FindBy(xpath = "//*[@id=\"masthead\"]/div/div/div[2]/div/form/div[1]/div[2]/button[2]/i")
    private WebElementFacade lookupButton;

    @FindBy(xpath = "/html/body/div[3]/div[2]/div/section[1]/div/div[3]/div[2]/div[5]/div[1]/div/div/div[3]/a")
    private WebElementFacade product;

    @FindBy(xpath = "/html/body/div[3]/div[2]/div/section[1]/div/div[2]/div[2]/div/div[2]/div[2]/form/div/div[2]/div[2]/div[1]")
    private WebElementFacade addButton;


    public void enter_keywords(String keyword) {
        searchTerms.type(keyword);
    }

    public void lookup_terms() {
        lookupButton.click();
    }

    public void click_product() {product.click();}

    public void click_add_to_basket() {
        addButton.click();
    }

    public String getResultText() {
        WebElementFacade results = find(By.xpath("/html/body/div[3]/div[2]/div/section[1]/div/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[2]/a/div/div[2]/div"));
        return results.getText();
    }

    public String getProductAddedText(WebDriver webDriver) {
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//        }
//        WebDriverWait wait = new WebDriverWait(webDriver, new Duration(10, TimeUnit.SECONDS))
        WebElementFacade productText = find(By.xpath("/html/body/div[11]/div/div/div[1]/h4"));
//        WebElementFacade productText = find(By.className("class=\"mrg-sep-none\""));
        return productText.getText();
    }

}