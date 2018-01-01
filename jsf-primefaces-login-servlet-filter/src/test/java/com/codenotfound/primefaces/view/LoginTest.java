package com.codenotfound.primefaces.view;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.PageFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
@DirtiesContext
public class LoginTest {

  @Test
  public void testLogin() {
    WebDriver driver = new HtmlUnitDriver();
    driver.get("http://localhost:9090/codenotfound/login.xhtml");

    LoginPage page =
        PageFactory.initElements(driver, LoginPage.class);
    page.login("john.doe", "1234");

    PageFactory.initElements(driver, page);

    assertThat(page.getWelcomeMessage())
        .isEqualTo("Welcome, John Doe!");
  }

  @Test
  public void testLoginFailed() {
    WebDriver driver = new HtmlUnitDriver();
    driver.get("http://localhost:9090/codenotfound/login.xhtml");

    LoginPage page =
        PageFactory.initElements(driver, LoginPage.class);
    page.login("jane.doe", "1234");

    PageFactory.initElements(driver, page);

    assertThat(page.getWarning()).isEqualTo("Login failed");
  }
}
