import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({

        TesteAlert.class,
        TesteCadastro.class,
        TesteCadastroRegraDeNegocio.class,
        TesteCampoTreinamento.class,
        TesteFramesEJanelas.class,
        TesteGoogle.class,
        TesteXpath.class
})
public class SuiteTeste {


}
