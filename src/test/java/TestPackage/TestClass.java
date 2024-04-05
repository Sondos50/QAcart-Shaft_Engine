package TestPackage;
import com.shaft.driver.SHAFT;
import com.shaft.gui.element.ElementActions;
import io.restassured.http.ContentType;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class TestClass {
    SHAFT.GUI.WebDriver driver;

    @BeforeTest
    public void OpenBrowser() {
        driver = new SHAFT.GUI.WebDriver();
        driver.browser().navigateToURL("https://hatem-hatamleh.github.io/Selenium-html/");

    }

    @Test(priority = 1)
    public void openChromeBrowser() {

        By ActionsButton = By.xpath("//a[@class='button actions']");
        driver.element().click(ActionsButton);

        //driver.browser().navigateToURL("https://hatem-hatamleh.github.io/Selenium-html/actions.html");

        By firstName = By.name("firstName");
        By lastName = By.name("lastName");
        By levelDropDown = By.id("level");
        By webRadio = By.id("web");
        By submit = By.id("actions-button");

        driver.element().type(firstName, "sondos");
        driver.element().type(lastName, "sherif");
        driver.element().select(levelDropDown, "Junior");
        driver.element().click(webRadio);
        driver.element().click(submit);
        driver.element().alert().acceptAlert();

        driver.browser().navigateBack();

    }

    @Test(priority = 2)
    public void Wait() {
        By WaitsButton = By.xpath("//a[@class='button waits']");
        driver.element().click(WaitsButton);


        By FirstButton = By.xpath("//button[@class='button primary']");
        driver.element().click(FirstButton);

        By SecondButton = By.xpath("//button[@class='button secondary']");
        driver.element().click(SecondButton);


        driver.element().alert().acceptAlert();

        driver.browser().navigateBack();
    }

    @Test(priority = 3)
    public void locators()
    {
        By LocatorButton = By.xpath("//a[@class='button locators']");
        driver.element().click(LocatorButton);


        By seleniumButton = By.id("selenium");
        By appiumButton = By.name("appium");
        By cypressButton = By.cssSelector("[data-testid=cypress]");

        driver.element().click(seleniumButton);
        driver.element().click(appiumButton);
        driver.element().click(cypressButton);
        driver.browser().navigateBack();

        String url = driver.browser().getCurrentURL();
        String title = driver.browser().getCurrentWindowTitle();
        System.out.println(url);
        System.out.println(title);
        driver.quit();

    }
}
