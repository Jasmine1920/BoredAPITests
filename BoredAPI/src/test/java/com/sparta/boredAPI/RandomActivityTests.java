package com.sparta.boredAPI;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sparta.boredAPI.dto.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class RandomActivityTests {
    private static HttpResponse<String> httpResponse = null;
    private static Response response = null;

    @BeforeAll
    public static void oneTimeSetUp() {
        HttpClient httpClient = HttpClient.newBuilder().build();
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create("https://www.boredapi.com/api/activity/"))
                .setHeader("Content-type", "application/json")
                .build();

        try {
            httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            response = objectMapper.readValue(httpResponse.body(), Response.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    @Test
    @DisplayName("URI Path")
    public void testUriPath() {
        Assertions.assertEquals("/api/activity/", httpResponse.uri().getPath());
    }

    @Test
    @DisplayName("Full URI")
    public void testFullUri() {
        Assertions.assertEquals("https://www.boredapi.com/api/activity/", httpResponse.uri().toString());
    }

    @Test
    @DisplayName("Status code is 200")
    public void testStatusCode() {
        Assertions.assertEquals(200, httpResponse.statusCode());
    }

//    @Test
//    @DisplayName("Response object is not empty")
//    public void testResponseObjNotEmpty() {
//        Assertions.assertTrue(response.isNotEmpty());
//    }

}
