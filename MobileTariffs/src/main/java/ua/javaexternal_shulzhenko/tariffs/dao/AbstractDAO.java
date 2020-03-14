package ua.javaexternal_shulzhenko.tariffs.dao;

import ua.javaexternal_shulzhenko.tariffs.models.tariff.Tariff;

import java.sql.SQLException;
import java.util.List;

public interface AbstractDAO {
    void addTariffs(List<Tariff> tariffsList) throws SQLException;
    void addTariff(Tariff tariff) throws SQLException;
    List<Tariff> getTariffs() throws SQLException;
    void closeConnector() throws SQLException;
}
