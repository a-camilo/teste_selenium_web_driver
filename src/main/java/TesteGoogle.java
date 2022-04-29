

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TesteGoogle extends BaseTest{

    @Test
    public void Google(){
        driver.get("https://www.google.com");
        assertEquals("Google",driver.getTitle());
    }
}
