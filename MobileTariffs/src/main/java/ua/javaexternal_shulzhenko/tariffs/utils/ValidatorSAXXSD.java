package ua.javaexternal_shulzhenko.tariffs.utils;

import org.xml.sax.SAXException;
import ua.javaexternal_shulzhenko.tariffs.handler.ErrorHandler;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

public class ValidatorSAXXSD {

    private static ValidatorSAXXSD validator = new ValidatorSAXXSD();

    private ValidatorSAXXSD() {
    }

    public static ValidatorSAXXSD getValidator() {
        return validator;
    }

    public void validateXML(String fileXML, String fileXSD) throws SAXException, IOException {
        String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;
        SchemaFactory factory = SchemaFactory.newInstance(language);
        Schema schema = factory.newSchema(new File(fileXSD));
        Validator validator = schema.newValidator();
        ErrorHandler errorHandler = ErrorHandler.getStudentErrorHandler();
        validator.setErrorHandler(errorHandler);
        validator.validate(new StreamSource(fileXML));
    }
}