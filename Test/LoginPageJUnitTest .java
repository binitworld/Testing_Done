import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.Assert.*;

public class LoginPageJUnitTest {
    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "E:\\\\Ecplise-Workspace\\\\chromedriver-win64\\\\chromedriver-win64\\\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void testLogin() {
        driver.get("http://localhost:9000/login");
        driver.findElement(By.name("email")).sendKeys("agent@agilebank.com");
        driver.findElement(By.name("password")).sendKeys("binit123");
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        assertTrue(driver.getCurrentUrl().contains("dashboard"));
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
