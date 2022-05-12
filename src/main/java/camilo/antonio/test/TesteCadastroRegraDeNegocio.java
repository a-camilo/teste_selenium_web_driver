package camilo.antonio.test;

import camilo.antonio.core.BaseTest;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import static camilo.antonio.core.DriveFactory.getDriver;

public class TesteCadastroRegraDeNegocio extends BaseTest {
    @Test
    public void deveValidarNomeObrigatorio() {
        page.botaoCadastrar();
        Alert alert = getDriver().switchTo().alert();
        Assertions.assertEquals("Nome eh obrigatorio", alert.getText());
        alert.accept();
    }

    @Test
    public void deveValidarSobrenomeObrigtorio() {
        page.setNome(" seu nome ");
        page.botaoCadastrar();
        Alert alert = getDriver().switchTo().alert();
        Assertions.assertEquals("Sobrenome eh obrigatorio", alert.getText());
        alert.accept();
    }

    @Test
    public void deveValidarSexo() {
        page.setNome("seu nome");
        page.setSobrenome("seu sobrenome");
        page.botaoCadastrar();
        Alert alert = getDriver().switchTo().alert();
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
        Alert alert = getDriver().switchTo().alert();
        Assertions.assertEquals("Tem certeza que voce eh vegetariano?", alert.getText());
    }

    @Test
    public void deveValidarEsportistaIndeciso() {
        page.setNome("seu nome");
        page.setSobrenome(" seu sobrenome");
        page.setSexoMasculino();
        page.setComidaFavoritaCarne();
        new Select(getDriver().findElement(By.id("elementosForm:esportes"))).selectByVisibleText("Natacao");
        new Select(getDriver().findElement(By.id("elementosForm:esportes"))).selectByVisibleText("O que eh esporte?");
        page.botaoCadastrar();
        Alert alert = getDriver().switchTo().alert();
        Assertions.assertEquals("Voce faz esporte ou nao?",alert.getText());
    }


}
