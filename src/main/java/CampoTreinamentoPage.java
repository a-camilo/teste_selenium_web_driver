import org.openqa.selenium.WebDriver;

public class CampoTreinamentoPage {
    private DSL dsl;

    public CampoTreinamentoPage(WebDriver driver) {
        dsl = new DSL(driver);
    }

    public void setNome(String nome){
        dsl.escreve("elementosForm:nome",nome);
    }

    public void setSobrenome(String sobrenome) {
        dsl.escreve("elementosForm:sobrenome",sobrenome);
    }

    public void setSexoMasculino() {
        dsl.clicarRadio("elementosForm:sexo:0");
    }

    public void setSexoFeminio() {
        dsl.clicarRadio("elementosForm:sexo:1");
    }

    public void setComidaFavoritaCarne(){
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

    public void setEscolaridade(String valor){
        dsl.selecionarCombo("elementosForm:escolaridade", valor);
    }

    public void setEsporte(String valor) {
        dsl.selecionarCombo("elementosForm:esportes",valor );
    }

    public void setCampoSugestao() {
        dsl.obterTexto("elementosForm:sugestoes");
    }

    public void botaoCadastrar() {
        dsl.botao("elementosForm:cadastrar");
    }
}
