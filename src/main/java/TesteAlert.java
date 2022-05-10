import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

import static camilo.antonio.core.DriveFactory.getDriver;

public class TesteAlert extends BaseTest{

    @Test
    public void deveInteragirComAlertSimples() {
        getDriver().findElement(By.id("alert")).click();
        Alert alert = getDriver().switchTo().alert();
        String texto = alert.getText();
        Assertions.assertEquals("Alert Simples", texto);
        alert.accept();
        getDriver().findElement(By.id("elementosForm:nome")).sendKeys(texto);
    }

    @Test
    public void deveInteragirComAlertConfirm() {
        getDriver().findElement(By.id("confirm")).click();
        Alert alert = getDriver().switchTo().alert();
        String texto = alert.getText();
        Assertions.assertEquals("Confirm Simples", texto);
        alert.accept();
        texto = alert.getText();
        Assertions.assertEquals("Confirmado", texto);
        alert.accept();


        getDriver().findElement(By.id("confirm")).click();
        alert = getDriver().switchTo().alert();
        texto = alert.getText();
        Assertions.assertEquals("Confirm Simples", texto);
        alert.dismiss();
        texto = alert.getText();
        Assertions.assertEquals("Negado", texto);
        alert.accept();
    }
    @Test
    public void deveInteragirComPrompt(){
        getDriver().findElement(By.id("prompt")).click();
        Alert alert = getDriver().switchTo().alert();
        Assertions.assertEquals("Digite um numero",alert.getText());
        alert.sendKeys("5");
        alert.accept();
        Assertions.assertEquals("Era 5?",alert.getText());
        alert.accept();
        Assertions.assertEquals(":D",alert.getText());
    }
}
