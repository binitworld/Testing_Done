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
    public void testLoginSuccess() {
        driver.get("http://localhost:9000/login");
        driver.findElement(By.name("email")).sendKeys("agent@agilebank.com");
        driver.findElement(By.name("password")).sendKeys("binit123");
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        assertTrue(driver.getCurrentUrl().contains("dashboard"));
    }
    @Test
    public void testLoginForBinit() {
        driver.get("http://localhost:9000/login");
        driver.findElement(By.name("email")).sendKeys("binit@agilebank.com");
        driver.findElement(By.name("password")).sendKeys("king123");
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        assertFalse(driver.getCurrentUrl().contains("dashboard"));
    }

    
    @Test
    public void testLoginFailure() {
        driver.get("http://localhost:9000/login");
        driver.findElement(By.name("email")).sendKeys("invalid@agilebank.com");
        driver.findElement(By.name("password")).sendKeys("invalidpassword");
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        assertFalse(driver.getCurrentUrl().contains("dashboard"));
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
