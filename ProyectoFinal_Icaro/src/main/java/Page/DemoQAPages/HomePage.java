package Page.DemoQAPages;

import Page.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {
    private By logoFile = By.cssSelector("img[src*='Toolsqa.jpg']");
    private By formsButton = By.xpath("//h5[text()='Forms']/ancestor::div[contains(@class, 'card')]");
    private final By pageBannerLocator = By.className("banner-image");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public boolean isLogoDisplayed() {
        return isVisible(logoFile);
    }

    public String getLogoAltText() {
        return driver.findElement(logoFile).getAttribute("alt");
    }

    public boolean isPageLoaded() {
        return isVisible(pageBannerLocator) && isVisible(logoFile);
    }

    public void navigateToFormsSection() {
        click(formsButton);
    }
}