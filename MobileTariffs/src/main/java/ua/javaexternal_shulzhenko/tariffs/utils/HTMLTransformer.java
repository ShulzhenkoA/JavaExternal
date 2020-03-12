package ua.javaexternal_shulzhenko.tariffs.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class HTMLTransformer {

    private static HTMLTransformer transformer = new HTMLTransformer();
    private final Logger LOGGER = LogManager.getLogger(HTMLTransformer.class);

    private HTMLTransformer() {
    }

    public static HTMLTransformer getTransformer() {
        return transformer;
    }

    public void transformXMLtoHTML(String fileXSL, String fileXML) throws TransformerException {
        String newHtmlPath = "resources/" + fileXML.substring(fileXML.indexOf("/") + 1, fileXML.indexOf(".")) + ".html";
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer transformer = tf.newTransformer(new StreamSource(fileXSL));
        transformer.transform(new StreamSource(fileXML), new StreamResult(newHtmlPath));
    }
}

