package camilo.antonio.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriveFactory {

    private static WebDriver driver;

    private DriveFactory() {
    }

    public static WebDriver getDriver(){
        if (driver == null) {
            driver = new ChromeDriver();
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
