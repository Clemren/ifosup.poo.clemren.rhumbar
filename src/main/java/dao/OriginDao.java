package dao;

import beans.Origin;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OriginDao extends Dao<Origin> {
    private boolean results;

    @Override
    public void create(Origin origin) {
        try {
            var preparedStatement = dbo.prepareStatement("INSERT INTO origins (name) VALUES (?)");
            preparedStatement.setString(1, origin.getName());
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
            var preparedStatement = dbo.prepareStatement("UPDATE origins SET name = ? WHERE pk_origin =  ?");
            preparedStatement.setString(1, origin.getName());
            preparedStatement.setInt(2, origin.getPk());
            preparedStatement.execute();
           // var generatedKeys = preparedStatement.getGeneratedKeys();
            //Je n'ai à priori pas besoin de récupérer l'id de l'élément tout juste mis à jour.
            //if (generatedKeys.next()) {
            //    origin.setPk(generatedKeys.getInt(1));
            //}
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
                return new Origin(resultSet.getInt("pk_origin"), resultSet.getString("name"));
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
            var preparedStatement = dbo.prepareStatement("SELECT * FROM origins",
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            preparedStatement.execute();
            var resultSet = preparedStatement.getResultSet();
            var origins = new ArrayList();
            while(resultSet.next()){
                origins.add(new Origin(resultSet.getInt("pk_origin"), resultSet.getString("name")));
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
}
