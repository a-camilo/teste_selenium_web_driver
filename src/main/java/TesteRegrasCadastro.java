import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@RunWith(Parameterized.class)
public class TesteRegrasCadastro extends BaseTest{

    @Parameter
    public String nome;
    @Parameter(value = 1)
    public String sobrenome;
    @Parameter(value = 2)
    public String sexo;
    @Parameter(value = 3)
    public List<String> comidas;
    @Parameter(value = 4)
    public String[] esportes;
    @Parameter(value = 5)
    public String msg;

    @Parameters
    public static Collection<Object[]> getCollection() {
        return Arrays.asList(new Object[][]{
                {"nome", "sobrenome", "Masculino", List.of("Pizza"), new String[]{}, "Nome eh obrigatorio"},
//                {"Wagner", "", "",  Arrays.asList(), new String[]{}, "Sobrenome eh obrigatorio"},
//                {"Wagner", "Costa", "",  Arrays.asList(), new String[]{}, "Sexo eh obrigatorio"},
//                {"Wagner", "Costa", "Masculino",  Arrays.asList("Carne", "Vegetariano"), new String[]{}, "Tem certeza que voce eh vegetariano?"},
//                {"Wagner", "Costa", "Masculino",  Arrays.asList("Carne"), new String[]{"Karate", "O que eh esporte?"}, "Voce faz esporte ou nao?"}
        });
    }

    @Test
    public void deveValidarRegras() {
        page.setNome(nome);
        page.setSobrenome(sobrenome);
        if (sexo.equals("Masculino")) {
            page.setSexoMasculino();
        }
        if (sexo.equals("Feminino")) {
            page.setSexoFeminino();
        }
        if (comidas.contains("Carne")) page.setComidaFavoritaCarne();
        if (comidas.contains("Pizza")) page.setComidaFavoritaPizza();
        if (comidas.contains("Vegetariano")) page.setComidaFavoritaVegetariano();
        page.setEsporte(Arrays.toString(esportes));
//        page.botaoCadastrar();
        System.out.println(msg);
        Assert.assertEquals(msg, dsl.alertaObterTextoAceita(msg));
    }
}
