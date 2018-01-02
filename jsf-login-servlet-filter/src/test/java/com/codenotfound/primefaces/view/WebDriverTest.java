package com.codenotfound.primefaces.view;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class WebDriverTest {

  protected static WebDriver driver;

  @BeforeClass
  public static void setUp() {
    driver = new HtmlUnitDriver();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  }

  @After
  public void cleanUp() {
    driver.manage().deleteAllCookies();
  }

  @AfterClass
  public static void tearDown() {
    driver.close();
  }
}
