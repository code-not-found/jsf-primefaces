package com.codenotfound.primefaces.view;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
public class HelloWorldTest extends WebDriverTest {

  @Test
  public void testWelcomePageRedirect() {
    driver.get("http://localhost:9090/codenotfound/");

    assertThat(driver.getTitle())
        .isEqualTo("PrimeFaces Hello World Example");
  }
}
