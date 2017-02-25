package com.codenotfound.jsf.primefaces.model;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class UserTest {

    private User user;

    @Before
    public void setUp() throws Exception {
        user = new User("userId", "firstName", "lastName");
    }

    @Test
    public void testGetUserId() {
        user.setUserId("admin");

        assertEquals("admin", user.getUserId());
    }

    @Test
    public void testGetFirstName() {
        user.setFirstName("Jane");

        assertEquals("Jane", user.getFirstName());
    }

    @Test
    public void testGetLastName() {
        user.setLastName("Doe");

        assertEquals("Doe", user.getLastName());
    }

    @Test
    public void testGetName() {
        user.setFirstName("Jane");
        user.setLastName("Doe");

        assertEquals("Jane Doe", user.getName());
    }

    @Test
    public void testToString() {
        user.setUserId("admin");
        user.setFirstName("Jane");
        user.setLastName("Doe");

        assertEquals("user[userId=admin, firstName=Jane, lastName=Doe]",
                user.toString());
    }
}
