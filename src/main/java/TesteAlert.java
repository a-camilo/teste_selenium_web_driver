import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteAlert {

    private WebDriver driver;

    @BeforeEach
    public void inicializa() {
        System.setProperty("webdriver.chrome.driver", "C:/Users/AntonioCamiloGomesdo/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("file:///C:/Users/AntonioCamiloGomesdo/Desktop/componentes.html");
    }

    @AfterEach
    public void finaliza() throws InterruptedException {
        Thread.sleep(1000);
        driver.quit();
    }

    @Test
    public void deveInteragirComAlertSimples() {
        driver.findElement(By.id("alert")).click();
        Alert alert = driver.switchTo().alert();
        String texto = alert.getText();
        Assertions.assertEquals("Alert Simples", texto);
        alert.accept();
        driver.findElement(By.id("elementosForm:nome")).sendKeys(texto);
    }

    @Test
    public void deveInteragirComAlertConfirm() {
        driver.findElement(By.id("confirm")).click();
        Alert alert = driver.switchTo().alert();
        String texto = alert.getText();
        Assertions.assertEquals("Confirm Simples", texto);
        alert.accept();
        texto = alert.getText();
        Assertions.assertEquals("Confirmado", texto);
        alert.accept();


        driver.findElement(By.id("confirm")).click();
        alert = driver.switchTo().alert();
        texto = alert.getText();
        Assertions.assertEquals("Confirm Simples", texto);
        alert.dismiss();
        texto = alert.getText();
        Assertions.assertEquals("Negado", texto);
        alert.accept();
    }
    @Test
    public void deveInteragirComPrompt(){
        driver.findElement(By.id("prompt")).click();
        Alert alert = driver.switchTo().alert();
        Assertions.assertEquals("Digite um numero",alert.getText());
        alert.sendKeys("5");
        alert.accept();
        Assertions.assertEquals("Era 5?",alert.getText());
        alert.accept();
        Assertions.assertEquals(":D",alert.getText());
    }
}
