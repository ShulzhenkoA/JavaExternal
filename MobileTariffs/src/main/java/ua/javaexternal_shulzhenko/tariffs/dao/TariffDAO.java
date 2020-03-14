package ua.javaexternal_shulzhenko.tariffs.dao;

import ua.javaexternal_shulzhenko.tariffs.connector.DBConnector;
import ua.javaexternal_shulzhenko.tariffs.models.tariff.Tariff;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class TariffDAO implements AbstractDAO {

    DBConnector connector;

    public TariffDAO(DBConnector connector) {
        this.connector = connector;
    }

    @Override
    public void addTariffs(List<Tariff> tariffsList) throws SQLException {
        for (Tariff tariff: tariffsList) {
            addTariff(tariff);
        }
    }

    @Override
    public void addTariff(Tariff tariff) throws SQLException {

        CallableStatement statement = connector.getCallableStatement(DBQueries.ADD_TARIFF);
        statement.setString(1, tariff.getName());
        statement.setString(2, tariff.getOperatorName());
        statement.setDouble(3, tariff.getPayroll());
        statement.setDouble(4, tariff.getSms());

        Tariff.CallPrices callPrices = tariff.getCallPrices();
        statement.setDouble(5, callPrices.getWithingNetwork());
        statement.setDouble(6, callPrices.getOutsideNetwork());
        statement.setDouble(7, callPrices.getStationaryPhones());

        Tariff.Parameters parameters = tariff.getParameters();
        statement.setString(8, parameters.getFavouriteNumbers());
        statement.setString(9, parameters.getTariffing());
        statement.setString(10, parameters.getTariffConnectionFee());
        statement.execute();

        connector.closeStatement(statement);
    }

    @Override
    public List<Tariff> getTariffs() throws SQLException {

        List<Tariff> tariffsFromDB = new LinkedList<>();
        Statement statement = connector.getStatement();
        ResultSet resultSet = statement.executeQuery(DBQueries.GET_ALL_TARIFFS.getQuery());

        while (resultSet.next()){

            Tariff tmpTariff = new Tariff();
            tmpTariff.setName(resultSet.getString(2));
            tmpTariff.setOperatorName(resultSet.getString(3));
            tmpTariff.setPayroll(resultSet.getDouble(4));
            tmpTariff.setSms(resultSet.getDouble(5));

            Tariff.CallPrices callPrices = tmpTariff.getCallPrices();
            callPrices.setWithingNetwork(resultSet.getDouble(7));
            callPrices.setOutsideNetwork(resultSet.getDouble(8));
            callPrices.setStationaryPhones(resultSet.getDouble(9));

            Tariff.Parameters parameters = tmpTariff.getParameters();
            parameters.setFavouriteNumbers(resultSet.getString(11));
            parameters.setTariffing(resultSet.getString(12));
            parameters.setTariffConnectionFee(resultSet.getString(13));

            tariffsFromDB.add(tmpTariff);
        }
        connector.closeStatement(statement);
        return tariffsFromDB;
    }

    @Override
    public void closeConnector() throws SQLException {
        connector.closeConnection();
    }
}
