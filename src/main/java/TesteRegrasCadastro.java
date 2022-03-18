import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteRegrasCadastro {

    private WebDriver driver;
    private DSL dsl;
    private CampoTreinamentoPage page;
    private String nome;
    private String sobrenome;
    private String sexo;

    @BeforeEach
    public void inicializa() {
        System.setProperty("webdriver.chrome.driver", "C:/Users/AntonioCamiloGomesdo/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("file:///C:/Users/AntonioCamiloGomesdo/Desktop/componentes.html");
        dsl = new DSL(driver);
        page = new CampoTreinamentoPage(driver);
    }

    @AfterEach
    public void finaliza() throws InterruptedException {
        Thread.sleep(1000);
        driver.quit();
    }


    public void devevalidrRegras(){
        page.setNome(nome);
        page.setSobrenome(sobrenome);
        if (sexo.equals("Masculino")){
            page.setSexoMasculino();
        }else {
            page.setSexoFeminio();
        }
        
        page.setComidaFavoritaPizza();
        page.setEscolaridade("Superior");
        page.setEsporte("Natacao");
        page.setEsporte("Futebol");
        page.setCampoSugestao();
        page.botaoCadastrar();
    }
}
