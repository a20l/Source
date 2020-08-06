package step_defs;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.en_old.Ac;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.security.Key;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class socialMediaIcons_Steps {

    WebDriver driver;


    @Given("^user goes to Blue Cross Blue Shield website \"([^\"]*)\"$")
    public void user_goes_to_Blue_Cross_Blue_Shield_website(String expectedWebsite) throws Throwable {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);

        driver.get("https://www.bcbs.com/");
        driver.navigate().refresh();
        Assert.assertEquals(expectedWebsite, driver.getCurrentUrl());


    }

    @Given("^verifies the title \"([^\"]*)\" is displayed$")
    public void verifies_the_title_is_displayed(String ExpectedTitle) throws Throwable {
        Assert.assertTrue(driver.getTitle().contains(ExpectedTitle));

    }

    @Then("^user should be able to see four social media icons$")
    public void user_should_be_able_to_see_social_media_icons(DataTable options) throws Throwable {

        WebElement facebookIcon = driver.findElement(By.xpath("//span[text()='Facebook']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(facebookIcon).perform();
        List<WebElement> icons = driver.findElements(By.cssSelector("#block-footersocial > div > p"));
        for (WebElement each : icons) {
            Assert.assertTrue(each.isDisplayed());
        }


    }

    @When("^user clicks on  \"([^\"]*)\" then title should be \"([^\"]*)\"$")
    public void user_clicks_on_then_title_should_be(String icons, String ExpectedTitles) throws Throwable {

        WebElement icontButton = driver.findElement(By.xpath("//span[text()='" + icons + "']/../.."));
        driver.findElement(By.xpath("//a[@aria-label='dismiss cookie message']")).click();
        Thread.sleep(2000);


        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();


        String mainWindow = driver.getWindowHandle();

        Thread.sleep(3000);
        icontButton.click();
        Thread.sleep(3000);

        for (String window : driver.getWindowHandles()) {
            if (!mainWindow.equals(window)) {
                driver.switchTo().window(window);
            }
        }
        Assert.assertEquals(ExpectedTitles, driver.getTitle());
        driver.switchTo().window(mainWindow);
        driver.quit();
    }


}






/*
USER STORY 1:
As a User of https://www.bcbs.com/

I want to go to Blue Cross Blue Shield web site 'https://www.bcbs.com/'

Verify that title "Blue Cross Blue Shield" is displayed

I want to be able to see 4 icon-links (facebook, twitter, linkedid, youtube).

Verify that they are present there

USER STORY 2:
As a User of https://www.bcbs.com/

I want to go to Blue Cross Blue Shield web site 'https://www.bcbs.com/'

Verify that title "Blue Cross Blue Shield" is displayed

Click on each of 4 icon-links (facebook, twitter, linkedid, youtube) located on the bottom-right of webPage so they are opened in separate window tabs.

Verify that total of 5 tabs are currently open

Than verify titles for: facebook - "Blue Cross and Blue Shield Association - Home |Facebook"
twitter - "Blue Cross Blue Shield Association (@BCBSAssociation) / Twitter"
youtube - "Blue Cross Blue Shield Association - YouTube"
linkedid - "Sign Up | LinkedIn"
Note: you can click all four links and then do necessary verification,
or open one tab->do verification->open second one ..and so on. (Steps 3-5)


 */


