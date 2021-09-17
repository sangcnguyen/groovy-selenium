import io.github.bonigarcia.wdm.WebDriverManager
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.openqa.selenium.By
import org.openqa.selenium.chrome.ChromeDriver

import java.time.Duration

class GoogleTest {
    def webDriver

    @Before
    void setup() {
        WebDriverManager.chromedriver().setup()
        webDriver = new ChromeDriver()
    }

    @Test
    void searchResult() {
        webDriver.get('https://www.google.com/')
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10))
        webDriver.findElement(By.name("q")).sendKeys("Selenium")
        webDriver.findElement(By.name("btnK")).click()
        Assert.assertEquals("Selenium", webDriver.findElement(By.xpath("//h3[normalize-space()='Selenium']")).getText())
    }

    @After
    void terminateSession() {
        webDriver.quit()
    }
}
