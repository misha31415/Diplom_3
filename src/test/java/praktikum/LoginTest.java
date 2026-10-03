package praktikum;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import praktikum.steps.ForgotPasswordSteps;
import praktikum.steps.LoginSteps;
import praktikum.steps.MainSteps;
import praktikum.steps.RegisterSteps;

public class LoginTest extends BaseTest {

    private MainSteps mainSteps;
    private LoginSteps loginSteps;
    private RegisterSteps registerSteps;
    private ForgotPasswordSteps forgotPasswordSteps;

    @Before
    public void setUpLoginTest() {
        createUserViaApi();

        mainSteps = new MainSteps(driver);
        loginSteps = new LoginSteps(driver);
        registerSteps = new RegisterSteps(driver);
        forgotPasswordSteps = new ForgotPasswordSteps(driver);
    }

    @Test
    @DisplayName("Вход по кнопке «Войти в аккаунт» на главной")
    @Description("Проверка входа через кнопку на главной странице")
    public void loginByMainButtonTest() {
        mainSteps.openMainPage();
        mainSteps.clickLoginButton();

        loginSteps.login(email, password);

        assertTrueWithMessage("После входа должна отображаться главная страница",
                mainSteps.isConstructorDisplayed());
    }

    @Test
    @DisplayName("Вход через кнопку «Личный кабинет»")
    @Description("Проверка входа через кнопку 'Личный кабинет' в шапке")
    public void loginByProfileButtonTest() {
        mainSteps.openMainPage();
        mainSteps.clickProfileButton();

        loginSteps.login(email, password);

        assertTrueWithMessage("После входа должна отображаться главная страница",
                mainSteps.isConstructorDisplayed());
    }

    @Test
    @DisplayName("Вход через кнопку в форме регистрации")
    @Description("Проверка входа через ссылку 'Войти' на странице регистрации")
    public void loginByRegisterLinkTest() {
        registerSteps.openRegisterPage();
        registerSteps.clickLoginLink();

        loginSteps.login(email, password);

        assertTrueWithMessage("После входа должна отображаться главная страница",
                mainSteps.isConstructorDisplayed());
    }

    @Test
    @DisplayName("Вход через кнопку в форме восстановления пароля")
    @Description("Проверка перехода на страницу входа по ссылке 'Войти'")
    public void loginByForgotPasswordLinkTest() {
        forgotPasswordSteps.openForgotPasswordPage();
        forgotPasswordSteps.clickLoginLink();  // ← ИСПРАВЛЕНО!

        loginSteps.login(email, password);

        assertTrueWithMessage("После входа должна отображаться главная страница",
                mainSteps.isConstructorDisplayed());
    }
}
