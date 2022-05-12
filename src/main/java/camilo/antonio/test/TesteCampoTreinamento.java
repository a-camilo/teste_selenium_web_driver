package camilo.antonio.test;

import camilo.antonio.core.BaseTest;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static camilo.antonio.core.DriveFactory.getDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TesteCampoTreinamento extends BaseTest {

    @Test
    public void testeTextField() {
        dsl.escreve(By.id("elementosForm:nome"), "Teste");
        Assertions.assertEquals("Teste", dsl.obterValorCampo("elementosForm:nome"));
    }

    @Test
    public void textFieldDuplo() {

        dsl.escreve(By.id("elementosForm:nome"), "Wagner");
        Assertions.assertEquals("Wagner", dsl.obterValorCampo("elementosForm:nome"));
        dsl.escreve(By.id("elementosForm:nome"), "Aquino");
        Assertions.assertEquals("Aquino", dsl.obterValorCampo("elementosForm:nome"));
    }

    @Test
    public void deveInteragirTextArea() {
        dsl.escreve(By.id("elementosForm:sugestoes"), "Testando a text area");
        Assertions.assertEquals("Testando a text area", dsl.obterValorCampo("elementosForm:sugestoes"));
    }

    @Test
    public void deveInteragirRadioButton() {
        dsl.clicarRadio("elementosForm:sexo:1");
        Assertions.assertTrue(dsl.isRadioSelected("elementosForm:sexo:1"));
    }

    @Test
    public void deveInteragirComCheckBox() {
        getDriver().findElement(By.id("elementosForm:comidaFavorita:0")).click();
        assertTrue(getDriver().findElement(By.id("elementosForm:comidaFavorita:0")).isEnabled());
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
        WebElement element = getDriver().findElement(By.id("elementosForm:esportes"));
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
        WebElement botao = getDriver().findElement(By.id("buttonSimple"));
        assertEquals("Obrigado!", botao.getAttribute("value"));
    }

    @Test
    public void deveInteragirComLink() {
        dsl.link("Voltar");
        Assertions.assertEquals("Voltou!", dsl.obterTexto("resultado"));
    }

    @Test
    public void deveProcurarTextoNaPagina() {
        Assertions.assertEquals("Campo de Treinamento", dsl.obterTexto(By.tagName("h3")));
    }

    @Test
    public void testJavaScript() {
        dsl.executarJS("document.getElementById('elementosForm:nome').value =  'Escrito via JS'");
        dsl.executarJS("document.getElementById('elementosForm:sobrenome').type = 'radio'");
        WebElement element = getDriver().findElement(By.id("elementosForm:nome"));
        dsl.executarJS("arguments[0].style.border = arguments[1]", element, "solid 4px red");
        dsl.executarJS("alert('Testando JS via Selenium')");
        dsl.alertSwitch();
    }
}
