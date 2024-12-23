package objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	@FindBy(id = "Email")
	private WebElement emailTextField;

	@FindBy(id = "Password")
	private WebElement PasswordTextField;

	@FindBy(xpath = "//input[@value='Log in']")
	private WebElement loginButton;

	// use ctrl+space for constructor
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// use getter and setter method by Source
	public WebElement getEmailTextField() {
		return emailTextField;
	}

	public WebElement getPasswordTextField() {
		return PasswordTextField;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}

}
