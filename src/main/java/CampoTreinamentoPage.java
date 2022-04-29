import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CampoTreinamentoPage extends BaseTest{
    public DSL dsl;

    public CampoTreinamentoPage(WebDriver driver) {
        dsl = new DSL(driver);
    }

    public void setNome(String nome) {
        dsl.escreve(By.id("elementosForm:nome"), nome);
    }

    public void setSobrenome(String sobrenome) {
        dsl.escreve(By.id("elementosForm:sobrenome"), sobrenome);
    }

    public void setSexoMasculino() {
        dsl.clicarRadio("elementosForm:sexo:0");
    }

    public void setSexoFeminino() {
        dsl.clicarRadio("elementosForm:sexo:1");
    }

    public void setComidaFavoritaCarne() {
        dsl.clicarRadio("elementosForm:comidaFavorita:0");
    }

    public void setComidaFavoritaFrango() {
        dsl.clicarRadio("elementosForm:comidaFavorita:1");
    }

    public void setComidaFavoritaPizza() {
        dsl.clicarRadio("elementosForm:comidaFavorita:2");
    }

    public void setComidaFavoritaVegetariano() {
        dsl.clicarRadio("elementosForm:comidaFavorita:3");
    }

    public void setEscolaridade(String valor) {
        dsl.selecionarCombo("elementosForm:escolaridade", valor);
    }

    public void setEsporte(String valor) {
        dsl.selecionarCombo("elementosForm:esportes", valor);
    }

    public void setCampoSugestao() {
        dsl.obterTexto("elementosForm:sugestoes");
    }

    public void botaoCadastrar() {
        dsl.botao("elementosForm:cadastrar");
    }

    public String obterResultadoCadastro() {
        return dsl.obterTexto("resultado");
    }

    public String obterEsporteCadastro() {
        return dsl.obterTexto("descEsportes");
    }

    public String obterEscolaridadeCadastro() {
        return dsl.obterTexto("descEscolaridade");
    }

    public String obterComidaCadastro() {
        return dsl.obterTexto("descComida");
    }

    public String obterSexoCadastro() {
        return dsl.obterTexto("descSexo");
    }

    public String obterSobrenomeCadastro() {
        return dsl.obterTexto("descSobrenome");
    }

    public String obterNomeCadastro() {
        return dsl.obterTexto("descNome");
    }
}
