package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import org.junit.jupiter.api.Test;

public class DeveloperTest {

    @Test
    public void testPrivateConstructor() throws Exception {
        // this hack is from https://www.timomeinen.de/2013/10/test-for-private-constructor-to-get-full-code-coverage/
        Constructor<Developer> constructor = Developer.class.getDeclaredConstructor();
        assertTrue(Modifier.isPrivate(constructor.getModifiers()),"Constructor is not private");

        constructor.setAccessible(true);
        constructor.newInstance();
    }

    @Test
    public void getName_returns_correct_name() {
        // TODO: Replace Chris G. with your name as shown on
        // <https://bit.ly/cs156-f24-teams>
        assertEquals("Daniel J", Developer.getName());
    }

    @Test
    public void getGithubId_returns_correct_id() {
        assertEquals("Division7", Developer.getGithubId());
    }

    @Test
    public void getTeam_returns_correct_teammates(){
        assertTrue(Developer.getTeam().getMembers().contains("Daniel"));
        assertTrue(Developer.getTeam().getMembers().contains("Sangita"));
        assertTrue(Developer.getTeam().getMembers().contains("Grace"));
        assertTrue(Developer.getTeam().getMembers().contains("Jenil"));
        assertTrue(Developer.getTeam().getMembers().contains("Hongrui"));
        assertTrue(Developer.getTeam().getMembers().contains("Amey"));
    }

    @Test
    public void teamName_is_correct_name(){
        assertEquals("f24-00", Developer.getTeam().getName());
    }
}
