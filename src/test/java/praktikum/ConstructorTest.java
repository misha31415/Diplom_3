package praktikum;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import praktikum.steps.MainSteps;

public class ConstructorTest extends BaseTest{
    private MainSteps mainSteps;

    @Before
    public void setUpConstructorTest() {
        mainSteps = new MainSteps(driver);
        mainSteps.openMainPage();
    }

    @Test
    @DisplayName("Переход к разделу 'Булки'")
    @Description("Проверка перехода к разделу 'Булки' в конструкторе")
    public void switchToBunsTabTest() {
        mainSteps.clickSaucesTab();
        mainSteps.clickBunsTab();

        assertTrueWithMessage("Раздел 'Булки' должен быть виден",
                mainSteps.isBunsSectionVisible());
    }

    @Test
    @DisplayName("Переход к разделу 'Соусы'")
    @Description("Проверка перехода к разделу 'Соусы' в конструкторе")
    public void switchToSaucesTabTest() {
        mainSteps.clickSaucesTab();

        assertTrueWithMessage("Раздел 'Соусы' должен быть виден",
                mainSteps.isSaucesSectionVisible());
    }

    @Test
    @DisplayName("Переход к разделу 'Начинки'")
    @Description("Проверка перехода к разделу 'Начинки' в конструкторе")
    public void switchToFillingsTabTest() {
        mainSteps.clickFillingsTab();

        assertTrueWithMessage("Раздел 'Начинки' должен быть виден",
                mainSteps.isFillingsSectionVisible());
    }
}
