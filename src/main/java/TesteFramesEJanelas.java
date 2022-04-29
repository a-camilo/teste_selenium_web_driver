import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TesteFramesEJanelas extends BaseTest{

    @Test
    public void deveInteragirComFrames() {
        driver.switchTo().frame("frame1");
        driver.findElement(By.id("frameButton")).click();

        Alert alert = driver.switchTo().alert();
        String msg = alert.getText();
        Assert.assertEquals("Frame OK!", msg);
        alert.accept();

        driver.switchTo().defaultContent();
        driver.findElement(By.id("elementosForm:nome")).sendKeys(msg);
    }

    @Test
    public void deveInteragirComFrameEscondido(){

        WebElement frame = driver.findElement(By.id("frame2"));
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
        driver.close();
        dsl.trocarJanela("");
        dsl.escreve(By.tagName("textarea"),"Eh agora?");
    }

    @Test
    public void deveInteragirComJanelasSemTitulo() {
        dsl.botao("buttonPopUpHard");
        driver.switchTo().window((String) driver.getWindowHandles().toArray()[1]);
        driver.findElement(By.tagName("textarea")).sendKeys("Conseguiu?");
        driver.switchTo().window((String) driver.getWindowHandles().toArray()[0]);
    }
}
