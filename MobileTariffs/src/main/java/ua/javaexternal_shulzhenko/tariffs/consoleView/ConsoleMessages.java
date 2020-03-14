package ua.javaexternal_shulzhenko.tariffs.consoleView;

public enum ConsoleMessages {

    MENU("\n1. To validate tariffs.xml with tariffs.xsd using SAX enter *** 1 ***\n" +
         "2. To transform tariffs.xml and create tariffs.html enter *** 2 ***\n"+
         "3. To open and show created tariffs.html enter *** 3 ***\n"+
         "4. To build Java tariff objects from tariff.xml using StAX builder enter *** 4 ***\n"+
         "5. To validate created Java tariff objects using custom annotations and tariff object validator enter *** 5 ***\n" +
         "6. To show created Java tariff objects enter *** 6 ***\n" +
         "7. To add all created tariff objects to database enter *** 7 ***\n" +
         "8. To show all tariff objects from database enter *** 8 ***\n" +
         "9. To exit enter *** 9 ***\n\n"+
         "Info: custom annotations are applied in Tariff class (ua/javaexternal_shulzhenko/tariffs/models/tariff).\n" +
         "Lambda expressions are used in CommandsModel class (ua/javaexternal_shulzhenko/tariffs/models/command).\n" +
         "All validators,transformer and builder utils are in package utils (ua/javaexternal_shulzhenko/tariffs/utils).\n"),
    XML_VALIDATED("XML file has been successfully validate."),
    TARIFFS_OBJECTS_BUILT("Tariffs objects have been successfully built."),
    TARIFF_OBJECTS_VALIDATED("Tariff objects are valid."),
    TRANSFORMED_XML_HTML("XML file has been transformed to HTML."),
    OPENED_CREATED_HTML("HTML has been opened."),
    TARIFFS_ADDED_TO_DB("All tariffs were added to the database.");

    private String message;

    ConsoleMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
