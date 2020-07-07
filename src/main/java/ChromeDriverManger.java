import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;


public class ChromeDriverManger extends DriverManager {
    private ChromeDriverService chService;


    @Override
    protected void startServices() {
        if (null== chService)
        {
            try{
                chService = new ChromeDriverService.Builder().usingDriverExecutable(new File("C:\\Users\\pbandara\\OneDrive - Wiley\\Desktop\\Automation_CRM\\Automation Script\\GIT\\qe_crm_ui_auto_teasy_4172020\\FactoryPatternInAutomation\\chromedriver.exe"))
                        .usingAnyFreePort().build();
                chService.start();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void stopServices() {
        if(null != chService && chService.isRunning())
            chService.stop();
    }

    @Override
    public void createDriver() {
      //  DesiredCapabilities capabilities = DesiredCapabilities.chrome();
       // ChromeOptions options = new ChromeOptions();
        //options.addArguments("test-type");
      //  options.setCapability(CapabilityType.BROWSER_NAME, "Chrome");
       // driver = new ChromeDriver(chService, capabilities);
       // ChromeOptions option = new ChromeOptions();
      //  options.merge(capabilities);
       // ChromeDriver driver = new ChromeDriver(options);
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(CapabilityType.BROWSER_NAME, "Chrome");
        ChromeOptions options = new ChromeOptions();
        options.merge(capabilities);
        WebDriver driver=new ChromeDriver(options);
    }
//    protected void createDriver() {
////        //Desired capabilities class is used to modify multiple properties of web driver
////        // Create an object of desired capabilities class with Chrome driver
////        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
////        ChromeOptions options = new ChromeOptions();
////        options.addArguments("test-type");
////        capabilities.setCapability(ChromeOptions.CAPABILITY,options);
////        // driver = new ChromeDriver(chSrevice,capabilities);
////        options.merge(capabilities);
////        // Open a new instance of chrome driver with the desired capability
////        WebDriver  driver = new ChromeDriver(chService, options);
////    }
}

