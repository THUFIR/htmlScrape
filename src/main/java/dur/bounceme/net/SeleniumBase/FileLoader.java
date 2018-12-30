package dur.bounceme.net.SeleniumBase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.logging.Logger;

public class FileLoader {

    private static final Logger LOG = Logger.getLogger(FileLoader.class.getName());
    private String path = null;

    private FileLoader() {
    }

    public FileLoader(String path) {
        this.path = path;
    }

    public String load() throws IOException {
        InputStream in = getClass().getResourceAsStream("/catalog.html");
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        String s = null;
        StringBuilder sb = new StringBuilder();
        String eol = System.getProperty("line.separator");
        LOG.fine(eol); //err, it's an "end of line" /n ....so, how to know that?
        while ((s = br.readLine()) != null) {
            LOG.fine(s);
            sb.append(s + eol);
        }
        return sb.toString();
    }
}
