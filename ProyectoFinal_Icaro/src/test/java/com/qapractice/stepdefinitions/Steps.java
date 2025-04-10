package com.qapractice.stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import static org.junit.Assert.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Steps {
    private WebDriver driver;

    @Given("usuario se encuentra en el HomePage de DEMOQA")
    public void usuarioEnElHome(){

        ChromeOptions options = new ChromeOptions();
        String pathChromeDriver = System.getProperty("user.dir") + "src/main/driver/chromedriver";
        System.setProperty("webdriver.chrome.diver", pathChromeDriver);

        //Configuraciones iniciales de Chrome
        options.addArguments("start-maximized");
        options.addArguments("incognito");
        options.setPageLoadTimeout(Duration.ofSeconds(60));

        //Inicialización del Driver
        driver = new ChromeDriver(options);
        driver.get("https://demoqa.com/");
    }

    @When("usuario visualiza el titulo")
    public void usuarioVisualizaElTitulo() {
        String titleFromWeb = driver.getTitle();
        String expetedTitle = "DEMOQA";
        assertEquals(titleFromWeb, expetedTitle,
                "Title mismatch. Expected title " + expetedTitle + ". Title recevied: " + titleFromWeb);
    }

    @Then("visualiza logo")
    public void visualizaLogo() {
        "Toolsqa.jpg"
    }
}
