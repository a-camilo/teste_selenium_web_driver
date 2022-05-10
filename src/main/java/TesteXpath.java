import org.junit.Test;
import org.openqa.selenium.By;

public class TesteXpath extends BaseTest{

    @Test
    public void textFildNome(){
        dsl.obterTexto(By.xpath("//*[@id='elementosForm:nome']"));
    }

    @Test
    public void radioFem(){
        dsl.obterTexto(By.xpath("//*[@name='elementosForm:sexo'and @value='F']"));
    }
    @Test
    public void labelPizza(){
        dsl.obterTexto(By.xpath("//*[@id='elementosForm:comidaFavorita:2']/following-sibling::label"));
    }

    @Test
    public void usuarioB(){
        dsl.obterTexto(By.xpath("//*[text()='Usuario B']"));
    }
    @Test
    public void mariaBtn(){
        //Umas das formas de encontrar o botão via Xpath

//        dsl.obterTexto(By.xpath("//*[@id='elementosForm:tableUsuarios']/tbody/tr[2]/td[3]/input"));
        dsl.obterTexto(By.xpath("//*[@id='elementosForm:tableUsuarios']//td[.='Maria']/..//input[@type='button']"));
    }

    @Test
    public void radio(){
        dsl.obterTexto(By.xpath("//*[@id='elementosForm:tableUsuarios']/tbody/tr[4]/td[5]/table//input"));
    }
    @Test
    public void textFieldEscolaridade(){
        dsl.obterTexto(By.xpath("//*[@id='elementosForm:tableUsuarios']/tbody/tr[1]/td[6]/input"));
    }

    @Test
    public void deveClicarBotaoTabela(){
            dsl.clicarBotaoTabela("Nome","Maria","Botao","elementosForm:tabelaUsuarios");
    }

}
