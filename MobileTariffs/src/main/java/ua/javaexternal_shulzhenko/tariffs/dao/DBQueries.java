package ua.javaexternal_shulzhenko.tariffs.dao;

public enum DBQueries {
    ADD_TARIFF("{CALL add_tariff(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}"),
    GET_ALL_TARIFFS("SELECT tariffs.*, call_prices.*, parameters.* FROM tariffs " +
            "JOIN call_prices ON call_prices.id = tariffs.id JOIN parameters ON parameters.id = tariffs.id");

    private String query;

    DBQueries(String query) {
        this.query = query;
    }

    public String getQuery() {
        return query;
    }
}
