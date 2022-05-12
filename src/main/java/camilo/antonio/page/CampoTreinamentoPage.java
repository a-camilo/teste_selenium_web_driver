package camilo.antonio.page;

import camilo.antonio.core.BasePage;
import org.openqa.selenium.By;

public class CampoTreinamentoPage extends BasePage {


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

        return dsl.obterTexto(By.xpath("//*[@id='resultado']/span"));
    }

    public String obterEsporteCadastro() {
        return dsl.obterTexto(By.xpath("//*[@id='descEsportes']/span"));
    }

    public String obterEscolaridadeCadastro() {

        return dsl.obterTexto(By.xpath("//*[@id='descEscolaridade']/span"));
    }

    public String obterComidaCadastro() {

        return dsl.obterTexto(By.xpath("//*[@id='descComida']/span"));
    }

    public String obterSexoCadastro() {

        return dsl.obterTexto(By.xpath("//*[@id='descSexo']/span"));
    }

    public String obterSobrenomeCadastro() {

        return dsl.obterTexto(By.xpath("//*[@id='descSobrenome']/span"));
    }

    public String obterNomeCadastro() {

        return dsl.obterTexto(By.xpath("//*[@id='descNome']/span"));
    }
}
