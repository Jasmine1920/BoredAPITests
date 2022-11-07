package com.sparta.boredAPI.dto.testing;

import com.sparta.boredAPI.dto.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class IsNotEmptyTests {

    @Test
    @DisplayName("Given the non-empty Response object IsNotEmptyTests returns true")
    public void nonEmptyObjectTest() {
        Response response = new Response("Google something", 0.5, 0.0, "https://google.com", "recreational", "1111111", 1);
        Assertions.assertTrue(response.isNotEmpty());
    }

    @Test
    @DisplayName("Given the empty Response object IsNotEmptyTests returns false")
    public void emptyObjectTest() {
        Response response = new Response();
        Assertions.assertFalse(response.isNotEmpty());
    }

    @Test
    @DisplayName("Given the Response object without activity name IsNotEmptyTests returns false")
    public void objectWithoutActivityTest() {
        Response response = new Response(null, 0.5, 0.0, "https://google.com", "recreational", "1111111", 1);
        Assertions.assertFalse(response.isNotEmpty());
    }

    @Test
    @DisplayName("Given the Response object without a link IsNotEmptyTests returns false")
    public void objectWithoutLinkTest() {
        Response response = new Response("Google something", 0.5, 0.0, null, "recreational", "1111111", 1);
        Assertions.assertFalse(response.isNotEmpty());
    }

    @Test
    @DisplayName("Given the Response object without a type IsNotEmptyTests returns false")
    public void objectWithoutTypeTest() {
        Response response = new Response("Google something", 0.5, 0.0, "https://google.com", null, "1111111", 1);
        Assertions.assertFalse(response.isNotEmpty());
    }

    @Test
    @DisplayName("Given the Response object without a key IsNotEmptyTests returns false")
    public void objectWithoutKeyTest() {
        Response response = new Response("Google something", 0.5, 0.0, "https://google.com", "recreational", null, 1);
        Assertions.assertFalse(response.isNotEmpty());
    }

}
