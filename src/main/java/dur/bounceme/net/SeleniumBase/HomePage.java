package dur.bounceme.net.SeleniumBase;

import java.util.logging.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

class HomePage extends AbstractPage {

    private static final Logger LOG = Logger.getLogger(App.class.getName());
    private WebDriver webDriver = null;
    private WebElement sideCategoryContainer = null;
    private final String sideCategoryXPath = "//div[@class='side_categories']/ul/li/ul";

    private HomePage() {
    }

    private HomePage(WebDriver webDriver) {
        LOG.fine(webDriver.getCurrentUrl());
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public void populateCatalog() {
        LOG.fine(sideCategoryXPath);
        sideCategoryContainer = webDriver.findElement(By.xpath(sideCategoryXPath));
        LOG.fine(sideCategoryContainer.getAttribute("innerHTML"));
        Catalog catalog = new Catalog(webDriver, sideCategoryContainer);
        catalog.iterateCatalog();
    }

}
