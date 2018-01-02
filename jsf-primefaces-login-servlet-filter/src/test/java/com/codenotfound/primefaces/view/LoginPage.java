package com.codenotfound.primefaces.view;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends PageObject {

  @FindBy(id = "login-form:user-name")
  private WebElement userNameInput;

  @FindBy(id = "login-form:password")
  private WebElement passwordInput;

  @FindBy(id = "login-form:login")
  private WebElement loginButton;

  @FindBy(id = "home-form:welcome-message")
  private WebElement welcomeMessage;

  @FindBy(how = How.CLASS_NAME, using = "ui-messages-warn-summary")
  private WebElement warning;

  public LoginPage(WebDriver driver) {
    super(driver);
  }

  public void login(String userName, String password) {
    userNameInput.sendKeys(userName);
    passwordInput.sendKeys(password);

    loginButton.submit();

    PageFactory.initElements(driver, this);
  }

  public String getWelcomeMessage() {
    return welcomeMessage.getText();
  }

  public String getWarning() {
    return warning.getText();
  }
}
