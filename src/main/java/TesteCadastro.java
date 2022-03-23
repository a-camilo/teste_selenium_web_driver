import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteCadastro {

    private WebDriver driver;
    private CampoTreinamentoPage page;

    @BeforeEach
    public void inicializa() {
        System.setProperty("webdriver.chrome.driver", "C:/Users/AntonioCamiloGomesdo/drivers/chromedriver.exe");
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
        Assertions.assertEquals("Nome: Antonio", page.obterNomeCadastro());
        Assertions.assertEquals("Sobrenome: Santos", page.obterSobrenomeCadastro());
        Assertions.assertEquals("Sexo: Masculino", page.obterSexoCadastro());
        Assertions.assertEquals("Comida: Pizza", page.obterComidaCadastro());
        Assertions.assertEquals("Escolaridade: superior", page.obterEscolaridadeCadastro());
        Assertions.assertEquals("Esportes: Natacao Futebol", page.obterEsporteCadastro());
    }
}
