package dur.bounceme.net.SeleniumBase;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class WebDriverFactory {

    private static final Logger LOG = Logger.getLogger(WebDriverFactory.class.getName());

    private Properties properties = new Properties();
    private FirefoxBinary firefoxBinary = null;
    private FirefoxOptions firefoxOptions = null;
    private WebDriver webDriver = null;
    private URL url = null;
    private String driver = null;
    private String gecko = null;
    private final List<String> commandLineOptions = new ArrayList<>();

    private WebDriverFactory() {
    }

    private WebDriverFactory(Properties properties) throws MalformedURLException {
        this.properties = properties;
        loadProps();
        init();
    }

    static WebDriver getWebDriver(Properties properties) throws MalformedURLException {
        WebDriverFactory driverFactory = new WebDriverFactory(properties);
        return driverFactory.webDriver;
    }

    private void loadProps() throws MalformedURLException {
        LOG.fine(properties.toString());
        String driverTypeString = properties.getProperty("driverType");
        NewEnum ne = NewEnum.firefox;
        url = new URL(properties.getProperty("url"));
        driver = properties.getProperty("driver");
        gecko = properties.getProperty("gecko");
        String commandLineOption = properties.getProperty("option01");
        commandLineOptions.add(commandLineOption);
    }

    private void init() throws MalformedURLException {
        firefoxBinary = new FirefoxBinary();
        commandLineOptions.forEach((commandLineOption) -> {
            LOG.fine(commandLineOption.toString());
            firefoxBinary.addCommandLineOptions(commandLineOption);
        });
        System.setProperty(driver, gecko);
        firefoxOptions = new FirefoxOptions();
        firefoxOptions.setBinary(firefoxBinary);
        webDriver = new FirefoxDriver(firefoxOptions);
        webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        webDriver.manage().window().maximize();
        webDriver.get(url.toString());
        LOG.fine(webDriver.getTitle());
        LOG.fine(webDriver.getCurrentUrl().toLowerCase());
    }

    void close() {
        webDriver.close();
    }

}

/*

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		config = new XMLConfiguration("object-config.xml");
 */
