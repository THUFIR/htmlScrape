package dur.bounceme.net.SeleniumBase;

import java.util.Properties;
import java.util.logging.Logger;

public class WebLoader {

    private static final Logger LOG = Logger.getLogger(WebLoader.class.getName());
    private String html = null;

    private WebLoader() {
    }

    public WebLoader(Properties properties) {
        String foo = properties.getProperty("foo");
    }

}
