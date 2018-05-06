package com.eb.sample.api;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.junit.Assert;

import java.io.IOException;

public class Joke {
    private String randJokeURL = "https://icanhazdadjoke.com";
    private String jokeByIdURL = randJokeURL + "/j/";
    private String key = "joke";

    public String getRandomJoke() throws UnirestException {
        final HttpResponse<JsonNode> response = Unirest.get(randJokeURL).header("accept", "application/json").asJson();
        int sts = response.getStatus();
        boolean isStatusRangeOk = (sts>=300 && sts <= 500) ? false : true;
        Assert.assertTrue("The response status is not ok. It's value is: " + sts + " " + response.getStatusText(), isStatusRangeOk);
        String jokeTxt = response.getBody().getObject().getString(key);
        return jokeTxt;
    }

    public String getJokeById(String id) throws UnirestException {
        final HttpResponse<JsonNode> response = Unirest.get(jokeByIdURL + "R7UfaahVfFd").header("accept", "application/json").asJson();
        int sts = response.getStatus();
        boolean isStatusRangeOk = (sts>=300 && sts <= 500) ? false : true;
        Assert.assertTrue("The response status is not ok. It's value is: " + sts + " " + response.getStatusText(), isStatusRangeOk);
        String jokeTxt = response.getBody().getObject().getString(key);
        return jokeTxt;
    }

    public void shutdown() throws IOException {
        Unirest.shutdown();
    }
}

