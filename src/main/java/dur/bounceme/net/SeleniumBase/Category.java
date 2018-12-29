package dur.bounceme.net.SeleniumBase;

import java.util.logging.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class Category {

    private static final Logger LOG = Logger.getLogger(Category.class.getName());
    private WebElement container = null;
    private final WebDriver webdriver = null;

    private Category() {
    }

    public Category(WebDriver webDriver, WebElement container) {
        LOG.info("new category..");
        this.container = container;
        PageFactory.initElements(webDriver, container);
    }

    public void iterateThisCategory() {
        LOG.info(container.getAttribute("innerHTML"));
    }
}
