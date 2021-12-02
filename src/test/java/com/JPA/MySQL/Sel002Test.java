package com.JPA.MySQL;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
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
   // System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
  //  ChromeOptions options = new ChromeOptions();
  //  options.addArguments("headless");
  //  options.addArguments("disable-gpu");
 //   driver = new ChromeDriver(options);
    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();
  }
  @After
  public void tearDown() {
    driver.quit();
  }
  @Test
  public void sel002() throws InterruptedException {

  // driver.get("http://54.211.251.198:3000");
    driver.get("http://localhost:3000/");
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.manage().window().setSize(new Dimension(1536, 824));
    driver.findElement(By.cssSelector(".movieButton:nth-child(3)")).click();
    TimeUnit.SECONDS.sleep(1);
    driver.findElement(By.cssSelector(".filmTodo:nth-child(1) .filmFeedbackButtonShow")).click();
    TimeUnit.SECONDS.sleep(1);
    js.executeScript("window.scrollTo(0,213.81817626953125)");
    TimeUnit.SECONDS.sleep(1);
    driver.findElement(By.cssSelector(".filmTodo:nth-child(1) .filmFeedbackAddFeedbackButton")).click();
    TimeUnit.SECONDS.sleep(1);
    driver.findElement(By.cssSelector(".inputFilmFeedback")).click();
    TimeUnit.SECONDS.sleep(1);
    driver.findElement(By.cssSelector(".inputFilmFeedback")).sendKeys("new fedb");
    TimeUnit.SECONDS.sleep(1);
    driver.findElement(By.cssSelector(".filmFeedbackAddButton")).click();
    TimeUnit.SECONDS.sleep(1);
    js.executeScript("window.scrollTo(0,225.4545440673828)");
    TimeUnit.SECONDS.sleep(1);
    driver.findElement(By.cssSelector("div:nth-child(1) > div > .btn-outline-warning")).click();
    TimeUnit.SECONDS.sleep(1);
    driver.findElement(By.cssSelector(".updateFilmFeedback")).click();
    TimeUnit.SECONDS.sleep(1);
    driver.findElement(By.cssSelector(".updateFilmFeedback")).sendKeys("nice one test");
    TimeUnit.SECONDS.sleep(1);
    driver.findElement(By.cssSelector(".updateFeedbackAddButton")).click();
    TimeUnit.SECONDS.sleep(1);
    driver.findElement(By.cssSelector("div:nth-child(2) > div > .filmFeedDeleteButton")).click();
    TimeUnit.SECONDS.sleep(1);
    driver.findElement(By.cssSelector(".movieButton:nth-child(4)")).click();
    TimeUnit.SECONDS.sleep(1);
    driver.findElement(By.cssSelector(".actorTodo:nth-child(1) .actorFeedbackButtonShow")).click();
    TimeUnit.SECONDS.sleep(1);
    driver.close();
  }
}
