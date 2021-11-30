import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

//@SpringBootTest
public class Sel002Test {
  private WebDriver driver;
  private Map<String, Object> vars;
  JavascriptExecutor js;
  @Before
  public void setUp() {
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();
  }
  @After
  public void tearDown() {
    driver.quit();
  }
  @Test
  public void sel002() {
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    driver.get("http://localhost:3000/");
    driver.manage().window().setSize(new Dimension(1536, 824));
    driver.findElement(By.cssSelector(".movieButton:nth-child(2)")).click();
    driver.findElement(By.cssSelector(".movieButton:nth-child(4)")).click();
    driver.findElement(By.cssSelector(".movieButton:nth-child(3)")).click();
    driver.findElement(By.cssSelector(".actorTodo:nth-child(1) .actorFeedbackAddFeedbackButton")).click();
    driver.findElement(By.cssSelector(".inputActorFeedback")).click();
    driver.findElement(By.cssSelector(".inputActorFeedback")).sendKeys("new feedback");
    driver.findElement(By.cssSelector(".actorFeedbackAddButton")).click();
    driver.findElement(By.cssSelector(".actorTodo:nth-child(1) .actorFeedbackButtonShow")).click();
    driver.findElement(By.cssSelector("div:nth-child(1) > div > .actorFeedDeleteButton")).click();
    driver.close();
  }
}