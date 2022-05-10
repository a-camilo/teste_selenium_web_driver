package camilo.antonio.core;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static camilo.antonio.core.DriveFactory.getDriver;

public class DSL {

    public void escreve(By by, String texto) {
        getDriver().findElement(by).clear();
        getDriver().findElement(by).sendKeys(texto);
    }

    public String obterValorCampo(String id_campo) {
        return getDriver().findElement(By.id(id_campo)).getAttribute("value");

    }

    public void clicarRadio(By by) {
        getDriver().findElement(by).click();
    }

    public void clicarRadio(String id) {
        getDriver().findElement(By.id(id)).click();
    }

    public void clicarBotao(String botao) {
        getDriver().findElement(By.id(botao)).click();
    }

    public boolean isRadioSelected(String id) {
        return getDriver().findElement(By.id(id)).isSelected();
    }

    public void selecionarCombo(String id, String valor) {
        WebElement element = getDriver().findElement(By.id(id));
        Select combo = new Select(element);
        combo.selectByVisibleText(valor);
    }

    public String obterValorCombo(String id) {
        WebElement element = getDriver().findElement(By.id(id));
        Select combo = new Select(element);
        return combo.getFirstSelectedOption().getText();
    }

    public void botao(String id) {
        getDriver().findElement(By.id(id)).click();
    }

    public void link(String link) {
        getDriver().findElement(By.linkText(link)).click();
    }

    public String obterTexto(By by) {
        return getDriver().findElement((by)).getText();
    }

    public String obterTexto(String id) {
        return obterTexto(By.id(id));
    }

    public String alertaObterTextoAceita(String id) {
        return obterTexto(By.id(id));
    }

    //*********** JS **********************
    public Object executarJS(String cmd, Object... param) {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        return js.executeScript(cmd, param);
    }

    public void alertSwitch() {
        Alert alert = getDriver().switchTo().alert();
        alert.accept();
    }

    //**************JavaScript*****************
    public WebDriver acessarFrame(String frame) {
        return getDriver().switchTo().frame(frame);
    }

    public WebDriver trocarJanela(String janela) {
        return getDriver().switchTo().window(janela);
    }

    //**************Tabela*****************

    public void clicarBotaoTabela(String colunaBusca, String valor, String colunaBotao, String idTable) {
        WebElement tabela = getDriver().findElement(By.xpath("//*[@id='elementosForm:tableUsuarios']"));
        int idColuna = ObterIndiceColuna(colunaBusca, tabela);

        int idLInha = obterIndiceLinha(valor, tabela, idColuna);

        int idColunaBotao = ObterIndiceColuna(colunaBotao, tabela);

        WebElement celula = tabela.findElement(By.xpath(".//tr[" + idLInha + "]/td[" + idColunaBotao + "]"));
        celula.findElement(By.xpath(".//input")).click();
    }

    protected int obterIndiceLinha(String valor, WebElement tabela, int idColuna) {
        List<WebElement> linhas = tabela.findElements(By.xpath("./tbody/tr/td[" + idColuna + "]"));
        int idLinha = -1;
        for (int i = 0; i < linhas.size(); i++) {
            if (linhas.get(i).getText().equals(valor)) {
                idLinha = i + 1;
                break;
            }
        }
        return idLinha;
    }

    protected int ObterIndiceColuna(String coluna, WebElement tabela) {
        List<WebElement> colunas = tabela.findElements(By.xpath(".//th"));
        int idColuna = -1;
        for (int i = 0; i < colunas.size(); i++) {
            if (colunas.get(i).getText().equals(coluna)) {
                idColuna = i + 1;
                break;
            }
        }
        return idColuna;
    }

    public void selecionarComboPrime(String radical, String valor) {
        clicarRadio(By.xpath("//*[@id='" + radical + "_input']/../..//span"));
        clicarRadio(By.xpath("//*[@id='" + radical + "_items']//li[.='" + valor + "']"));
    }

}
