import org.junit.jupiter.api.AfterEach;
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

    @BeforeEach
    public void inicializa() {
        System.setProperty("webdriver.chrome.driver", "C:/Users/AntonioCamiloGomesdo/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("file:///C:/Users/AntonioCamiloGomesdo/Desktop/componentes.html");
    }

    @AfterEach
    public void finaliza() {
        driver.quit();
    }

    @Test
    public void testeTextField() {
        driver.findElement(By.id("elementosForm:nome")).sendKeys("Teste");
        assertEquals("Teste", driver.findElement(By.id("elementosForm:nome")).getAttribute("value"));
    }

    @Test
    public void deveInteragirTextArea() {
        driver.findElement(By.id("elementosForm:sugestoes")).sendKeys("Teste");
        assertEquals("Teste", driver.findElement(By.id("elementosForm:sugestoes")).getAttribute("value"));
    }
    @Test
    public void deveInteragirRadioButton(){
        driver.findElement(By.id("elementosForm:sexo:0")).click();
        assertTrue(driver.findElement(By.id("elementosForm:sexo:0")).isSelected());
    }
    @Test
    public void deveInteragirComCheckBox(){
        driver.findElement(By.id("elementosForm:sexo:0")).click();
        assertTrue(driver.findElement(By.id("elementosForm:comidaFavorita:0")).isEnabled());
    }
    @Test
    public void deveVerificarValoresCombo(){
        WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
        Select combo = new Select(element);
        combo.selectByVisibleText("2o grau incompleto");
        assertEquals("2o grau incompleto",combo.getFirstSelectedOption().getText());
        List<WebElement> options = combo.getOptions();
        assertEquals(8,options.size());
        boolean encontrou = false;
        for (WebElement option: options) {
            if (option.getText().equals("Mestrado")){
                encontrou = true;
                break;
            }
        }
        assertTrue(encontrou);
    }

    @Test
    public void deveVerificarValoresComboMultiplo() {
        WebElement element = driver.findElement(By.id("elementosForm:esportes"));
        Select combo = new Select(element);
        combo.selectByVisibleText("Natacao");
        assertEquals("Natacao",combo.getFirstSelectedOption().getText());

    }

    @Test
    public void deveINteragirComBotoes(){
        WebElement botao = driver.findElement(By.id("buttonSimple"));
        botao.click();
        assertEquals("Obrigado!",botao.getAttribute("value"));
    }
}
