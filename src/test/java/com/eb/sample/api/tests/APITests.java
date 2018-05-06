package com.eb.sample.api.tests;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class APITests {
    public static void main(String[] args) throws UnirestException {
        String randJokeURL = "https://icanhazdadjoke.com";
        String jokeByIdURL = "https://icanhazdadjoke.com/j/";
        final HttpResponse<JsonNode> response01 = Unirest.get(randJokeURL).header("accept", "application/json").asJson();
        String joke = response01.getBody().getObject().getString("joke");
        System.out.println("\n\n>>>>>>>          " + joke);


        final HttpResponse<JsonNode> response02 = Unirest.get(jokeByIdURL + "R7UfaahVfFd").header("accept", "application/json").asJson();
        String joke2 = response02.getBody().getObject().getString("joke");
        System.out.println("\n\n>>>>>>>          " + joke2);
        System.out.println("Very funny!");
    }
}
