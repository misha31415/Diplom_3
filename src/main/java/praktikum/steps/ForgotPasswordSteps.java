package praktikum.steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import praktikum.pages.ForgotPasswordPage;

public class ForgotPasswordSteps extends BaseSteps{
    private ForgotPasswordPage forgotPasswordPage;

    public ForgotPasswordSteps(WebDriver driver) {
        super(driver);
        this.forgotPasswordPage = new ForgotPasswordPage(driver);
    }

    @Step("Открыть страницу восстановления пароля")
    public void openForgotPasswordPage() {
        driver.get("https://stellarburgers.education-services.ru/forgot-password");
    }

    @Step("Ввести email: {email}")
    public void enterEmail(String email) {
        forgotPasswordPage.enterEmail(email);
    }

    @Step("Нажать кнопку 'Восстановить'")
    public void clickRestoreButton() {
        forgotPasswordPage.clickRestoreButton();
    }

    @Step("Нажать ссылку 'Войти'")
    public void clickLoginLink() {
        forgotPasswordPage.clickLoginLink();
    }

    @Step("Проверить, что страница восстановления открыта")
    public boolean isRestoreButtonDisplayed() {
        return forgotPasswordPage.isRestoreButtonDisplayed();
    }

    @Step("Проверить, что произошёл переход на страницу сброса пароля")
    public boolean isResetPasswordPageOpened() {
        return forgotPasswordPage.waitForUrlContains("reset-password");
    }

    @Step("Проверить, что произошёл переход на страницу входа")
    public boolean isLoginPageOpened() {
        return forgotPasswordPage.waitForUrlContains("login");
    }
}
