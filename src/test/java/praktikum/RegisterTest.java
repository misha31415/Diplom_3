package praktikum;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import praktikum.steps.LoginSteps;
import praktikum.steps.RegisterSteps;

import java.time.Duration;

public class RegisterTest extends BaseTest{
    private RegisterSteps registerSteps;
    private LoginSteps loginSteps;

    @Test
    @DisplayName("Успешная регистрация пользователя")
    @Description("Проверка успешной регистрации нового пользователя")
    public void successfulRegistrationTest() {
        registerSteps = new RegisterSteps(driver);
        registerSteps.openRegisterPage();

        registerSteps.registerUser(name, email, password);

        assertTrueWithMessage("Пользователь должен быть перенаправлен на страницу входа",
                registerSteps.isLoginPageOpened());
    }

    @Test
    @DisplayName("Ошибка при регистрации с паролем менее 6 символов")
    @Description("Проверка ошибки при регистрации с коротким паролем")
    public void registrationWithShortPasswordTest() {
        registerSteps = new RegisterSteps(driver);
        registerSteps.openRegisterPage();

        String shortPassword = "12345";
        registerSteps.registerUser(name, email, shortPassword);

        assertTrueWithMessage("Должна отображаться ошибка 'Некорректный пароль'",
                registerSteps.isPasswordErrorDisplayed());
    }
}
