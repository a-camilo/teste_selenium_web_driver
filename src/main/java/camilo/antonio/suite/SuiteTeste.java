package camilo.antonio.suite;

import camilo.antonio.test.*;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import static camilo.antonio.core.DriveFactory.killDriver;

@RunWith(Suite.class)
@Suite.SuiteClasses({

        TesteAjax.class,
        TesteCadastro.class,
        TesteCampoTreinamento.class,
        TesteFramesEJanelas.class,
        TesteGoogle.class,
        TesteSincronismo.class

})
public class SuiteTeste {

    @AfterClass
    public static void finalizaTudo(){
        killDriver();
    }

}
