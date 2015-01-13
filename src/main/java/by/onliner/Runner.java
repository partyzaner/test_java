package by.onliner;

import by.onliner.constant.ProjectConstants;
import by.onliner.exception.ArgumentParsingException;
import by.onliner.utils.Arguments;
import org.apache.log4j.Logger;
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.testng.TestNG;
import org.testng.xml.Parser;
import org.testng.xml.XmlSuite;
import org.uncommons.reportng.HTMLReporter;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;


public class Runner {

    private static final Logger LOGGER = Logger.getLogger(Runner.class);
    private static Arguments arguments = null;

    public static void main(String[] args) throws ArgumentParsingException {
        arguments = parseArguments(args);
        Runner.run();
    }

    public static Arguments getArguments(){
        return arguments;
    }

    private static Arguments parseArguments(String[] args) throws ArgumentParsingException {
        Arguments arguments = new Arguments();
        CmdLineParser argParser = new CmdLineParser(arguments);
        try {
            argParser.parseArgument(args);
        } catch (CmdLineException e) {
            String message = "Failed to parse cmd parameters";
            LOGGER.error(message);
            throw new ArgumentParsingException(message);
        }
        return arguments;
    }

    private static void run(){
        List<XmlSuite> xmlSuiteList = null;
        TestNG testNG = new TestNG();

        HTMLReporter reporter = new HTMLReporter();
        testNG.setUseDefaultListeners(false);
        testNG.addListener(reporter);

        Parser parser = new Parser(ProjectConstants.TESTNG_FILE);
        try{
            xmlSuiteList = parser.parseToList();
        }
        catch (ParserConfigurationException e){
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        catch (SAXException e){
            e.printStackTrace();
        }
        testNG.setXmlSuites(xmlSuiteList);

        testNG.run();
    }
}
