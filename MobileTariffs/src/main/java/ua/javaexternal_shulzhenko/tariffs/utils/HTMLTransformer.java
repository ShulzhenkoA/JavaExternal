package ua.javaexternal_shulzhenko.tariffs.utils;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class HTMLTransformer {

    private static HTMLTransformer transformer = new HTMLTransformer();

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

