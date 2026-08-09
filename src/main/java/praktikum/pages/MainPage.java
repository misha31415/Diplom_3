package praktikum.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage{
    @FindBy(xpath = "//button[text()='Войти в аккаунт']")
    private WebElement loginButton;

    @FindBy(xpath = "//p[text()='Личный Кабинет']")
    private WebElement profileButton;

    @FindBy(xpath = "//h1[text()='Соберите бургер']")
    private WebElement constructorHeader;

    @FindBy(xpath = "//span[text()='Булки']/parent::div")
    private WebElement bunsTab;

    @FindBy(xpath = "//span[text()='Соусы']/parent::div")
    private WebElement saucesTab;

    @FindBy(xpath = "//span[text()='Начинки']/parent::div")
    private WebElement fillingsTab;

    @FindBy(xpath = "//h2[text()='Булки']")
    private WebElement bunsSection;

    @FindBy(xpath = "//h2[text()='Соусы']")
    private WebElement saucesSection;

    @FindBy(xpath = "//h2[text()='Начинки']")
    private WebElement fillingsSection;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void clickLoginButton() {
        click(loginButton);
    }

    public void clickProfileButton() {
        click(profileButton);
    }

    public void clickBunsTab() {
        waitForElementClickable(bunsTab);
        bunsTab.click();
    }

    public void clickSaucesTab() {
        waitForElementClickable(saucesTab);
        saucesTab.click();
    }

    public void clickFillingsTab() {
        waitForElementClickable(fillingsTab);
        fillingsTab.click();
    }

    public boolean isBunsTabActive() {
        try {
            waitForElementVisible(bunsTab);
            String classAttr = bunsTab.getAttribute("class");
            return classAttr != null && classAttr.contains("tab_tab_type_current__2BEPc");
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isSaucesTabActive() {
        try {
            waitForElementVisible(saucesTab);
            String classAttr = saucesTab.getAttribute("class");
            return classAttr != null && classAttr.contains("tab_tab_type_current__2BEPc");
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isFillingsTabActive() {
        try {
            waitForElementVisible(fillingsTab);
            String classAttr = fillingsTab.getAttribute("class");
            return classAttr != null && classAttr.contains("tab_tab_type_current__2BEPc");
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isConstructorDisplayed() {
        waitForElementVisible(constructorHeader);
        return constructorHeader.isDisplayed();
    }

    public boolean isBunsSectionVisible() {
        try {
            return bunsSection.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isSaucesSectionVisible() {
        try {
            return saucesSection.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isFillingsSectionVisible() {
        try {
            return fillingsSection.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void waitForBunsTabActive() {
        wait.until(driver -> isBunsTabActive());
    }

    public void waitForSaucesTabActive() {
        wait.until(driver -> isSaucesTabActive());
    }

    public void waitForFillingsTabActive() {
        wait.until(driver -> isFillingsTabActive());
    }

    public void waitForSaucesSectionVisible() {
        wait.until(driver -> isSaucesSectionVisible());
    }

    public void waitForFillingsSectionVisible() {
        wait.until(driver -> isFillingsSectionVisible());
    }

    public void openMainPage() {
        driver.get("https://stellarburgers.education-services.ru/");
    }
}
