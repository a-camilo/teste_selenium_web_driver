package camilo.antonio.test;

import camilo.antonio.core.BaseTest;
import org.junit.Assert;
import org.junit.Test;

public class TesteCadastro extends BaseTest {


    @Test
    public void deveRealizarCadastroComSucesso() {
        page.setNome("Antonio");
        page.setSobrenome("Santos");
        page.setSexoMasculino();
        page.setComidaFavoritaPizza();
        page.setEscolaridade("Superior");
        page.setEsporte("Natacao");
        page.setEsporte("Futebol");
        page.setCampoSugestao();
        page.botaoCadastrar();

        Assert.assertEquals("Cadastrado!",page.obterResultadoCadastro());
        Assert.assertEquals("Antonio", page.obterNomeCadastro());
        Assert.assertEquals("Santos", page.obterSobrenomeCadastro());
        Assert.assertEquals("Masculino", page.obterSexoCadastro());
        Assert.assertEquals("Pizza", page.obterComidaCadastro());
        Assert.assertEquals("superior", page.obterEscolaridadeCadastro());
        Assert.assertEquals("Natacao Futebol", page.obterEsporteCadastro());
    }
}
