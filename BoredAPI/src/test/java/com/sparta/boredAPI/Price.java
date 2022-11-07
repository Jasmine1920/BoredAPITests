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

public class Price {
    private static HttpResponse<String> httpResponse = null;
    private static Response response = null;

    @BeforeAll
    public static void oneTimeSetUp() {
        HttpClient httpClient = HttpClient.newBuilder().build();
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create("http://www.boredapi.com/api/activity?price=0.0"))
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
    @DisplayName("Number of participants is 1")
    public void checkParticipantsIs1Test(){
        Assertions.assertEquals( 1,response.getParticipants());
    }


    @Test
    @DisplayName("Check of price is 0")
    public void checkPriceTeast(){
        Assertions.assertEquals(0,response.getPrice());
    }
}
