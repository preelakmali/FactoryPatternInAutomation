import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FactoryPatternTest {
    DriverManager driverManger;
    WebDriver driver;

    @BeforeTest
    public void beforeTest()
    {
       driverManger  = DriverManagerFactory.getManger(DriverType.CHROME) ;

    }
    @BeforeMethod
    public void beforeMethod()
    {
        driver = driverManger.getDriver();
    }

    @AfterMethod
    public void afterMethod()
    {
        driverManger.quitDriver();
    }

    @Test
    public void navigateToTheFaceBook()
    {
        driver.get("https://www.facebook.com/");
        Assert.assertEquals("Facebook", driver.getTitle());
    }

    @Test
    public  void navigateToGoogle()
    {
        driver.get("https://www.google.com/");
        Assert.assertEquals("Google",driver.getTitle());
    }








}
