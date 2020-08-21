package dao;

import beans.Origin;
import builders.OriginBuilder;
import com.jayway.restassured.path.json.JsonPath;
import org.json.JSONObject;

import javax.servlet.ServletContext;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OriginDao extends Dao<Origin> {
    private boolean results;

    @Override
    public void create(Origin origin) {
        try {
            var preparedStatement = dbo.prepareStatement("INSERT INTO origins (name, description, fk_country) VALUES (?, ?, ?)");
            preparedStatement.setString(1, origin.getName());
            preparedStatement.setString(2, origin.getDescription());
            preparedStatement.setInt(3, origin.getFk_countryAlpha2());
            preparedStatement.execute();
            var generatedKeys = preparedStatement.getGeneratedKeys();
            dbo.close();

            if (generatedKeys.next()) {
                origin.setPk(generatedKeys.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean delete(int id) {
        try {
            var preparedStatement = dbo.prepareStatement("DELETE FROM origins WHERE pk_origin = ? ");
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            dbo.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public void update(Origin origin) {
        try {
            var preparedStatement = dbo.prepareStatement("UPDATE origins SET name = ?, description = ?, fk_country = ? WHERE pk_origin =  ?");
            preparedStatement.setString(1, origin.getName());
            preparedStatement.setString(2, origin.getDescription());
            preparedStatement.setInt(3, origin.getFk_countryAlpha2());
            preparedStatement.setInt(4, origin.getPk());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Origin find(int id) {
        try {
            var preparedStatement = dbo.prepareStatement("SELECT * FROM origins WHERE pk_origin = ?",
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            var resultSet = preparedStatement.getResultSet();
            if (resultSet.first()) {

                var country = new CountryDao().find(resultSet.getInt("fk_country"));
                return new OriginBuilder()
                        .withId(resultSet.getInt("pk_origin"))
                        .withName(resultSet.getString("name"))
                        .withCountryAlpha2(country.getAlpha2())
                        .withCountryName(country.getName())
                        .build();
            }
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Origin> findAll() {
        try {
            var preparedStatement = dbo.prepareStatement("SELECT * FROM origins ORDER BY name asc",
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            preparedStatement.execute();
            var resultSet = preparedStatement.getResultSet();
            var origins = new ArrayList();
            while(resultSet.next()){
                var country = new CountryDao().find(resultSet.getInt("fk_country"));
                var origin = new OriginBuilder()
                        .withId(resultSet.getInt("pk_origin"))
                        .withName(resultSet.getString("name"))
                        .withCountryAlpha2(country.getAlpha2())
                        .withCountryName(country.getName())
                        .build();
                origin.setCanDelete(this.canDelete(resultSet.getInt("pk_origin")));
                origins.add(origin);
            }
            return origins;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Origin findByName(String name) {
        try {
            var preparedStatement = dbo.prepareStatement("SELECT * FROM origins WHERE name LIKE %?%",
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            preparedStatement.setString(1, name);
            preparedStatement.execute();
            var resultSet = preparedStatement.getResultSet();
            if (resultSet.first()) {
                return new Origin(resultSet.getInt("pk_origin"), resultSet.getString("name"));
            }
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean canDelete(int id) {
        try {
            var preparedStatement = dbo.prepareStatement("SELECT t.pk_trademark FROM origins INNER JOIN trademarks t on origins.pk_origin = t.fk_origin WHERE pk_origin = t.fk_origin AND pk_origin = ?",
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            var resultSet = preparedStatement.getResultSet();

            if(resultSet.next()){
                return false;
            }
            else{
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
