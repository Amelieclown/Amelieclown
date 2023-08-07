package ramiz.backend.test;

import org.junit.Test;
import ramiz.backend.models.BaseError;
import ramiz.backend.specification.Specifications;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class getSessionId {
    private final String url = "https://sales-dev-api.south.rt.ru/apiman-gateway";
    private final String oldSessionId = "d54a9cd6-2985-4441-ac46-58c776a9fc1c";
    private final String notExistentSessionId = "floppa2006";
    private final String SuccsessSessionId = "???";
    private final String path = "/adapters-sales/integration-module-c-adapter/1.0-dev/sessionCheck/";


    @Test
    public void getsessionIdWithoutXrequestid400() {
        Specifications.installSpec(Specifications.requestFloppa(url, path + oldSessionId), Specifications.response400());
        given()
                .queryParam("apikey", "51c465d2-9a10-4159-ad7a-2b86b41f3e58")
                .when()
                .get()
                .then()
                .body("message", equalTo("Header 'X-Request-Id' is required"))
                .body("error", equalTo("EX_VALIDATION_ERROR"));
    }

    @Test
    public void getsessionIdDead404() {
        Specifications.installSpec(Specifications.requestFloppa(url, path + oldSessionId), Specifications.response404());
        given()
                .queryParam("apikey", "51c465d2-9a10-4159-ad7a-2b86b41f3e58")
                .header("x-request-id", "auto-ramiz")
                .when()
                .get()
                .then()
                .body("message", equalTo(" Время сессии |" + oldSessionId + "| пользователя истекло"))
                .body("error", equalTo("EX_ILLEGAL_ARGUMENT"));
    }

    @Test
    public void getsessionIdOverdue404() {
        Specifications.installSpec(Specifications.requestFloppa(url, path + notExistentSessionId), Specifications.response404());
        given()
                .queryParam("apikey", "51c465d2-9a10-4159-ad7a-2b86b41f3e58")
                .header("x-request-id", "auto-ramiz")
                .when()
                .get()
                .then()
                .body("message", equalTo("Не найден пользователь с сессией  |" + notExistentSessionId + "| "))
                .body("error", equalTo("EX_NOT_FOUND"));
    }
    @Test
    public void getsessionIdSuccsess200() {
        Specifications.installSpec(Specifications.requestFloppa(url, path + SuccsessSessionId), Specifications.response200());
        given()
                .queryParam("apikey", "51c465d2-9a10-4159-ad7a-2b86b41f3e58")
                .header("x-request-id", "auto-ramiz")
                .when()
                .get()
                .then()
                .body("amdocsLogin", equalTo("???"));
    }
}

