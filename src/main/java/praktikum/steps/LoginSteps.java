package praktikum.steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import praktikum.pages.LoginPage;


public class LoginSteps extends BaseSteps {
    private LoginPage loginPage;

    public LoginSteps(WebDriver driver) {
        super(driver);
        this.loginPage = new LoginPage(driver);
    }

    @Step("Ввести email: {email}")
    public void enterEmail(String email) {
        loginPage.enterEmail(email);
    }

    @Step("Ввести пароль")
    public void enterPassword(String password) {
        loginPage.enterPassword(password);
    }

    @Step("Нажать кнопку 'Войти'")
    public void clickLoginButton() {
        loginPage.clickLoginButton();
    }

    @Step("Выполнить вход с email: {email}")
    public void login(String email, String password) {
        loginPage.login(email, password);
    }

    @Step("Нажать ссылку 'Зарегистрироваться'")
    public void clickRegisterLink() {
        loginPage.clickRegisterLink();
    }

    @Step("Проверить, что главная страница открыта")
    public boolean isMainPageOpened() {
        return loginPage.waitForUrlContains("/");
    }
}
