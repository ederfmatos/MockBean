package com.ederfmatos.mockbean.assertions;

import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import org.junit.Assert;

public class MockBeanAssertions {

    public static void assertJson(String json) {
        try {
            if (!(new JsonParser().parse(json).isJsonObject() || new JsonParser().parse(json).isJsonArray())) {
                throw new JsonSyntaxException("");
            }
        } catch (Throwable throwable) {
            Assert.fail(String.format("\"%s\" is not a valid json", json));
        }
    }

}
