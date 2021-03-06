package dao;

import beans.Rhum;
import beans.Trademark;
import builders.RhumBuilder;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RhumDao extends Dao<Rhum> {
    private boolean results;

    @Override
    public void create(Rhum rhum) {
        try {
            var preparedStatement = dbo.prepareStatement("INSERT INTO rhums (name, fk_trademark, filename, unitprice, description) VALUES (?, ?, ?, ?, ?)");
            preparedStatement.setString(1, rhum.getName());
            preparedStatement.setInt(2, rhum.getFk_trademark());
            preparedStatement.setString(3, rhum.getFilename());
            preparedStatement.setDouble(4, rhum.getUnitPrice());
            preparedStatement.setString(5, rhum.getDescription());
            preparedStatement.execute();
            var generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                rhum.setPk(generatedKeys.getInt(1));
            }
            dbo.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean delete(int id) {
        try {
            var preparedStatement = dbo.prepareStatement("DELETE FROM rhums WHERE pk_rhum = ? ");
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
    public void update(Rhum rhum) {
        try {
            var preparedStatement = dbo.prepareStatement("UPDATE rhums SET name = ?, fk_trademark = ?, unitprice = ?, description = ? WHERE pk_rhum =  ?");
            preparedStatement.setString(1, rhum.getName());
            preparedStatement.setInt(2, rhum.getFk_trademark());
            preparedStatement.setDouble(3, rhum.getUnitPrice());
            preparedStatement.setString(4, rhum.getDescription());
            preparedStatement.setDouble(5, rhum.getPk());

            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateFilename(Rhum rhum) {
        try {
            var preparedStatement = dbo.prepareStatement("UPDATE rhums SET filename = ? WHERE pk_rhum =  ?");
            preparedStatement.setString(1, rhum.getFilename());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public Rhum find(int id) {
        try {
            var preparedStatement = dbo.prepareStatement("SELECT * FROM rhums " +
                            "inner join trademarks t on fk_trademark = t.pk_trademark " +
                            "inner join origins o on t.fk_origin = o.pk_origin " +
                            "inner join countries c2 on o.fk_country = c2.pk_country " +
                            "WHERE pk_rhum = ?",
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            var resultSet = preparedStatement.getResultSet();
            if (resultSet.first()) {

                var rhum = new RhumBuilder()
                        .withId(resultSet.getInt("pk_rhum"))
                        .withName(resultSet.getString("name"))
                        .withTrademark(resultSet.getString("t.name"))
                        .withFkTrademark(resultSet.getInt("t.pk_trademark"))
                        .withOrigin(resultSet.getString("o.name"))
                        .withCountryName(resultSet.getString("c2.name_fr"))
                        .withCountryAlpha2(resultSet.getString("c2.alpha2"))
                        .withFilename(resultSet.getString("filename"))
                        .withUnitPrice(resultSet.getDouble("unitprice"))
                        .withDescription(resultSet.getString("description"))
                        .build();
                return rhum;
            }
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Rhum> findAll() {
        try {
            var preparedStatement = dbo.prepareStatement("SELECT * FROM rhums r " +
                            "inner join trademarks t on fk_trademark = t.pk_trademark " +
                            "inner join origins o on t.fk_origin = o.pk_origin " +
                            "inner join countries c2 on o.fk_country = c2.pk_country ORDER BY r.name ASC ",
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            preparedStatement.execute();
            var resultSet = preparedStatement.getResultSet();
            var rhums = new ArrayList();
            while(resultSet.next()){
                var rhum = new RhumBuilder()
                        .withId(resultSet.getInt("pk_rhum"))
                        .withName(resultSet.getString("r.name"))
                        .withTrademark(resultSet.getString("t.name"))
                        .withOrigin(resultSet.getString("o.name"))
                        .withCountryName(resultSet.getString("c2.name_fr"))
                        .withCountryAlpha2(resultSet.getString("c2.alpha2"))
                        .withFilename(resultSet.getString("r.filename"))
                        .withUnitPrice(resultSet.getDouble("r.unitprice"))
                        .withDescription(resultSet.getString("r.description"))
                        .build();
                rhum.setCanDelete(true);
                rhums.add(rhum);
            }
            return rhums;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Rhum findByName(String name) {
        try {
            var preparedStatement = dbo.prepareStatement("SELECT * FROM rhums WHERE name LIKE %?%",
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            preparedStatement.setString(1, name);
            preparedStatement.execute();
            var resultSet = preparedStatement.getResultSet();
            if (resultSet.first()) {
                return new Rhum(resultSet.getInt("pk_rhum"),resultSet.getInt("fk_trademark"), resultSet.getString("name"));
            }
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean canDelete(int id) {
        return true;
    }
}
