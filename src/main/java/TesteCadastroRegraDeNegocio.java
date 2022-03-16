import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TesteCadastroRegraDeNegocio {

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
    public void deveValidarNomeObrigtorio() {
        driver.findElement(By.id("elementosForm:cadastrar")).click();
        Alert alert = driver.switchTo().alert();
        Assertions.assertEquals("Nome eh obrigatorio", alert.getText());
        alert.accept();
    }

    @Test
    public void deveValidarSobrenomeObrigtorio() {
        driver.findElement(By.id("elementosForm:nome")).sendKeys("Antonio");
        driver.findElement(By.id("elementosForm:cadastrar")).click();
        Alert alert = driver.switchTo().alert();
        Assertions.assertEquals("Sobrenome eh obrigatorio", alert.getText());
        alert.accept();
    }

    @Test
    public void deveValidarSexo() {
        driver.findElement(By.id("elementosForm:nome")).sendKeys("Antonio");
        driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Santos");
        driver.findElement(By.id("elementosForm:cadastrar")).click();
        Alert alert = driver.switchTo().alert();
        Assertions.assertEquals("Sexo eh obrigatorio", alert.getText());
    }

    @Test
    public void deveValidarComidaVegetariana() {
        driver.findElement(By.id("elementosForm:nome")).sendKeys("Antonio");
        driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Santos");
        driver.findElement(By.id("elementosForm:sexo:0")).click();
        driver.findElement(By.id("elementosForm:comidaFavorita:0")).click();
        driver.findElement(By.id("elementosForm:comidaFavorita:3")).click();
        driver.findElement(By.id("elementosForm:cadastrar")).click();
        Alert alert = driver.switchTo().alert();
        Assertions.assertEquals("Tem certeza que voce eh vegetariano?", alert.getText());
    }

    @Test
    public void deveValidarEsportistaIndeciso() {
        driver.findElement(By.id("elementosForm:nome")).sendKeys("Antonio");
        driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Santos");
        driver.findElement(By.id("elementosForm:sexo:0")).click();
        driver.findElement(By.id("elementosForm:comidaFavorita:0")).click();
        new Select(driver.findElement(By.id("elementosForm:esportes"))).selectByVisibleText("Natacao");
        new Select(driver.findElement(By.id("elementosForm:esportes"))).selectByVisibleText("O que eh esporte?");
        driver.findElement(By.id("elementosForm:cadastrar")).click();
        Alert alert = driver.switchTo().alert();
        Assertions.assertEquals("Voce faz esporte ou nao?",alert.getText());
    }


}
