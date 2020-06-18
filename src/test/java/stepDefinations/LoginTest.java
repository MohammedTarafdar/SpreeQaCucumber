package stepDefinations;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class LoginTest {

    WebDriver driver;

    @Given("User already in home page")
    public void user_already_in_home_page() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        //driver.navigate().to("http://spree.shiftedtech.com/");
        driver.get("http://spree.shiftedtech.com/");
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

    }

    @When("User click on Login link")
    public void user_click_on_Login_link() throws InterruptedException {
        WebElement loginLink = driver.findElement(By.xpath("//a[contains(text(),'Login')]"));
        Thread.sleep(5000);
        loginLink.click();
        String panelTitle = driver.findElement(By.xpath("//h3[@class='panel-title']")).getText();
        System.out.println(panelTitle);
        Assert.assertEquals(panelTitle,"Login as Existing Customer" );

    }
    @Then("User enter valid username and password")
    public void user_enter_valid_username_and_password() {
        WebElement email =driver.findElement(By.xpath("//input[@id='spree_user_email']"));
        email.clear();
        email.sendKeys("hellogenius.shift@gmail.com");
        WebElement password =driver.findElement(By.xpath("//input[@id='spree_user_password']"));
        password.clear();
        password.sendKeys("shift1234");


    }
    @Then("User click on Login button")
    public void user_click_on_Login_button() {
        WebElement loginButton = driver.findElement(By.xpath("//input[@name='commit']"));
        loginButton.click();

    }
    @Then("User land to home page")
    public void user_land_to_home_page() {
        String loggedinSMS = driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();
        System.out.println(loggedinSMS);
        Assert.assertEquals(loggedinSMS, "Logged in successfully");
        driver.quit();

    }

    @When("User already successfully logged in")
    public void user_already_successfully_logged_in()  {
        WebElement loginLink = driver.findElement(By.xpath("//a[contains(text(),'Login')]"));
        loginLink.click();
        WebElement email =driver.findElement(By.xpath("//input[@id='spree_user_email']"));
        email.clear();
        email.sendKeys("hellogenius.shift@gmail.com");
        WebElement password =driver.findElement(By.xpath("//input[@id='spree_user_password']"));
        password.clear();
        password.sendKeys("shift1234");
        WebElement loginButton = driver.findElement(By.xpath("//input[@name='commit']"));
        loginButton.click();

    }

    @Then("User click on Logout button")
    public void user_click_on_Logout_button() {
        WebElement logoutButton = driver.findElement(By.xpath("//a[contains(text(),'Logout')]"));
        logoutButton.click();
    }

    @Then("User land to home page after logged out")
    public void user_land_to_home_page_after_logged_out() {
        String loggedoutSMS = driver.findElement(By.xpath("//div[@class='alert alert-notice']")).getText();
        System.out.println(loggedoutSMS);
        Assert.assertEquals(loggedoutSMS, "Signed out successfully.");
        driver.quit();
    }


}
