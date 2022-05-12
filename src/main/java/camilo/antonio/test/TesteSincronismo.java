package camilo.antonio.test;

import camilo.antonio.core.BaseTest;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static camilo.antonio.core.DriveFactory.getDriver;

public class TesteSincronismo extends BaseTest {
    @Test
    public void deveUtilizarEsperaFixa() throws InterruptedException {
        dsl.clicarBotao("buttonDelay");
        Thread.sleep(5000);
        dsl.escreve(By.id("novoCampo"), "deu certo");
    }

    @Test
    public void deveUtilizarEsperaImplicita() {
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
        dsl.clicarBotao("buttonDelay");
        dsl.escreve(By.id("novoCampo"), "deu certo");
    }

    @Test
    public void deveUtilizarEsperaExlicita() {

        dsl.clicarBotao("buttonDelay");
        WebDriverWait wait = new WebDriverWait(getDriver(),Duration.ofSeconds(30));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("novoCampo")));
        dsl.escreve(By.id("novoCampo"), "deu certo");
    }
}
