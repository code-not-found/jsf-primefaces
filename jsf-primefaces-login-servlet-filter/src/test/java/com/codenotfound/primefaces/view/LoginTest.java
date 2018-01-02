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
public class LoginTest extends WebDriverTest {

  @Test
  public void testLogin() {
    driver.get("http://localhost:9090/codenotfound/login.xhtml");

    LoginPage page = new LoginPage(driver);
    page.login("john.doe", "1234");

    assertThat(page.getWelcomeMessage())
        .isEqualTo("Welcome, John Doe!");
  }

  @Test
  public void testLoginFailed() {
    driver.get("http://localhost:9090/codenotfound/login.xhtml");

    LoginPage page = new LoginPage(driver);
    page.login("jane.doe", "1234");

    assertThat(page.getWarning()).isEqualTo("Login failed");
  }
}
