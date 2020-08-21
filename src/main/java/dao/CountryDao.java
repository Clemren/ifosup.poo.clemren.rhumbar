package dao;

import beans.Country;
import beans.Origin;
import builders.OriginBuilder;
import com.jayway.restassured.path.json.JsonPath;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CountryDao extends Dao<Country> {
    private boolean results;

    @Override
    public void create(Country origin) {
        //vide
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public void update(Country country) {
        //vide
    }

    @Override
    public Country find(int id) {
        try {
            var preparedStatement = dbo.prepareStatement("SELECT * FROM countries WHERE pk_country = ?",
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            var resultSet = preparedStatement.getResultSet();
            if (resultSet.first()) {
                return new Country(resultSet.getInt("pk_country"),
                        resultSet.getInt("code"),
                        resultSet.getString("alpha2"),
                        resultSet.getString("name_fr"));
        }
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Country> findAll() {
        try {
            var preparedStatement = dbo.prepareStatement("SELECT * FROM countries ORDER BY name asc",
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            preparedStatement.execute();
            var resultSet = preparedStatement.getResultSet();
            var countries = new ArrayList();
            while (resultSet.next()) {
                var country =new Country(resultSet.getInt("pk_country"),
                        resultSet.getInt("code"),
                        resultSet.getString("alpha2"),
                        resultSet.getString("name"));
                countries.add(country);
            }
            return countries;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Country findByName(String id) {
        return null;
    }

    public Country findByAlpha2(String alpha2) {
        try {
            var preparedStatement = dbo.prepareStatement("SELECT * FROM countries WHERE alpha2 = ?",
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            preparedStatement.setString(1, alpha2);
            preparedStatement.execute();
            var resultSet = preparedStatement.getResultSet();
            if (resultSet.first()) {
                return new Country(resultSet.getInt("pk_country"),
                        resultSet.getInt("code"),
                        resultSet.getString("alpha2"),
                        resultSet.getString("name_fr"));
            }
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean canDelete(int id) {
        return false;
    }
}
