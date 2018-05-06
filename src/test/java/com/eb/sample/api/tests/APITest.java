package com.eb.sample.api.tests;

import com.eb.sample.api.Joke;

import com.mashape.unirest.http.exceptions.UnirestException;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class APITest {

    private static Joke joke;

    @BeforeClass
    public static void setup(){
        joke = new Joke();
    }

    @AfterClass
    public static void teardown() throws IOException {
        joke.shutdown();
    }


    @Test
    public void getRandomJoke() throws UnirestException {
        String randomJoke01 = joke.getRandomJoke();
        String randomJoke02 = joke.getRandomJoke();
        Assert.assertNotNull("The first random joke is null.", randomJoke01);
        Assert.assertNotNull("The second random joke is null.", randomJoke02);
        Assert.assertNotEquals("The first random joke is empty.","", randomJoke01);
        Assert.assertNotEquals("The second random joke is empty.","", randomJoke02);
        Assert.assertNotSame("Both random jokes are the same.", randomJoke01, randomJoke02);
    }

    @Test
    public void getJokeById() throws UnirestException {
        String jokeById01 = joke.getJokeById("R7UfaahVfFd");
        String jokeById02 = joke.getJokeById("4MmjbFlbah");
        Assert.assertNotNull("The first joke is null.", jokeById01);
        Assert.assertNotNull("The second joke is null.", jokeById02);
        Assert.assertNotEquals("The first joke is empty.","", jokeById01);
        Assert.assertNotEquals("The sSecond joke is empty.","", jokeById02);
        Assert.assertNotSame("Both jokes are the same although their IDs are different.", jokeById01, jokeById02);
    }

}
