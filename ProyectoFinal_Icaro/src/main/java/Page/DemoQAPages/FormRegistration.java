package Page.DemoQAPages;

import Page.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FormRegistration extends BasePage {

    private By logoFile = By.cssSelector("img[src*='Toolsqa.jpg']");
    private By text = By.xpath("//h1[text()='Practice Form']");
    private By firstNameField = By.id("firstName");
    private By lastNameField = By.id("lastName");
    private By emailField = By.xpath("//input[@id='userEmail']");
    private By genderRadioMale = By.cssSelector("label[for='gender-radio-1']");
    private By genderRadioFemale = By.cssSelector("label[for='gender-radio-2']");
    private By genderRadioOther = By.cssSelector("label[for='gender-radio-3']");
    private By phoneNumberField = By.id("userNumber");
    private By birthDayCalendar = By.id("dateOfBirthInput");
    private By subjectField = By.xpath("//div[@id='subjectsContainer']//input");
    private By hobbiesReadingCheckbox = By.cssSelector("label.custom-control-label[for^='hobbies-checkbox-2']");
    private By hobbiesMusicCheckbox = By.cssSelector("label.custom-control-label[for^='hobbies-checkbox-3']");;
    private By pictureSelectButton = By.id("uploadPicture");
    private By addressPlaceHolder = By.id("currentAddress");
    private By stateDropdown = By.id("state");
    private By cityDropdown = By.id("city");
    private By submitButton = By.id("submit");
    private By modalTitle = By.id("example-modal-sizes-title-lg");
    private By closeButton = By.id("closeLargeModal");

    public FormRegistration(WebDriver driver) {
        super(driver);
    }

    public boolean isPageLoaded() {
        return isVisible(logoFile);
    }

    public String findText(){
        return driver.findElement(text).getText();
    }

    public void enviarNombre(String nombre) {
        sendKeys(firstNameField, nombre);
    }

    public void enviarApellido(String apellido){
        sendKeys(lastNameField, apellido);
    }


    public void enviarMail(String mail) {
        sendKeys(emailField, mail);
    }


    public void chooseGender(String gender) {
        scrollToElement(phoneNumberField);
        if(gender.equals("Male")){
            selectButtonRadio(genderRadioMale);
        }
        else if (gender.equals("Female")){
            selectButton(genderRadioFemale);
        }
        else {selectButton(genderRadioOther);}
    }

    public void enviarTeleno(String phone) {
        sendKeys(phoneNumberField, phone);
    }

    public String textGenerator(){
        return com.thedeanda.lorem.LoremIpsum.getInstance().getParagraphs(1,1);
    }

    public void generateText() {
        String parrafo = textGenerator();
        sendKeys(subjectField, parrafo);

    }

    public void selectHobbie() {
        scrollToElement(subjectField);
        selectButton(hobbiesReadingCheckbox);
        selectButton(hobbiesMusicCheckbox);
    }

    public void uploadPhoto(String filePath) {
        Path path = Paths.get(filePath).toAbsolutePath();
        String absolutePath = path.toString();

        if (!path.toFile().exists()) {
            throw new IllegalArgumentException("El archivo no existe: " + absolutePath);
        }
        sendFile(pictureSelectButton, absolutePath);
    }

    public void enviarNacimiento(String dateOfBirth) {
        setDateBirthday(birthDayCalendar, dateOfBirth);
    }

    public void generateAdress() {
        String parrafo = textGenerator();
        sendKeys(addressPlaceHolder, parrafo);
    }

    public void listState() {
        clickDropdown(stateDropdown);
    }

    public void listCity() {
        clickDropdownCity(cityDropdown);
    }

    public void clickSubmit() {
        click(submitButton);
    }

    public void visualizeResume() {
        expectModal(modalTitle);
        boolean displayed = isModalDisplayed(modalTitle);
        if (displayed){
            closeModalSafely(closeButton);
        }
        else {
            System.out.println("No se levantó el modal de Resumen");
        }
    }
}
