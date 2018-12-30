package dur.bounceme.net.SeleniumBase;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;
import java.util.Scanner;
import java.util.logging.Logger;

public class App {

    private static final Logger LOG = Logger.getLogger(App.class.getName());
    private final Properties properties = new Properties();
//    private WebElement container = null;

    public static void main(String[] args) throws IOException {
        LOG.fine("starting..");
        new App().scrapeBooks();
    }

    public String readFile1(String path) throws IOException {
        String s = "hmm";
        File f = new File(path);
        LOG.info("file\t\t" + f.isFile());
//        List<String> fileLines = Files.readAllLines(fileToRead.toPath());
//        return StringUtils.join(fileLines, StringUtils.EMPTY);
        return s;
    }

    private String readFile(String pathname) throws IOException {

        File file = new File(pathname);
        StringBuilder fileContents = new StringBuilder((int) file.length());

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                fileContents.append(scanner.nextLine() + System.lineSeparator());
            }
            return fileContents.toString();
        }
    }

    private void scrapeBooks() throws IOException {
        properties.loadFromXML(App.class.getResourceAsStream("/selenium.xml"));
        LOG.info(properties.toString());

        InputStream in = getClass().getResourceAsStream("/selenium.xml");
        BufferedReader br = new BufferedReader(new InputStreamReader(in));

        String s = null;

        while ((s = br.readLine()) != null) {

            LOG.info(s);
        }

        // Stream<String> foo = Files.lines(Paths.get("selenium.xml"));
        //   String content = new String(Files.readAllBytes(Paths.get("selenium.xml")), "UTF-8");
    }

}
