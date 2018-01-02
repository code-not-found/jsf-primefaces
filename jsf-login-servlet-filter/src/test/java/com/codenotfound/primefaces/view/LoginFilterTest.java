package com.codenotfound.primefaces.view;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
@DirtiesContext
public class LoginFilterTest extends WebDriverTest {

  @Test
  public void testLogin() {
    driver.get("http://localhost:9090/codenotfound/login.xhtml");

    LoginFilterPage page = new LoginFilterPage(driver);
    page.login("john.doe", "1234");

    assertThat(page.getWelcomeMessage())
        .isEqualTo("Welcome, John Doe!");
  }

  @Test
  public void testLoginFailed() {
    driver.get("http://localhost:9090/codenotfound/login.xhtml");

    LoginFilterPage page = new LoginFilterPage(driver);
    page.login("jane.doe", "1234");

    assertThat(page.getWarning()).isEqualTo("Login failed");
  }

  @Test
  public void testUnsecured() {
    driver.get("http://localhost:9090/codenotfound/unsecured.xhtml");

    LoginFilterPage page = new LoginFilterPage(driver);

    assertThat(page.getUnsecuredMessage()).isEqualTo(
        "This page is not secured and can be used to display information to users that do not have login credentials.");
  }
}
