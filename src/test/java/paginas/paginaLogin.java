package paginas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class paginaLogin {

	@FindBy(id = "email")
	WebElement txtEmail;

	@FindBy(id = "passwb")
	WebElement txtPassword;

	@FindBy(id = "SubmitLogin")
	WebElement btnLogin;

	@FindBy(xpath = "")
	WebElement titleForm;

	public paginaLogin(WebDriver driver) {

	}

	public void enterEmail(String email, String password) {

	}

}
