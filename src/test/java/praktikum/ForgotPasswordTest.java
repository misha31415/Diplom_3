package praktikum;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import praktikum.steps.ForgotPasswordSteps;
import praktikum.utils.StringRandomUtils;
import java.time.Duration;


public class ForgotPasswordTest extends BaseTest{
    private ForgotPasswordSteps forgotPasswordSteps;

    @Test
    @DisplayName("Переход на страницу восстановления пароля")
    @Description("Проверка открытия страницы восстановления пароля")
    public void openForgotPasswordPageTest() {
        forgotPasswordSteps = new ForgotPasswordSteps(driver);
        forgotPasswordSteps.openForgotPasswordPage();

        assertTrueWithMessage("Страница восстановления должна открыться",
                forgotPasswordSteps.isRestoreButtonDisplayed());
    }

    @Test
    @DisplayName("Отправка формы восстановления с валидным email")
    @Description("Проверка отправки запроса на восстановление пароля")
    public void restorePasswordWithValidEmailTest() {
        forgotPasswordSteps = new ForgotPasswordSteps(driver);
        forgotPasswordSteps.openForgotPasswordPage();

        String email = StringRandomUtils.getRandomEmail();
        forgotPasswordSteps.enterEmail(email);
        forgotPasswordSteps.clickRestoreButton();

        assertTrueWithMessage("Должен быть переход на страницу сброса пароля",
                forgotPasswordSteps.isResetPasswordPageOpened());
    }

    @Test
    @DisplayName("Переход на страницу входа по ссылке 'Войти'")
    @Description("Проверка перехода на страницу входа из формы восстановления")
    public void clickLoginLinkOnForgotPasswordPageTest() {
        forgotPasswordSteps = new ForgotPasswordSteps(driver);
        forgotPasswordSteps.openForgotPasswordPage();

        forgotPasswordSteps.clickLoginLink();

        assertTrueWithMessage("Должен быть переход на страницу входа",
                forgotPasswordSteps.isLoginPageOpened());
    }
}
