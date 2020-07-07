import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;

public class SafarDriverManager  extends DriverManager
{
    private ChromeDriverService chSrevice;

    @Override
    protected void startServices() {
        if (null== chSrevice)
        {
            try{
                chSrevice = new ChromeDriverService.Builder().usingDriverExecutable(new File("chromedriver.exe"))
                        .usingAnyFreePort().build();
                chSrevice.start();;

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void stopServices() {
        if(null != chSrevice && chSrevice.isRunning())
            chSrevice.stop();
    }

    @Override
    protected void createDriver() {
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("test-type");
        capabilities.setCapability(ChromeOptions.CAPABILITY,options);
        driver = new ChromeDriver(chSrevice,capabilities);
    }
}
