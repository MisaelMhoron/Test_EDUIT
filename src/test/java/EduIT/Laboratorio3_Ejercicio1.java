package EduIT;



import static org.testng.Assert.assertTrue;

import java.io.File;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Laboratorio3_Ejercicio1 {

	WebDriver driver;
	String url = "http://www.automationpractice.pl/index.php?";

	@BeforeSuite
	public void septUp() {
		System.setProperty("webdriver.chrome.driver", "..\\EduIt\\Drivers\\chromedriver.exe");

		ChromeOptions options = new ChromeOptions();
		options.addArguments("remote-allow-origins=*");
		driver = new ChromeDriver(options);
	}

	@BeforeTest
	public void irUrl() {
		driver.get(url);

	}

	@BeforeClass
	public void maxVentana() {
		driver.manage().window().maximize();
	}

	@Test(priority = 1, description = "Test Create Account")
	public void registrarUsuario() {
		WebElement btnSignin = driver.findElement(By.linkText("Sign in"));// para acceder a un boton link
		btnSignin.click();

		/*
		 * driver.get(
		 * "http://www.automationpractice.pl/index.php?controller=authentication&back=my-account"
		 * ); driver.manage().window().maximize(); // Maximiza la ventana del navegador
		 */

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
		
		//System.out.print(driver.getCurrentUrl());// para debugear
		Assert.assertEquals("http://www.automationpractice.pl/index.php?controller=authentication&back=my-account#account-creation", driver.getCurrentUrl());
		
		//WebElement btnSubmit = driver.findElement(By.id("submitAccount"));
		//btnSubmit.click();
		// espera explicita
	//	WebDriverWait mywait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
	//	mywait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(.,'Add my first address')]")));

	//	WebElement btnDireccion = driver.findElement(By.xpath("//span[contains(.,'Add my first address')]"));
	//	btnDireccion.click();
	}

	@Test(enabled = false)
	public void pruebaTest() {
		assertTrue(true);
	}
	
	@AfterMethod // se puede hacer dentro del test
    public void capturaPantalla() throws Exception{
        File screen=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screen,new File("..\\EduIt\\Evidencias\\pantalla.png"));
    }

	@AfterClass
	public void finPrueba() {
		System.out.println("Fin de Prueba");
	}

	@AfterTest
	public void cierreNavegador() {
		driver.close();
	}

	public void finSuite() {
		System.out.println("Fin de Suite");

	}
}


