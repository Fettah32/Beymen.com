package stepDefinitions.apiStepDefinitions;

import base_url_setup.base_url;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojos.boardsPost;
import pojos.cardsPost;
import pojos.putCard;

import java.net.http.HttpResponse;

import static io.restassured.RestAssured.given;



public class TrelloStepDefinitions extends base_url {



    //String token = "ATTA00cf87db7ee2e82d3c7936cbb4e5476807504c9d4108babf2ae354bc6f72b92f0937B547";
    //String apiKey = "ed83fcf90b9b66760a2f7856f965a8ef";

    Response response;

    ObjectMapper obj;

    boardsPost expectedBoardsPost;

    cardsPost expectedCardsPost;

    putCard expectedPutCard;

    @Given("Trello uzerinde bir board olusturunuz.")
    public void trelloUzerindeBirBoardOlusturunuz() {

       // spec.pathParams("1", "1", "2", "boards");
       // expectedBoardsPost = new boardsPost("Adil");
//
       // response = given().spec(spec).headers("Authorization", "Bearer Token" + token()).headers("Authorization", "API Key" + key()).body(expectedBoardsPost).
       //         contentType(ContentType.JSON).when().post("/{1}/{2}/");
//
       // response.prettyPrint();

        response=given().spec(spec)
                .queryParams("name", "Test Case 1","prefs_background","orange"
                        ,"prefs_background_url","https://images.unsplash.com/photo-1676694090990-b9e29828fdd3?ixid=Mnw3MDY2fDB8MXxjb2xsZWN0aW9ufDN8MzE3MDk5fHx8fHwyfHwxNjc2OTc4MzA4&ixlib=rb-4.0.3&w=2560&h=2048&q=90")
                .when().post("1/boards");
        response.prettyPrint();


    }





    @When("Olusturdugunuz board'a iki tane kart olusturunuz.")
    public void olusturdugunuzBoardAIkiTaneKartOlusturunuz() {

       //spec.pathParams("first", "1", "second", "cards");
       //expectedCardsPost = new cardsPost("5abbe4b7ddc1b351ef961414");

        //response = given().spec(spec).headers("Authorization", "Bearer Token" + token()).headers("Authorization", "API Key" + key()).body(expectedCardsPost).
        //        contentType(ContentType.JSON).when().post("{first}/{second}/");

        //response.prettyPrint();
    }

    @Then("Olusturdugunuz bu iki karttan random olacak sekilde bir tanesini guncelleyiniz.")
    public void olusturdugunuzBuIkiKarttanRandomOlacakSekildeBirTanesiniGuncelleyiniz() {
      // spec.pathParams("first", "1", "second", "cards", "third", "5abbe4b7ddc1b351ef961414");
      // expectedPutCard = new putCard("ashd252asdjnasdjk");
      // response = given().spec(spec).headers("Authorization", "Bearer Token" + token()).headers("Authorization", "API Key" + key()).body(expectedPutCard).
      //         contentType(ContentType.JSON).when().put("/{first}/{second}/{third}");

      // response.prettyPrint();

    }

    @Then("Olusturdugunuz kartlari siliniz.")
    public void olusturdugunuzKartlariSiliniz() {
       // spec.pathParams("first", "1", "second", "cards", "third", "5abbe4b7ddc1b351ef961414");
       // response = given().spec(spec).
       //         headers("Authorization", "Bearer Token" + token()).headers("Authorization", "API Key" + key()).when().delete("/{first}/{second}/{third}");
//
//
       // spec.pathParams("first", "1", "second", "cards", "third", "5asdqw25asd4asd");
       // response = given().spec(spec).
       //         headers("Authorization", "Bearer Token" + token()).headers("Authorization", "API Key" + key()).when().delete("/{first}/{second}/{third}");
    }

    @And("Olusturdugunuz board'u siliniz.")
    public void olusturdugunuzBoardUSiliniz() {
       //spec.pathParams("first", "1", "second", "boards", "third", "5abbe4b7ddc1b351ef961414");
       //response = given().spec(spec).
       //        headers("Authorization", "Bearer Token" + token()).headers("Authorization", "API Key" + key()).when().delete("/{first}/{second}/{third}");
    }
}
