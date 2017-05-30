package com.practice.jackson;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by shankar on 25/5/17.
 */

public class JacksonAnnotationPractice {


    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class DummyConfig {
        public String name;
        // This private field will not be serilaized with out getter and setters..
        private String address;
        private String height;

        // Will be written at the time of serialization only, not for deserialization(Sending to the user..)
        @JsonProperty(access = JsonProperty.Access.READ_ONLY)
        private String nickName;

        public String getNickName() {
            return nickName;
        }

//        @JsonProperty
        public void setNickName(String nickName) {
            this.nickName = nickName;
        }

        public String getHeight() {
            return height;
        }

        @JsonIgnore
        public void setHeight(String height) {
            this.height = height;
        }

        private int weighht;

        public int getWeighht() {
            return weighht;
        }

        public void setWeighht(int weighht) {
            this.weighht = weighht;
        }
    }
    String jsonString;
    ObjectMapper mapper = new ObjectMapper();
    @Before
    public void setUp() {
        DummyConfig dummyConfig = new DummyConfig();
        dummyConfig.name = "shankar";
        dummyConfig.address= "Hyderabad";
        dummyConfig.height = "5.8";
        dummyConfig.weighht = 80;
        try {
             jsonString = mapper.writeValueAsString(dummyConfig);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testSerializePublicFields() {
        assertTrue(jsonString.contains("shankar"));
    }

    @Test
    public void testDeserializePublicFields() {
        try {
           DummyConfig dummyConfig =  mapper.readValue(jsonString, DummyConfig.class);
           assertEquals(dummyConfig.name, "shankar");
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertTrue(jsonString.contains("shankar"));
    }

    @Test
    public void testPrivateFieldNotSerialized() {
        assertFalse(jsonString.contains("Hyderabad"));
    }


    @Test
    public void testPrivateFieldWithSetterSerialized() {
        assertTrue(jsonString.contains("80"));
    }

    @Test
    public void testDeserializePrivateFieldWithGetter() {
        try {
            DummyConfig dummyConfig =  mapper.readValue(jsonString, DummyConfig.class);
            assertEquals(dummyConfig.getWeighht(), 80);
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertTrue(jsonString.contains("shankar"));
    }


    //If we put json ignore on setter, it value wil not written to json , or serialization....
    @Test
    public void testPrivateFieldWithSetterIgnoredNotSerialized() {
        assertFalse(jsonString.contains("5.8"));
    }

    @Test
    public void testPrivateFieldWithSetterIgnoredNotDeserilized() {
        String dummyjson = "{\"name\": \"test\", \"height\": \"5.9\"}";
        try {
            DummyConfig dummyConfig =  mapper.readValue(dummyjson, DummyConfig.class);
            System.out.println(" height: " + dummyConfig.getHeight());
            assertNotEquals(dummyConfig.getHeight(), "5.9");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testWriteOnlyFieldNotDeserilized() {
        String dummyjson = "{\"name\": \"test\", \"unkown\": \"5.9\", \"nickName\": \"shan\"}";
        try {
            DummyConfig dummyConfig =  mapper.readValue(dummyjson, DummyConfig.class);
            System.out.println(" Nick: " + dummyConfig.getNickName());
            assertNotEquals(dummyConfig.getNickName(), "shan");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
