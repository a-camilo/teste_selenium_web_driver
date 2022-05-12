package camilo.antonio.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static camilo.antonio.core.Propriedade.Browsers.CHROME;
import static camilo.antonio.core.Propriedade.Browsers.FIREFOX;

public class DriveFactory {

    private static WebDriver driver;

    private DriveFactory() {
    }

    public static WebDriver getDriver(){
        if (driver == null) {
            switch (Propriedade.browsers) {
                case CHROME -> driver = new ChromeDriver();
                case FIREFOX -> driver = new FirefoxDriver();
            }
            driver.manage().window().maximize();
        }
        return driver;
    }

    public static void killDriver(){
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
