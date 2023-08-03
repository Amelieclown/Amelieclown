package ramiz.backend.test;

import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import org.junit.Test;
import ramiz.backend.specification.Specifications;

import static io.restassured.RestAssured.given;

public class getUserTest {
    private final String url = "https://reqres.in";
    private final String path = "/api/users?page=2";


    @Test
    public void getListUser200Code(){
        Specifications.installSpec(Specifications.requestFloppa(url,path),Specifications.response200());
        given()
                .when()
                .get()
                .then();


    }
}
