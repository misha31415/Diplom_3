package praktikum.steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import praktikum.pages.MainPage;

public class MainSteps extends BaseSteps{
    private MainPage mainPage;

    public MainSteps(WebDriver driver) {
        super(driver);
        this.mainPage = new MainPage(driver);
    }

    @Step("Открыть главную страницу")
    public void openMainPage() {
        mainPage.openMainPage();
    }

    @Step("Нажать кнопку 'Войти в аккаунт'")
    public void clickLoginButton() {
        mainPage.clickLoginButton();
    }

    @Step("Нажать кнопку 'Личный кабинет'")
    public void clickProfileButton() {
        mainPage.clickProfileButton();
    }

    @Step("Нажать на раздел 'Булки'")
    public void clickBunsTab() {
        mainPage.clickBunsTab();
    }

    @Step("Нажать на раздел 'Соусы'")
    public void clickSaucesTab() {
        mainPage.clickSaucesTab();
    }

    @Step("Нажать на раздел 'Начинки'")
    public void clickFillingsTab() {
        mainPage.clickFillingsTab();
    }

    @Step("Проверить, что раздел 'Булки' виден")
    public boolean isBunsSectionVisible() {
        return mainPage.isBunsSectionVisible();
    }

    @Step("Проверить, что раздел 'Соусы' виден")
    public boolean isSaucesSectionVisible() {
        return mainPage.isSaucesSectionVisible();
    }

    @Step("Проверить, что раздел 'Начинки' виден")
    public boolean isFillingsSectionVisible() {
        return mainPage.isFillingsSectionVisible();
    }

    @Step("Проверить, что отображается конструктор")
    public boolean isConstructorDisplayed() {
        return mainPage.isConstructorDisplayed();
    }
}
