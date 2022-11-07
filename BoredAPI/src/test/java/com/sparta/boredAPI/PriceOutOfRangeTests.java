package com.sparta.boredAPI;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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

public class PriceOutOfRangeTests {
    private static HttpResponse<String> httpResponse = null;
    private static JSONObject jsonObject = null;
    private static Logger logger= LogManager.getLogger("logger");

    @BeforeAll
    public static void oneTimeSetUp() throws IOException, InterruptedException, ParseException {
        HttpClient httpClient = HttpClient.newBuilder().build();
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create("https://www.boredapi.com/api/activity?price=2"))
                .setHeader("Content-type", "application/json")
                .build();

        try {
            logger.info("Creating an httpResponse object");
            httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            logger.catching(e);
            logger.error("Exception thrown");
            logger.error(e.getMessage());
            throw e;
        }

        JSONParser jsonParser = new JSONParser();
        try {
            logger.info("Creating an jsonObject object");
            jsonObject = (JSONObject) jsonParser.parse(httpResponse.body());
        } catch (ParseException e) {
            logger.catching(e);
            logger.error("Exception thrown");
            logger.error(e.getMessage());
            throw e;
        }
    }

    @Test
    @DisplayName("URI Path")
    public void testUriPath() {
        Assertions.assertEquals("/api/activity", httpResponse.uri().getPath());
    }

    @Test
    @DisplayName("Full URI")
    public void testFullUri() {
        Assertions.assertEquals("https://www.boredapi.com/api/activity?price=2", httpResponse.uri().toString());
    }

    @Test
    @DisplayName("Status code is 200")
    public void testStatusCode() {
        Assertions.assertEquals(200L, httpResponse.statusCode());
    }

    @Test
    @DisplayName("Error message")
    public void testResult() {
        Assertions.assertEquals("No activity found with the specified parameters", jsonObject.get("error"));
    }
}
