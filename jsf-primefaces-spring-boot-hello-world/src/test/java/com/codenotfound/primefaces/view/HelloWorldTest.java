package com.codenotfound.primefaces.view;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
public class HelloWorldTest {

  @Test
  public void testSubmit() throws InterruptedException {
    WebDriver driver = new HtmlUnitDriver();
    driver.get("http://localhost:9090/codenotfound");

    WebElement firstNameInputText = driver.findElement(By.id("hello-world:first-name"));
    firstNameInputText.clear();
    firstNameInputText.sendKeys("Jane");
    WebElement lastNameInputText = driver.findElement(By.id("hello-world:last-name"));
    lastNameInputText.clear();
    lastNameInputText.sendKeys("Doe");

    WebElement submitButton = driver.findElement(By.id("hello-world:submit"));
    submitButton.click();

    int timeCount = 1;

    while (driver.getWindowHandles().size() == 1) {
      System.out.println("in while");
      Thread.sleep(200);

      timeCount++;
      if (timeCount > 10) {
        break;
      }
    }

    for (String currentWindow : driver.getWindowHandles())
      driver.switchTo().window(currentWindow);
    {
      // Now you are in Popup window and you can get the pop-up window URL here
      System.out.println("aaaaaaaaaaaa " + driver.getTitle());
    }

    // System.out.println(driver.getPageSource());

    driver.quit();
  }
}
