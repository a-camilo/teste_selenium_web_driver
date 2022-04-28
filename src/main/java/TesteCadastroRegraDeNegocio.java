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
    CampoTreinamentoPage page;


    @BeforeEach
    public void inicializa() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("file:///C:/Users/AntonioCamiloGomesdo/Desktop/componentes.html");
        page = new CampoTreinamentoPage(driver);
    }

    @AfterEach
    public void finaliza() throws InterruptedException {
        Thread.sleep(1000);
        driver.quit();
    }

    @Test
    public void deveValidarNomeObrigatorio() {
        page.botaoCadastrar();
        Alert alert = driver.switchTo().alert();
        Assertions.assertEquals("Nome eh obrigatorio", alert.getText());
        alert.accept();
    }

    @Test
    public void deveValidarSobrenomeObrigtorio() {
        page.setNome(" seu nome ");
        page.botaoCadastrar();
        Alert alert = driver.switchTo().alert();
        Assertions.assertEquals("Sobrenome eh obrigatorio", alert.getText());
        alert.accept();
    }

    @Test
    public void deveValidarSexo() {
        page.setNome("seu nome");
        page.setSobrenome("seu sobrenome");
        page.botaoCadastrar();
        Alert alert = driver.switchTo().alert();
        Assertions.assertEquals("Sexo eh obrigatorio", alert.getText());
    }

    @Test
    public void deveValidarComidaVegetariana() {
        page.setNome("seu nome");
        page.setSobrenome("seu sobrenome");
        page.setSexoMasculino();
        page.setComidaFavoritaCarne();
        page.setComidaFavoritaVegetariano();
        page.botaoCadastrar();
        Alert alert = driver.switchTo().alert();
        Assertions.assertEquals("Tem certeza que voce eh vegetariano?", alert.getText());
    }

    @Test
    public void deveValidarEsportistaIndeciso() {
        page.setNome("seu nome");
        page.setSobrenome(" seu sobrenome");
        page.setSexoMasculino();
        page.setComidaFavoritaCarne();
        new Select(driver.findElement(By.id("elementosForm:esportes"))).selectByVisibleText("Natacao");
        new Select(driver.findElement(By.id("elementosForm:esportes"))).selectByVisibleText("O que eh esporte?");
        page.botaoCadastrar();
        Alert alert = driver.switchTo().alert();
        Assertions.assertEquals("Voce faz esporte ou nao?",alert.getText());
    }


}
