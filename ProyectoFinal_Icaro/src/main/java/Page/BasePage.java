package Page;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        PageFactory.initElements(driver, this);

    }

    public void clickDropdown(By locator){
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

        // Obtener todas las opciones
        List<WebElement> stateOptions = driver.findElements(
                By.cssSelector("#state div[class$='-option']"));

        if (!stateOptions.isEmpty()) {
            int randomIndex = ThreadLocalRandom.current().nextInt(stateOptions.size());
            WebElement randomState = stateOptions.get(randomIndex);
            randomState.click();
        }

    }

    protected void elementoClick (By locator){
        WebElement practiceFormItem = wait.until(ExpectedConditions.elementToBeClickable(locator));
        practiceFormItem.click();
    }

    protected void validationTitle(By locator){
        WebElement title = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

        Assert.assertTrue("El título 'Practice Form' no es visible",
                title.isDisplayed());
    }

    public void clickDropdownCity(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

        // Obtener todas las opciones
        List<WebElement> cityOptions = driver.findElements(
                By.cssSelector("#city div[class$='-option']"));

        if (!cityOptions.isEmpty()) {
            int randomIndex = ThreadLocalRandom.current().nextInt(cityOptions.size());
            WebElement randomState = cityOptions.get(randomIndex);
            randomState.click();
        }
    }

    protected void sendKeys(By locator, String text){
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        element.clear();
        element.sendKeys(text);
    }

    protected void selectButton(By locator){
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        element.click();
    }

    protected void selectButtonRadio(By locator){
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();", element);
    }


    protected void setDateBirthday(By locator, String date){
        WebElement dateInput = driver.findElement(locator);
        ((JavascriptExecutor)driver).executeScript(
                "arguments[0].value = arguments[1];", dateInput, date);

        ((JavascriptExecutor)driver).executeScript(
                "arguments[0].dispatchEvent(new Event('change'));", dateInput);
    }

    protected void sendFile(By locator, String absolutePath){
        WebElement fileInput = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        fileInput.sendKeys(absolutePath);
    }

    protected boolean isVisible(By locator) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    protected String getText(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).getText();
    }

    protected boolean isClickable(By locator) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(locator));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void scrollToElement(By locator) {
        WebElement element = driver.findElement(locator);
        ((JavascriptExecutor)driver).executeScript(
                "arguments[0].scrollIntoView(true);",
                element);

        try { Thread.sleep(300); } catch (InterruptedException e) {}
    }

    protected void click(By locator){
        WebElement element = driver.findElement(locator);
        element.click();
    }

    protected void expectModal(By locator){
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public boolean isModalDisplayed(By locator) {
        try {
            return driver.findElement(locator).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void closeModalSafely(By locator){
        WebElement closeButton = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();", closeButton);
    }
}
