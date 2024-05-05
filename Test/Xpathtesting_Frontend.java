package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Xpathtesting_Frontend {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "E:\\Ecplise-Workspace\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:9000/login");
        driver.findElement(By.name("email")).sendKeys("agent@agilebank.com");
        driver.findElement(By.name("password")).sendKeys("binit123");
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        driver.quit();
    }
}
