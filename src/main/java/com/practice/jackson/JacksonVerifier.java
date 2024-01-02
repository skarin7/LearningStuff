package com.practice.jackson;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.type.TypeFactory;
import org.junit.Ignore;
import org.junit.Test;

import javax.jws.soap.SOAPBinding;
import java.io.IOException;
import java.io.PushbackInputStream;

/**
 * Created by shankar on 8/5/17.
 */
public class JacksonVerifier {

    @JsonDeserialize(as = Cat.class)
    public abstract class Animal {
        public String name;

        public Animal() { }
    }


    class Cat extends Animal {
        public int lives;

        public Cat() {

        }
    }
    public class Zoo {
        public Animal animal;

        public Zoo() { }

        public Animal getAnimal() {
            return animal;
        }

        public void setAnimal(Animal animal) {
            this.animal = animal;
        }
    }

    public class User {
        public int id;
        public String name;

        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public User() {
            super();
        }
    }

    @Test(expected = Exception.class)
    @Ignore
    public void givenAbstractClass_whenDeserializing_thenException()
            throws IOException {
        String json = "{\"animal\":{\"name\":\"lacy\"}}";
        ObjectMapper mapper = new ObjectMapper();
//        String json = "{\"name\": \"shankar\"}";

        Animal animal = mapper.reader().forType(Cat.class).readValue(json);
    }

    @Test
    public void givenNoDefaultConstructor_whenDeserializing_thenException()
            throws IOException {
        String json = "{\"id\":1,\"name\":\"John\"}";
        ObjectMapper mapper = new ObjectMapper();
        mapper.reader().forType(User.class).readValue(json);
    }
}
