package com.codenotfound.jsf.primefaces.filter;

import static org.junit.Assert.fail;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.codenotfound.jsf.primefaces.controller.UserManager;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ FacesContext.class })
public class LoginFilterTest {

    private static final String CONTEXT_PATH = "http://localhost:9090/cnf";

    private UserManager userManager;

    private LoginFilter loginFilter;

    @Mock
    private HttpServletRequest httpServletRequest;
    @Mock
    private HttpServletResponse httpServletResponse;
    @Mock
    private FilterChain filterChain;
    @Mock
    private HttpSession httpSession;
    @Mock
    private FilterConfig filterConfig;

    @Mock
    private FacesContext facesContext;
    @Mock
    private ExternalContext externalContext;

    @Before
    public void setUp() throws Exception {

        loginFilter = new LoginFilter();

        when(httpServletRequest.getSession()).thenReturn(httpSession);
        when(httpServletRequest.getContextPath())
                .thenReturn(CONTEXT_PATH);

        // mock all static methods of FacesContext
        PowerMockito.mockStatic(FacesContext.class);
        when(FacesContext.getCurrentInstance())
                .thenReturn(facesContext);
        when(facesContext.getExternalContext())
                .thenReturn(externalContext);
    }

    @After
    public void tearDown() throws Exception {
        loginFilter.destroy();
    }

    @Test
    public void testDoFilterUserManagerNull()
            throws IOException, ServletException {
        userManager = null;
        when(httpSession.getAttribute("userManager"))
                .thenReturn(userManager);

        loginFilter.doFilter(httpServletRequest, httpServletResponse,
                filterChain);

        verify(httpServletResponse)
                .sendRedirect(CONTEXT_PATH + LoginFilter.LOGIN_PAGE);
    }

    @Test
    public void testDoFilterLoggedIn()
            throws IOException, ServletException {
        userManager = new UserManager();
        userManager.setUserId("john.doe");
        userManager.setUserPassword("1234");
        userManager.login();
        when(httpSession.getAttribute("userManager"))
                .thenReturn(userManager);

        loginFilter.doFilter(httpServletRequest, httpServletResponse,
                filterChain);

        verify(filterChain).doFilter(httpServletRequest,
                httpServletResponse);
    }

    @Test
    public void testDoFilterNotLoggedIn()
            throws IOException, ServletException {
        userManager = new UserManager();
        when(httpSession.getAttribute("userManager"))
                .thenReturn(userManager);

        loginFilter.doFilter(httpServletRequest, httpServletResponse,
                filterChain);

        verify(httpServletResponse)
                .sendRedirect(CONTEXT_PATH + LoginFilter.LOGIN_PAGE);
    }

    @Test
    public void testInit() {
        try {
            loginFilter.init(filterConfig);
        } catch (ServletException e) {
            fail("no error should be thrown");
        }
    }
}
