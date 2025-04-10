package Page.DemoQAPages;

import Page.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    private String title;
    private String logoFile;
    private String IdBtn;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public String getTitle() {
        String title = driver.getTitle();
        return title;
    }

    public String getLogoFile() {

        return logoFile;
    }

    public String getIdBtn() {
        return IdBtn;
    }
}
