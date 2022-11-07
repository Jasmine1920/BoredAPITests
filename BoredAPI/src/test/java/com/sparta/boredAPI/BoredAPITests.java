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

public class BoredAPITests {
    private static HttpResponse<String> httpResponse = null;
    private static Response response=null;
    @BeforeAll
    public static void oneTimeSetUp() {
        HttpClient httpClient = HttpClient.newBuilder().build();
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create("http://www.boredapi.com/api/activity?type=recreational"))
                .build();

        try {
            httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        try {
            ObjectMapper objectMapper=new ObjectMapper();
            response=objectMapper.readValue(httpResponse.body(), Response.class);
        }
        catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    @Test
    @DisplayName("Testing getting a recreational activity")
    public void recreationalactivitytest(){
        Assertions.assertEquals("recreational",response.getType());
    }

    @Test
    @DisplayName("Testing activity is recreational and not empty")
    public void activitynotempty(){
        Assertions.assertTrue(response.activityisrecreationalandnotnull());
    }
}
