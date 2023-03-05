package utilities;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class Token {

    protected static RequestSpecification requestSpec;
    protected static String boardID;



    public static void createRequestSpecifications(){
        requestSpec=new RequestSpecBuilder()
                .setBaseUri("https://api.trello.com")
                .addQueryParam("token","ATTA00cf87db7ee2e82d3c7936cbb4e5476807504c9d4108babf2ae354bc6f72b92f0937B547")
                .addQueryParam("key","ed83fcf90b9b66760a2f7856f965a8ef")
                .addHeader("Content-Type","application/json")
                .build();
    }

    public static void deleteBoard(){
        given().spec(requestSpec)
                .pathParam("id", boardID)
                .body("")
                .when().delete("1/boards/{id}");

    }

}
