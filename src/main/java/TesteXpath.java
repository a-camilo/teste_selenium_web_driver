import org.junit.Test;
import org.openqa.selenium.By;

public class TesteXpath extends BaseTest{

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
