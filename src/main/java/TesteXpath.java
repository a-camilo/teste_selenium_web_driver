import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteXpath {

    private WebDriver driver;
    private DSL dsl;

    @Before
    public void inicializa() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("file:///C:/Users/AntonioCamiloGomesdo/Desktop/componentes.html");
        dsl = new DSL(driver);
    }

    @After
    public void finaliza() throws InterruptedException {
        Thread.sleep(1000);
        driver.quit();
    }

    @Test
    public void textFildNome(){
        dsl.obterTexto(By.xpath("//*[@id='elementosForm:nome']"));
    }

    @Test
    public void radioFem(){
        dsl.obterTexto(By.xpath("//*[text()=' Feminino']"));
    }
    @Test
    public void labelPizza(){
        dsl.obterTexto(By.xpath("//*[text()=' Pizza']"));
    }

    @Test
    public void usuarioB(){
        dsl.obterTexto(By.xpath("//*[text()='Usuario B']"));
    }
    @Test
    public void mariaBtn(){
        dsl.obterTexto(By.xpath("//*[@id='elementosForm:tableUsuarios']/tbody/tr[2]/td[3]/input"));
    }

    @Test
    public void radio(){
        dsl.obterTexto(By.xpath("//*[@id='elementosForm:tableUsuarios']/tbody/tr[4]/td[5]/table//input"));
    }
    @Test
    public void textFieldEscolaridade(){
        dsl.obterTexto(By.xpath("//*[@id='elementosForm:tableUsuarios']/tbody/tr[1]/td[6]/input"));
    }

}
