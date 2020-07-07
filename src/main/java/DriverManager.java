import org.openqa.selenium.WebDriver;

public abstract class  DriverManager {

    protected WebDriver driver;
    protected abstract void startServices();
    protected abstract void stopServices();
    protected abstract void createDriver();
    public void quitDriver()
    {
        if(null != driver)
        {
            driver.quit();
            driver = null;
        }
    }
    public WebDriver getDriver()
    {
        if (null == driver)
        {
            startServices();
            createDriver();
            stopServices();
        }
        return driver;
    }

}
