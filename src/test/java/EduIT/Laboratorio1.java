package EduIT;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.*;
import org.junit.Ignore;
import org.junit.Test;

public class Laboratorio1 {
	@Test @Ignore
	public void lab1_test() {
		System.out.println("Hola Mundo de Automatización!");
	}
	@Test @Ignore
	public void lab1_e1() {
		System.setProperty("webdriver.chrome.driver", "..\\EduIt\\Drivers\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.automationpractice.pl/index.php?");
		
		//driver.close();
	}
	@Test @Ignore
	public void lab1_e2() {
		System.setProperty("webdriver.gecko.driver", "..\\EduIt\\Drivers\\geckodriver.exe");
		
		WebDriver driverf = new FirefoxDriver();
		driverf.get("http://www.automationpractice.pl/index.php?");
		
		//driver.close();
	}
	
	@Test
	public void lab1_e3() {
  		System.setProperty("webdriver.chrome.driver", "..\\EduIt\\Drivers\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.automationpractice.pl/index.php?");
		driver.manage().window().maximize(); //Maximiza la ventana del navegador
		//caja de busqueda
		WebElement txtBuscador = driver.findElement(By.id("search_query_top"));
		txtBuscador.clear();
		/* Boton buscar*/
		
		WebElement Btnbuscar = driver.findElement(By.name("submit_search"));
		//llamado a elementos
		txtBuscador.sendKeys("women");
		//incluir nter
		//Btnbuscar.sendKeys(Keys.ENTER);
		
		
		Btnbuscar.click();
		
		//driver.close();
	}
	
	
	

}
