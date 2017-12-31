package com.codenotfound.primefaces.view;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HelloWorldPage {

  @FindBy(id = "hello-world-form:first-name-input")
  private WebElement firstNameInput;

  @FindBy(id = "hello-world-form:last-name-input")
  private WebElement lastNameInput;

  @FindBy(id = "hello-world-form:submit-button")
  private WebElement submitButton;

  public void submit(String firstName, String lastName) {
    firstNameInput.sendKeys(firstName);
    lastNameInput.sendKeys(lastName);
    submitButton.submit();
  }
}
