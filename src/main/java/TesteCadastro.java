import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteCadastro {

    private WebDriver driver;
    private DSL dsl;
    private CampoTreinamentoPage page;

    @BeforeEach
    public void inicializa() {
        System.setProperty("webdriver.chrome.driver", "C:/Users/AntonioCamiloGomesdo/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("file:///C:/Users/AntonioCamiloGomesdo/Desktop/componentes.html");
        dsl = new DSL(driver);
        page = new CampoTreinamentoPage(driver);
    }

    @AfterEach
    public void finaliza() throws InterruptedException {
        Thread.sleep(1000);
        driver.quit();
    }

    @Test
    public void deveRealizarCadastroComSucesso() {
        page.setNome("Antonio");
        page.setSobrenome("Santos");
        page.setSexoMasculino();
        page.setComidaFavoritaPizza();
        page.setEscolaridade("Superior");
        page.setEsporte("Natacao");
        page.setEsporte("Futebol");
        page.setCampoSugestao();
        page.botaoCadastrar();

        Assertions.assertTrue(page.obterResultadoCadastro().startsWith("Cadastrado!"));
        Assertions.assertEquals("Nome: Antonio", driver.findElement(By.id("descNome")).getText());
        Assertions.assertEquals("Sobrenome: Santos", driver.findElement(By.id("descSobrenome")).getText());
        Assertions.assertEquals("Sexo: Masculino", driver.findElement(By.id("descSexo")).getText());
        Assertions.assertEquals("Comida: Pizza", driver.findElement(By.id("descComida")).getText());
        Assertions.assertEquals("Escolaridade: superior", driver.findElement(By.id("descEscolaridade")).getText());
        Assertions.assertEquals("Esportes: Natacao Futebol", driver.findElement(By.id("descEsportes")).getText());
    }
}
