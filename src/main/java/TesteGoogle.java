import org.junit.Test;

import static camilo.antonio.core.DriveFactory.getDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class TesteGoogle extends BaseTest{

    @Test
    public void Google(){
        getDriver().get("https://www.google.com");
        assertEquals("Google", getDriver().getTitle());
    }
}
