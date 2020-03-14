package ua.javaexternal_shulzhenko.tariffs.connector;

public enum DataBases {
    MYSQL("con.mysql."),
    POSTGRESQL("con.postgresql.");
    private String name;

    DataBases(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
