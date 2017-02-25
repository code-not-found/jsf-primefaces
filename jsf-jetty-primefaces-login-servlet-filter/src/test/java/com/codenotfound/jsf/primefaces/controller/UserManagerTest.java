package com.codenotfound.jsf.primefaces.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.when;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ FacesContext.class })
public class UserManagerTest {

    private UserManager userManager;

    @Mock
    private FacesContext facesContext;
    @Mock
    private ExternalContext externalContext;

    @Before
    public void setUp() throws Exception {
        userManager = new UserManager();

        // mock all static methods of FacesContext
        PowerMockito.mockStatic(FacesContext.class);
        when(FacesContext.getCurrentInstance())
                .thenReturn(facesContext);
        when(facesContext.getExternalContext())
                .thenReturn(externalContext);
    }

    @Test
    public void testLoginSucces() {
        userManager.setUserId("john.doe");
        userManager.setUserPassword("1234");

        assertEquals(UserManager.HOME_PAGE_REDIRECT,
                userManager.login());
    }

    @Test
    public void testLoginFailUnknownUserName() {
        // unknown user name
        userManager.setUserId("user");
        userManager.setUserPassword("1234");

        assertNull(userManager.login());
    }

    @Test
    public void testLoginFailIncorrectPassword() {
        userManager.setUserId("john.doe");
        // incorrect password
        userManager.setUserPassword("5678");

        assertNull(userManager.login());
    }

    @Test
    public void testLogout() {
        userManager.setUserId("admin");
        userManager.setUserPassword("1234");
        userManager.login();

        assertEquals(UserManager.LOGOUT_PAGE_REDIRECT,
                userManager.logout());
    }

    @Test
    public void testIsLoggedInTrue() {
        userManager.setUserId("john.doe");
        userManager.setUserPassword("1234");
        userManager.login();

        assertEquals(true, userManager.isLoggedIn());
    }

    @Test
    public void testIsLoggedInForwardHomeTrue() {
        userManager.setUserId("john.doe");
        userManager.setUserPassword("1234");
        userManager.login();

        assertEquals(UserManager.HOME_PAGE_REDIRECT,
                userManager.isLoggedInForwardHome());
    }

    @Test
    public void testIsLoggedInForwardHomeFalse() {
        assertNull(userManager.isLoggedInForwardHome());
    }

    @Test
    public void testIsLoggedInFalse() {
        assertEquals(false, userManager.isLoggedIn());
    }

    @Test
    public void testGetUserName() {
        userManager.setUserId("admin");

        assertEquals("admin", userManager.getUserId());
    }

    @Test
    public void testGetUserPassword() {
        userManager.setUserPassword("p455w0rd");

        assertEquals("p455w0rd", userManager.getUserPassword());
    }

    @Test
    public void testGetUser() {
        userManager.setUserId("john.doe");
        userManager.setUserPassword("1234");
        userManager.login();

        assertNotNull(userManager.getCurrentUser());
        assertEquals("John",
                userManager.getCurrentUser().getFirstName());
        assertEquals("Doe", userManager.getCurrentUser().getLastName());
    }
}
