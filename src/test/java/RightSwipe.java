import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

public class RightSwipe {

    private AndroidDriver driver;

    @Before
    public void setUp() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("appium:deviceName", "Nexus_4_API_29");
        desiredCapabilities.setCapability("appium:app", "C:\\Users\\aleks\\Desktop\\com_joom_3_87_0.apk");
        desiredCapabilities.setCapability("appium:ensureWebviewsHavePages", true);
        desiredCapabilities.setCapability("appium:nativeWebScreenshot", true);
        desiredCapabilities.setCapability("appium:newCommandTimeout", 0);
        desiredCapabilities.setCapability("appium:connectHardwareKeyboard", true);

        URL remoteUrl = new URL("http://127.0.0.1:4723/wd/hub");

        driver = new AndroidDriver(remoteUrl, desiredCapabilities);
    }

    @Test
    public void sampleTest() {
        //Ожидание загрузки
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //Закрываем первую всплывающую рекламу
        driver.findElement(new By.ByXPath("//android.widget.ImageView[@content-desc=\"Close\"]")).click();
        //Закрываем вторую возможную рекламу (?)
        //driver.findElement(new By.ByXPath("//android.widget.ImageView[@content-desc=\"Close\"]")).click();
        //Закрываем предложение на стартовом экране
        //driver.findElement(new By.ByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout[2]/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.view.ViewGroup")).click();
        //Свайп
        new TouchAction(driver).press(PointOption.point(654, 671)).moveTo(PointOption.point(144, 646)).release().perform();
    }

}