package camilo.antonio.test;

import camilo.antonio.core.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static camilo.antonio.core.DriveFactory.getDriver;

public class TesteFramesEJanelas extends BaseTest {

    @Test
    public void deveInteragirComFrames() {
        getDriver().switchTo().frame("frame1");
        getDriver().findElement(By.id("frameButton")).click();

        Alert alert = getDriver().switchTo().alert();
        String msg = alert.getText();
        Assert.assertEquals("Frame OK!", msg);
        alert.accept();

        getDriver().switchTo().defaultContent();
        getDriver().findElement(By.id("elementosForm:nome")).sendKeys(msg);
    }

    @Test
    public void deveInteragirComFrameEscondido(){

        WebElement frame = getDriver().findElement(By.id("frame2"));
        dsl.executarJS("window.scrollBy(0,arguments[0])",frame.getLocation().y);
        dsl.acessarFrame("frame2");
        dsl.botao("frameButton");
        dsl.alertSwitch();
    }

    @Test
    public void deveInteragirComJanelas() {
        dsl.botao("buttonPopUpEasy");
        dsl.trocarJanela("Popup");
        dsl.escreve(By.tagName("textarea"),"Teste Popup");
        getDriver().close();
        dsl.trocarJanela("");
        dsl.escreve(By.tagName("textarea"),"Eh agora?");
    }

    @Test
    public void deveInteragirComJanelasSemTitulo() {
        dsl.botao("buttonPopUpHard");
        getDriver().switchTo().window((String) getDriver().getWindowHandles().toArray()[1]);
        getDriver().findElement(By.tagName("textarea")).sendKeys("Conseguiu?");
        getDriver().switchTo().window((String) getDriver().getWindowHandles().toArray()[0]);
    }
}
