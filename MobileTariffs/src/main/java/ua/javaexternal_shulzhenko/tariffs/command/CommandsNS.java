package ua.javaexternal_shulzhenko.tariffs.command;

public enum CommandsNS {

    VALIDATE_XML_XSD("validate_xml_xsd"),
    OPEN_CREATED_HTML("open_create_html"),
    TRANSFORM_XML_HTML("transform_xml_html"),
    VALIDATE_TARIFF_OBJECTS("validate_tariffs"),
    BUILD_TARIFFS("build_tariffs");

    private String commandName;

    CommandsNS(String commandName) {
        this.commandName = commandName;
    }

    public String getName() {
        return commandName;
    }
}
