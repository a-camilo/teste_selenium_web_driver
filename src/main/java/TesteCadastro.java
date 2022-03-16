import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TesteCadastro {

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
    public void cadastro() {
        driver.findElement(By.id("elementosForm:nome")).sendKeys("Antonio");
        driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Santos");
        driver.findElement(By.id("elementosForm:sexo:0")).click();
        driver.findElement(By.id("elementosForm:comidaFavorita:2")).click();

        // First version of Select
        new Select(driver.findElement(By.id("elementosForm:escolaridade")))
                .selectByVisibleText("Superior");

        // Second version
        Select esporte = new Select(driver.findElement(By.id("elementosForm:esportes")));
        esporte.selectByVisibleText("Natacao");
        esporte.selectByVisibleText("Futebol");

        driver.findElement(By.id("elementosForm:sugestoes")).sendKeys("Testando....");
        driver.findElement(By.id("elementosForm:cadastrar")).click();


        Assertions.assertTrue(driver.findElement(By.id("resultado")).getText().startsWith("Cadastrado!"));
        Assertions.assertEquals("Nome: Antonio", driver.findElement(By.id("descNome")).getText());
        Assertions.assertEquals("Sobrenome: Santos", driver.findElement(By.id("descSobrenome")).getText());
        Assertions.assertEquals("Sexo: Masculino", driver.findElement(By.id("descSexo")).getText());
        Assertions.assertEquals("Comida: Pizza", driver.findElement(By.id("descComida")).getText());
        Assertions.assertEquals("Escolaridade: superior", driver.findElement(By.id("descEscolaridade")).getText());
        Assertions.assertEquals("Esportes: Natacao Futebol", driver.findElement(By.id("descEsportes")).getText());


    }


}
