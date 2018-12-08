package com.codenotfound.primefaces;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;
import com.codenotfound.WebDriverUtil;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
public class HelloWorldTest extends WebDriverUtil {

  @Test
  public void testSubmit() {
    driver.get("http://localhost:8080/helloworld.xhtml");

    HelloWorldPage page = new HelloWorldPage(driver);
    page.submit("Jane", "Doe");

    assertThat(page.getGreeting()).isEqualTo("Hello Jane Doe!");
  }
}
