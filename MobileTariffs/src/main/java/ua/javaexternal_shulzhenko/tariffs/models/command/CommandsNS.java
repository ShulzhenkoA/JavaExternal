package ua.javaexternal_shulzhenko.tariffs.models.command;

public enum CommandsNS {

    VALIDATE_XML_XSD("validate_xml_xsd"),
    BUILD_TARIFFS("build_tariffs"),
    VALIDATE_TARIFF_OBJECTS("validate_tariffs"),
    SHOW_TARIFFS_OBJECTS("show_tariffs"),
    TRANSFORM_XML_HTML("transform_xml_html"),
    OPEN_CREATED_HTML("open_create_html"),;

    private String commandName;

    CommandsNS(String commandName) {
        this.commandName = commandName;
    }

    public String getName() {
        return commandName;
    }
}
