import camilo.antonio.core.DSL;
import camilo.antonio.core.DriveFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import static camilo.antonio.core.DriveFactory.getDriver;

public class TestePrime {

  
    private DSL dsl;

    @Before
    public void setup() {
        System.setProperty("webDriveFactory.getDriver().chrome.driver", "src/main/resources/drivers/chromeDriveFactory.getDriver().exe");
        getDriver().get("https://www.primefaces.org/showcase/ui/input/oneRadio.xhtml?jfwid=a79f4");
        dsl = new DSL();
    }

    @After
    public void setDown() {
        DriveFactory.killDriver();
    }

    @Test
    public void deveIteragirComRadioPrime() {
        dsl.clicarRadio(By.xpath("//*[@id='j_idt312:console']//td[3]"));

    }

    @Test
    public void deveInteragirMenu() {
        getDriver().get("https://www.primefaces.org/showcase/ui/input/oneMenu.xhtml?jfwid=b3598");
        dsl.selecionarComboPrime("j_idt311:option","Option1");

    }
}
