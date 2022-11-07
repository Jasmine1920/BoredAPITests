package com.sparta.boredAPI;



import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sparta.boredAPI.dto.Response;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;



import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;




public class ActivityInfo{


    private static HttpResponse<String> httpResponse = null;
    private static JSONObject jsonObject = null;
    private static Response response = null;



    @BeforeAll
    public static void oneTimeSetUp() {
        HttpClient httpClient = HttpClient.newBuilder().build();
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create("http://www.boredapi.com/api/activity?key=5881028"))
                .setHeader("Content-type", "application/json")
                .build();



        try {
            httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }



        JSONParser jsonParser = new JSONParser();
        try {
            jsonObject = (JSONObject)jsonParser.parse(httpResponse.body());
            ObjectMapper objectMapper = new ObjectMapper();
            response = objectMapper.readValue(httpResponse.body(), Response.class);
        }
        catch (ParseException | JsonProcessingException e) {
            e.printStackTrace();
        }
    }



    @Test
    @DisplayName("URI path")
    public void testResponsePath() {
        Assertions.assertEquals("/api/activity", httpResponse.uri().getPath());
    }



    @Test
    @DisplayName("Full URI")
    public void testFullURI() {
        Assertions.assertEquals("http://www.boredapi.com/api/activity?key=5881028" , httpResponse.uri().toString());
    }




    @Test
    @DisplayName("Accessibility 0.25")
    public void testStatusCode() {
        Assertions.assertEquals(0.25, response.getAccessibility());
    }



    @Test
    @DisplayName("Result = valid activity")
    public void testResult() {
        Assertions.assertEquals("Learn a new programming language", jsonObject.get("activity"));
    }



    @Test
    @DisplayName("Result = valid price")
    public void testPrice(){
        Assertions.assertEquals(0.1, response.getPrice());
    }
}
