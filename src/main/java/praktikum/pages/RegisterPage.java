package praktikum.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends BasePage{
    @FindBy(xpath = "//label[text()='Имя']/following-sibling::input")
    private WebElement nameInput;

    @FindBy(xpath = "//label[text()='Email']/following-sibling::input")
    private WebElement emailInput;

    @FindBy(xpath = "//label[text()='Пароль']/following-sibling::input")
    private WebElement passwordInput;

    @FindBy(xpath = "//button[text()='Зарегистрироваться']")
    private WebElement registerButton;

    @FindBy(xpath = "//p[text()='Некорректный пароль']")
    private WebElement passwordError;

    @FindBy(xpath = "//a[text()='Войти']")
    private WebElement loginLink;

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    public void enterName(String name) {
        waitForElementVisible(nameInput);
        nameInput.sendKeys(name);
    }

    public void enterEmail(String email) {
        waitForElementVisible(emailInput);
        emailInput.sendKeys(email);
    }

    public void enterPassword(String password) {
        waitForElementVisible(passwordInput);
        passwordInput.sendKeys(password);
    }

    public void clickRegisterButton() {
        click(registerButton);
    }

    public void clickLoginLink() {
        click(loginLink);
    }

    public void register(String name, String email, String password) {
        enterName(name);
        enterEmail(email);
        enterPassword(password);
        clickRegisterButton();
    }

    public boolean isPasswordErrorDisplayed() {
        waitForElementVisible(passwordError);
        return passwordError.isDisplayed();
    }
}
