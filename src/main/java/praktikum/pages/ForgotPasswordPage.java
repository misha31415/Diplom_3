package praktikum.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ForgotPasswordPage extends BasePage{
    @FindBy(xpath = "//label[text()='Email']/following-sibling::input")
    private WebElement emailInput;

    @FindBy(xpath = "//button[text()='Восстановить']")
    private WebElement restoreButton;

    @FindBy(xpath = "//a[text()='Войти']")
    private WebElement loginLink;

    public ForgotPasswordPage(WebDriver driver) {
        super(driver);
    }

    public void enterEmail(String email) {
        waitForElementVisible(emailInput);
        emailInput.sendKeys(email);
    }

    public void clickRestoreButton() {
        click(restoreButton);
    }

    public void clickLoginLink() {
        click(loginLink);
    }

    public boolean isRestoreButtonDisplayed() {
        waitForElementVisible(restoreButton);
        return restoreButton.isDisplayed();
    }
}
