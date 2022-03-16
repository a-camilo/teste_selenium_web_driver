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

    @BeforeEach
    public void inicializa() {
        System.setProperty("webdriver.chrome.driver", "C:/Users/AntonioCamiloGomesdo/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("file:///C:/Users/AntonioCamiloGomesdo/Desktop/componentes.html");
        dsl = new DSL(driver);
    }

    @AfterEach
    public void finaliza() throws InterruptedException {
        Thread.sleep(1000);
        driver.quit();
    }

    @Test
    public void deveRealizarCadastroComSucesso() {
        dsl.escreve("elementosForm:nome", "Antonio");
        dsl.escreve("elementosForm:sobrenome", "Santos");
        dsl.clicarRadio("elementosForm:sexo:0");
        dsl.clicarRadio("elementosForm:comidaFavorita:2");
        dsl.selecionarCombo("elementosForm:escolaridade", "Superior");
        dsl.selecionarCombo("elementosForm:esportes", "Natacao");
        dsl.selecionarCombo("elementosForm:esportes", "Futebol");
        dsl.obterTexto("elementosForm:sugestoes");
        dsl.botao("elementosForm:cadastrar");

        Assertions.assertTrue(driver.findElement(By.id("resultado")).getText().startsWith("Cadastrado!"));
        Assertions.assertEquals("Nome: Antonio", driver.findElement(By.id("descNome")).getText());
        Assertions.assertEquals("Sobrenome: Santos", driver.findElement(By.id("descSobrenome")).getText());
        Assertions.assertEquals("Sexo: Masculino", driver.findElement(By.id("descSexo")).getText());
        Assertions.assertEquals("Comida: Pizza", driver.findElement(By.id("descComida")).getText());
        Assertions.assertEquals("Escolaridade: superior", driver.findElement(By.id("descEscolaridade")).getText());
        Assertions.assertEquals("Esportes: Natacao Futebol", driver.findElement(By.id("descEsportes")).getText());
    }
}
