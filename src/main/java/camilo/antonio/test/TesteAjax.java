package camilo.antonio.test;

import camilo.antonio.core.DSL;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static camilo.antonio.core.DriveFactory.getDriver;
import static camilo.antonio.core.DriveFactory.killDriver;

public class TesteAjax {

    private DSL dsl;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        dsl = new DSL();
    }

    @After
    public void setDown() {
        killDriver();
    }

    @Test
    public void testwAjax(){
        getDriver().get("https://www.primefaces.org/showcase/ui/ajax/basic.xhtml?jfwid=a1023");
        dsl.escreve(By.id("j_idt311:name"),"Teste");
        dsl.clicarBotao("j_idt311:j_idt315");
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(8));
        wait.until(ExpectedConditions.textToBe(By.id("j_idt311:display"),"Teste"));
        Assert.assertEquals("Teste",dsl.obterTexto("j_idt311:display"));

    }
}
