import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteCadastro {

    private WebDriver driver;
    private CampoTreinamentoPage page;

    @Before
    public void inicializa() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("file:///C:/Users/AntonioCamiloGomesdo/Desktop/componentes.html");
        page = new CampoTreinamentoPage(driver);
    }

    @After
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

        Assert.assertTrue(page.obterResultadoCadastro().startsWith("Cadastrado!"));
        Assert.assertEquals("Nome: Antonio", page.obterNomeCadastro());
        Assert.assertEquals("Sobrenome: Santos", page.obterSobrenomeCadastro());
        Assert.assertEquals("Sexo: Masculino", page.obterSexoCadastro());
        Assert.assertEquals("Comida: Pizza", page.obterComidaCadastro());
        Assert.assertEquals("Escolaridade: superior", page.obterEscolaridadeCadastro());
        Assert.assertEquals("Esportes: Natacao Futebol", page.obterEsporteCadastro());
    }
}
