package praktikum.steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import praktikum.pages.RegisterPage;

public class RegisterSteps extends BaseSteps{
    private RegisterPage registerPage;

    public RegisterSteps(WebDriver driver) {
        super(driver);
        this.registerPage = new RegisterPage(driver);
    }

    @Step("Открыть страницу регистрации")
    public void openRegisterPage() {
        driver.get("https://stellarburgers.education-services.ru/register");
    }

    @Step("Нажать кнопку 'Зарегистрироваться'")
    public void clickRegisterButton() {
        registerPage.clickRegisterButton();
    }

    @Step("Зарегистрировать пользователя: имя={name}, email={email}, пароль={password}")
    public void registerUser(String name, String email, String password) {
        registerPage.register(name, email, password);
    }

    @Step("Проверить отображение ошибки 'Некорректный пароль'")
    public boolean isPasswordErrorDisplayed() {
        return registerPage.isPasswordErrorDisplayed();
    }

    @Step("Нажать ссылку 'Войти'")
    public void clickLoginLink() {
        registerPage.clickLoginLink();
    }

    @Step("Проверить, что произошёл переход на страницу входа")
    public boolean isLoginPageOpened() {
        return registerPage.waitForUrlContains("login");
    }
}
