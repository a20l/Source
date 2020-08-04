package step_defs;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class Benefits_steps {

    WebDriver driver;


    @Given("^user is on home page of Blue Cross Blue Shield$")
    public void user_is_on_home_page_of_Blue_Cross_Blue_Shield() throws Throwable {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.navigate().to("https://www.bcbs.com");
        driver.navigate().refresh();

    }

    @When("^user clicks “Access My Benefits” link$")
    public void user_clicks_Access_My_Benefits_link() throws Throwable {

        WebElement benefitLink = driver.findElement(By.xpath("//button[@aria-label='Open the Access My Benefits form']"));

        Actions actions = new Actions(driver);
        actions.moveToElement(benefitLink).perform();
        Assert.assertTrue(benefitLink.isDisplayed());

        benefitLink.click();


    }

    @Then("^user should see “Enter the first three letters of the Identification Number from your member ID card\\.” message$")
    public void user_should_see_Enter_the_first_three_letters_of_the_Identification_Number_from_your_member_ID_card_message() throws Throwable {

        Assert.assertTrue(driver.findElement(By.xpath("//*[contains(text(),'Enter the first three letters')]")).isDisplayed());

        driver.close();

    }

}
