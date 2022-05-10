import camilo.antonio.core.DSL;
import camilo.antonio.core.DriveFactory;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseTest {

    public DSL dsl;

    public CampoTreinamentoPage page;

    @Before
    public void inicializa() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        DriveFactory.getDriver().get("file:///C:/Users/AntonioCamiloGomesdo/Desktop/componentes.html");
        dsl = new DSL();
        page = new CampoTreinamentoPage();

    }

    @After
    public void finaliza() throws InterruptedException {
        Thread.sleep(2000);
        DriveFactory.killDriver();
    }
}
