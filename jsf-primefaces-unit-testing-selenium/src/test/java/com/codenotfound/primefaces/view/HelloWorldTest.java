package com.codenotfound.primefaces.view;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.PageFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
public class HelloWorldTest {

  @Test
  public void testSubmit() throws InterruptedException {
    WebDriver driver = new HtmlUnitDriver();
    driver.get("http://localhost:9090/codenotfound/helloworld.xhtml");

    HelloWorldPage page =
        PageFactory.initElements(driver, HelloWorldPage.class);
    page.submit("Jane", "Doe");

    assertThat(driver.findElement(By.id("hello-world-form:greeting"))
        .getAttribute("textContent")).isEqualTo("Hello Jane Doe!");
  }
}
