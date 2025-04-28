package com.qapractice.stepdefinitions;

import Page.DemoQAPages.FormPage;
import Page.DemoQAPages.FormRegistration;
import Page.DemoQAPages.HomePage;
import io.cucumber.java.Before;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.time.Duration;


public class Steps {
    private WebDriver driver;
    private HomePage homePage;
    private FormPage formPage;
    private FormRegistration formRegistration;
    private static final String DEMOQA_URL = "https://demoqa.com/";
    private static final String EXPECTED_TITLE = "DEMOQA";
    private static final String DEMOQA_URL_FORM = "https://demoqa.com/forms";
    private static final String FORM_URL = "https://demoqa.com/automation-practice-form";
    private static final String FORM_URL_TEXT = "Practice Form";

    @Before
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        System.setProperty("webdriver.chrome.driver",
                System.getProperty("user.dir") + "/src/main/driver/chromedriver");

        options.addArguments(
                "--start-maximized",
                "--incognito",
                "--disable-extensions",
                "--disable-popup-blocking",
                "--disable-notifications",
                "--lang=es"
        );

        options.setImplicitWaitTimeout(Duration.ofSeconds(10));
        options.setPageLoadTimeout(Duration.ofSeconds(60));

        driver = new ChromeDriver(options);
    }
    @Given("usuario se encuentra en el HomePage de DEMOQA")
    public void usuarioEnElHome(){

        driver.get(DEMOQA_URL);
        this.homePage = new HomePage(driver);
        Assert.assertTrue("La página principal no se cargó correctamente", homePage.isPageLoaded());
    }

    @When("usuario visualiza el titulo")
    public void usuarioVisualizaElTitulo() {
        String titleFromWeb = this.homePage.getTitle();
        Assert.assertEquals("Title mismatch. Expected title " + EXPECTED_TITLE + ". Title recevied: " +
                titleFromWeb, EXPECTED_TITLE, titleFromWeb);
    }

    @Then("visualiza logo")
    public void visualizaLogo() {
        Assert.assertTrue("El logo no está visible en la página", homePage.isLogoDisplayed());
    }

    @And("hace click en Forms")
    public void haceClickEnForms() {
        homePage.navigateToFormsSection();

    }

    @When("usuario esta en la pagina del Form")
    public void usuarioEstaEnLaPaginaDelForm() {
        driver.get(DEMOQA_URL_FORM);
        this.formPage = new FormPage(driver);
        Assert.assertTrue("La página principal no se cargó correctamente", formPage.isPageLoaded());

    }

    @Then("debe hacer click en Practice Form")
    public void debeHacerClickEnPracticeForm() {
        this.formPage.clickInForm();
    }

    @And("ver el titulo Practice Form")
    public void verElTituloPracticeForm() {
        this.formPage.viewTitle();
    }

    @When("usuario visualiza el titulo del formulario")
    public void usuarioVisualizaElTituloDelFormulario() {
        driver.get(FORM_URL);
        this.formRegistration = new FormRegistration(driver);
        Assert.assertTrue("La página principal no se cargó correctamente", formRegistration.isPageLoaded());
        String text = formRegistration.findText();
        Assert.assertEquals("Title mismatch. Expected title " + FORM_URL_TEXT + ". Title recevied: " +
                text, FORM_URL_TEXT, text);
    }


    @Then("ingresa Nombre {string}")
    public void ingresaNombre(String nombre) {
        this.formRegistration.enviarNombre(nombre);

    }

    @And("ingresa Apellido {string}")
    public void ingresaApellido(String apellido) {
        this.formRegistration.enviarApellido(apellido);
    }

    @And("ingresa Email {string}")
    public void ingresaEmail(String mail) {
        this.formRegistration.enviarMail(mail);
    }

    @And("selecciona genero {string}")
    public void seleccionaGenero(String gender) {
        this.formRegistration.chooseGender(gender);
    }

    @And("ingresa nro de telefono {string}")
    public void ingresaNroDeTelefono(String phone) {
        this.formRegistration.enviarTeleno(phone);
    }

    @And("elige una fecha de nacimiento {string}")
    public void eligeUnaFechaDeNacimiento(String dateOfBirth) {
        this.formRegistration.enviarNacimiento(dateOfBirth);
    }


    @And("ingresa un texto largo")
    public void ingresaUnTextoLargo() {
        this.formRegistration.generateText();
    }

    @And("elige un Hobbie")
    public void eligeUnHobbie() {
        this.formRegistration.selectHobbie();
    }

    @And("hace click en el boton para cargar una foto")
    public void haceClickEnElBotonParaCargarUnaFoto() {
        String filePath = "src/test/filesToUpload/testImage.png";
        this.formRegistration.uploadPhoto(filePath);
    }

    @And("completa su direccion actual")
    public void completaSuDireccionActual() {
        this.formRegistration.generateAdress();
    }

    @And("selecciona un estado")
    public void seleccionaUnEstado() {
        this.formRegistration.listState();

    }

    @And("selecciona una ciudad")
    public void seleccionaUnaCiudad() {
        this.formRegistration.listCity();
    }

    @And("hace click en el boton Submit")
    public void haceClickEnElBotonSubmit() {
        this.formRegistration.clickSubmit();
    }

    @Then("visualiza un mensaje")
    public void visualizaUnMensaje() {
        this.formRegistration.visualizeResume();
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
