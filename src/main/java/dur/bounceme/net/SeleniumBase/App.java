package dur.bounceme.net.SeleniumBase;

import java.io.IOException;
import java.util.Properties;
import java.util.logging.Logger;

public class App {

    private static final Logger LOG = Logger.getLogger(App.class.getName());
    private final Properties properties = new Properties();
//    private WebElement container = null;

    public static void main(String[] args) throws IOException {
        LOG.fine("starting..");
        new App().scrapeBooks();
    }

    private void scrapeBooks() throws IOException {
        properties.loadFromXML(App.class.getResourceAsStream("/selenium.xml"));
        String s = new FileLoader("/catalog.html").load();
        
    }

}
