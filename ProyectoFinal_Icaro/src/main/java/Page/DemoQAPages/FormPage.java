package Page.DemoQAPages;

import Page.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.stream.Collectors;

public class FormPage extends BasePage {

    private By logoFile = By.cssSelector("img[src*='Toolsqa.jpg']");
    private By selectFromLeft = By.xpath(".//div[@id='app']//div[contains(@class, 'content')]//div[2]");
    private By clickForm = By.xpath("//span[contains(text(),'Practice Form')]");
    private By title = By.xpath("//h1[text()='Practice Form']");

    public FormPage(WebDriver driver) {
        super(driver);
    }

    public boolean isPageLoaded() {
        return isVisible(logoFile);
    }

    public void clickInForm(){
        elementoClick(clickForm);
    }

    public void viewTitle(){
        validationTitle(title);
    }

}
