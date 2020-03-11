package ua.javaexternal_shulzhenko.tariffs.handler;




import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;


public class ErrorHandler extends DefaultHandler {

    private static ErrorHandler studentErrorHandler = new ErrorHandler();
    private final Logger LOGGER = LogManager.getLogger("ua.javaexternal_shulzhenko.tariffs");

    private ErrorHandler(){
    }

    public static ErrorHandler getStudentErrorHandler() {
        return studentErrorHandler;
    }

    @Override
    public void warning(SAXParseException exc) throws SAXException {
        LOGGER.warn(getLineAddress(exc) + " - " + exc.getMessage());
    }

    @Override
    public void error(SAXParseException exc) throws SAXException {
        LOGGER.error(getLineAddress(exc) + " - " + exc.getMessage());
    }

    @Override
    public void fatalError(SAXParseException exc) throws SAXException {
        LOGGER.fatal(getLineAddress(exc) + " - " + exc.getMessage());
    }

    private String getLineAddress(SAXParseException exc){
        return + exc.getLineNumber() + " : " + exc.getColumnNumber() ;
    }
}
