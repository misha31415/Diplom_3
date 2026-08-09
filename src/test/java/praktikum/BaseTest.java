package praktikum;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.WebDriver;
import praktikum.api.UserApiClient;
import praktikum.api.models.UserRequest;
import praktikum.api.models.UserResponse;
import praktikum.config.DriverFactory;
import praktikum.utils.StringRandomUtils;

import static org.junit.Assert.assertTrue;

public abstract class BaseTest {
    protected WebDriver driver;
    protected UserApiClient userApiClient;
    protected String accessToken;
    protected String name;
    protected String email;
    protected String password;

    @Rule
    public TestName testName = new TestName();

    @Before
    public void setUp() {
        String browser = System.getProperty("browser", "chrome");
        driver = DriverFactory.getDriver(browser);

        userApiClient = new UserApiClient();

        name = StringRandomUtils.getRandomName();
        email = StringRandomUtils.getRandomEmail();
        password = StringRandomUtils.getRandomPassword();
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
        if (accessToken != null && !accessToken.isEmpty()) {
            userApiClient.deleteUser(accessToken);
        }
    }

    protected void createUserViaApi() {
        UserRequest userRequest = new UserRequest(email, password, name);
        var response = userApiClient.createUser(userRequest);
        response.statusCode(200);
        accessToken = response.extract().as(UserResponse.class).getAccessToken();
    }

    protected void assertTrueWithMessage(String message, boolean condition) {
        assertTrue(message, condition);
    }
}
