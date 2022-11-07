package com.sparta.boredAPI;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sparta.boredAPI.dto.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class PriceInRangeTests {
    private static HttpResponse<String> httpResponse = null;
    private static Response response = null;
    private static Logger logger= LogManager.getLogger("logger");

    @BeforeAll
    public static void oneTimeSetUp() throws IOException, InterruptedException {
        HttpClient httpClient = HttpClient.newBuilder().build();
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create("https://www.boredapi.com/api/activity?minprice=0.1&maxprice=0.5"))
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

        try {
            logger.info("Creating a Response object");
            ObjectMapper objectMapper = new ObjectMapper();
            response = objectMapper.readValue(httpResponse.body(), Response.class);
        } catch (JsonProcessingException e) {
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
        Assertions.assertEquals("https://www.boredapi.com/api/activity?minprice=0.1&maxprice=0.5", httpResponse.uri().toString());
    }

    @Test
    @DisplayName("Status code is 200")
    public void testStatusCode() {
        Assertions.assertEquals(200L, httpResponse.statusCode());
    }

    @Test
    @DisplayName("Error message")
    public void testResult() {
        Assertions.assertTrue(response.getPrice() >= 0.1 && response.getPrice() <= 0.5);
    }
}
