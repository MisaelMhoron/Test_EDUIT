package EduIT;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.junit.Ignore;
import org.junit.Test;

public class Laboratorio2 {
	@Test
	public void lab2_E1test() {

		//System.setProperty("webdriver.chrome.driver", "..\\EduIt\\Drivers\\geckodriver.exe");

String url="http://www.automationpractice.pl/index.php?controller=authentication&back=my-account";
		
		System.setProperty("webdriver.chrome.driver", "..\\EduIt\\Drivers\\chromedriver.exe");
		ChromeOptions options=new ChromeOptions();
		options.addArguments("remote-allow-origins=*");
		WebDriver driver= new ChromeDriver(options);
		driver.get(url);
		driver.manage().window().maximize();
		
		WebElement btnSignin = driver.findElement(By.linkText("Sign in"));// para acceder a un boton  link
		btnSignin.click();
		
		/*driver.get("http://www.automationpractice.pl/index.php?controller=authentication&back=my-account");
		driver.manage().window().maximize(); // Maximiza la ventana del navegador*/

		// encontrar elememtos
		WebElement txtEmail = driver.findElement(By.id("email_create"));
		txtEmail.sendKeys("micorreo" + Math.random() + "@correo.com");
		WebElement btnCreate = driver.findElement(By.id("SubmitCreate"));
		// btnCreate.sendKeys(Keys.ENTER);
		btnCreate.click();

		// espera explicita
		WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(10));
		mywait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(@id,'id_gender1')]")));

		// buscar elementos del formulario registrar
		WebElement txtradiobtn = driver.findElement(By.id("id_gender1"));
		txtradiobtn.click();

		WebElement txtPrimernombre = driver.findElement(By.id("customer_firstname"));
		txtPrimernombre.sendKeys("Juan");
		WebElement txtSegundonombre = driver.findElement(By.id("customer_lastname"));
		txtSegundonombre.sendKeys("Perez");
		WebElement txtPass = driver.findElement(By.name("passwd"));
		txtPass.sendKeys("admin");
		Select dia = new Select(driver.findElement(By.id("days")));
		dia.selectByValue("24");
		Select months = new Select(driver.findElement(By.id("months")));
		months.selectByValue("5");
		Select anio = new Select(driver.findElement(By.id("years")));
		anio.selectByValue("1984");
		WebElement btnSubmit = driver.findElement(By.id("submitAccount"));
		btnSubmit.click();
		// espera explicita
		WebDriverWait mywait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
		mywait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(.,'Add my first address')]")));

		WebElement btnDireccion = driver.findElement(By.xpath("//span[contains(.,'Add my first address')]"));// para acceder a un boton  link
		btnDireccion.click();
		
		
		//driver.quit(); 

	}
	

}
