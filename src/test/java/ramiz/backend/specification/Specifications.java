package ramiz.backend.specification;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Specifications {
    public static RequestSpecification requestFloppa(String url, String path){
    return new RequestSpecBuilder()
        .setBaseUri(url)
        .setBasePath(path)
        .setContentType(ContentType.JSON)
        .log(LogDetail.ALL)
        .build();
    }

    public static ResponseSpecification response200(){
        return new ResponseSpecBuilder()
                .expectStatusCode(200)
                .log(LogDetail.ALL)
                .build();
    }

    public static ResponseSpecification response400(){
        return new ResponseSpecBuilder()
                .expectStatusCode(400)
                .log(LogDetail.ALL)
                .build();
    }

    public static ResponseSpecification response404(){
        return new ResponseSpecBuilder()
                .expectStatusCode(404)
                .log(LogDetail.ALL)
                .build();
    }
    public static ResponseSpecification responseSystemcode(int systemCode){
        return new ResponseSpecBuilder()
                .expectStatusCode(systemCode)
                .log(LogDetail.ALL)
                .build();
    }
    public static void installSpec(RequestSpecification request, ResponseSpecification response){
        RestAssured.requestSpecification = request;
        RestAssured.responseSpecification = response;
    }
}


