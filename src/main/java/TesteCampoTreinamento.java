import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TesteCampoTreinamento {

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
    public void finaliza() {
        driver.quit();
    }

    @Test
    public void testeTextField() {
        dsl.escreve(By.id("elementosForm:nome"), "Teste");
        assertEquals("Teste", dsl.obterValorCampo("elementosForm:nome"));
    }
    @Test
    public void textFieldDuplo(){
        dsl.escreve(By.id("elementosForm:nome"),"Wagner");
        Assertions.assertEquals("Wagner",dsl.obterValorCampo("elementosForm:nome"));
        dsl.escreve(By.id("elementosForm:nome"),"Aquino");
        Assertions.assertEquals("Aquino",dsl.obterValorCampo("elementosForm:nome"));
    }
    @Test
    public void deveInteragirTextArea() {
        dsl.escreve(By.id("elementosForm:sugestoes"), "Testando a text area");
        assertEquals("Testando a text area", dsl.obterValorCampo("elementosForm:sugestoes"));
    }

    @Test
    public void deveInteragirRadioButton() {
        dsl.clicarRadio("elementosForm:sexo:0");
        assertTrue(driver.findElement(By.id("elementosForm:sexo:0")).isSelected());
        assertTrue  (dsl.isRadioSelected("elementosForm:sexo:0"));
    }

    @Test
    public void deveInteragirComCheckBox() {
        driver.findElement(By.id("elementosForm:sexo:0")).click();
        assertTrue(driver.findElement(By.id("elementosForm:comidaFavorita:0")).isEnabled());
    }

    @Test
    public void deveInteragirComCombo() {
        dsl.selecionarCombo("elementosForm:escolaridade", "2o grau completo");
        Assertions.assertEquals("2o grau completo", dsl.obterValorCombo("elementosForm:escolaridade"));
    }

    @Test
    public void deveVerificarValoresComboMultiplo() {
        dsl.selecionarCombo("elementosForm:esportes", "Natacao");
        dsl.selecionarCombo("elementosForm:esportes", "Futebol");
        dsl.selecionarCombo("elementosForm:esportes", "Karate");
        WebElement element = driver.findElement(By.id("elementosForm:esportes"));
        Select combo = new Select(element);

        List<WebElement> allSelectedOptions = combo.getAllSelectedOptions();
        Assertions.assertEquals(3, allSelectedOptions.size());
        combo.deselectByVisibleText("Futebol");
        allSelectedOptions = combo.getAllSelectedOptions();
        assertEquals(2, allSelectedOptions.size());
    }

    @Test
    public void deveInteragirComBotoes() {
        dsl.botao("buttonSimple");
        WebElement botao = driver.findElement(By.id("buttonSimple"));
        assertEquals("Obrigado!", botao.getAttribute("value"));
    }

    @Test
    public void deveInteragirComLink() {
        dsl.link("Voltar");
        assertEquals("Voltou!", dsl.obterTexto("resultado"));
    }

    @Test
    public void deveProcurarTextoNaPagina() {
        assertEquals("Campo de Treinamento", dsl.obterTexto(By.tagName("h3")));
    }
}
