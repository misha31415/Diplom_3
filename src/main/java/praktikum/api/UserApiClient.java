package praktikum.api;

import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;
import praktikum.api.models.UserRequest;

import static io.restassured.RestAssured.given;

public class UserApiClient {
    private static final String BASE_URL = "https://stellarburgers.education-services.ru";
    private static final String REGISTER_PATH = "/api/auth/register";
    private static final String DELETE_PATH = "/api/auth/user";

    @Step("Создание пользователя через API")
    public ValidatableResponse createUser(UserRequest userRequest) {
        return given()
                .header("Content-Type", "application/json")
                .body(userRequest)
                .when()
                .post(BASE_URL + REGISTER_PATH)
                .then();
    }

    @Step("Удаление пользователя через API")
    public ValidatableResponse deleteUser(String accessToken) {
        return given()
                .header("Authorization", accessToken)
                .when()
                .delete(BASE_URL + DELETE_PATH)
                .then();
    }
}
