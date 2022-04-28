import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

public class DSL {

    private WebDriver driver;

    public DSL(WebDriver driver) {
        this.driver = driver;
    }

    public void escreve(By by, String texto) {
        driver.findElement(by).clear();
        driver.findElement(by).sendKeys(texto);
    }

    public String obterValorCampo(String id_campo) {
        return driver.findElement(By.id(id_campo)).getAttribute("value");

    }

    public void clicarRadio(String id) {
        driver.findElement(By.id(id)).click();
    }

    public boolean isRadioSelected(String id) {
        return driver.findElement(By.id(id)).isSelected();
    }

    public void selecionarCombo(String id, String valor) {
        WebElement element = driver.findElement(By.id(id));
        Select combo = new Select(element);
        combo.selectByVisibleText(valor);
    }

    public String obterValorCombo(String id) {
        WebElement element = driver.findElement(By.id(id));
        Select combo = new Select(element);
        return combo.getFirstSelectedOption().getText();
    }

    public void botao(String id) {
        driver.findElement(By.id(id)).click();
    }

    public void link(String link) {
        driver.findElement(By.linkText(link)).click();
    }

    public String obterTexto(By by) {
        return driver.findElement((by)).getText();
    }

    public String obterTexto(String id) {
        return obterTexto(By.id(id));
    }

    public String alertaObterTextoAceita(String id) {
        return obterTexto(By.id(id));
    }

    //*********** JS **********************
    public Object executarJS(String cmd, Object... param) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return js.executeScript(cmd, param);
    }

    public void alertSwitch() {
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    public WebDriver acessarFrame(String frame){
        return driver.switchTo().frame(frame);
    }

    public WebDriver trocarJanela(String janela) {
        return driver.switchTo().window(janela);
    }
}
