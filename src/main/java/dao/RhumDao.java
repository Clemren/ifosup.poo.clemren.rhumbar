package dao;

import beans.Rhum;
import beans.Trademark;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RhumDao extends Dao<Rhum> {
    private boolean results;

    @Override
    public void create(Rhum rhum) {
        try {
            var preparedStatement = dbo.prepareStatement("INSERT INTO rhums (name, fk_trademark) VALUES (?, ?)");
            preparedStatement.setString(1, rhum.getName());
            preparedStatement.setInt(2, rhum.getFk_trademark());
            preparedStatement.execute();
            var generatedKeys = preparedStatement.getGeneratedKeys();
            dbo.close();
            if (generatedKeys.next()) {
                rhum.setPk(generatedKeys.getInt(1));
            }
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
            var preparedStatement = dbo.prepareStatement("UPDATE rhums SET name = ? WHERE pk_rhum =  ?");
            preparedStatement.setString(1, rhum.getName());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Rhum find(int id) {
        try {
            var preparedStatement = dbo.prepareStatement("SELECT * FROM rhums WHERE pk_rhum = ?",
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            var resultSet = preparedStatement.getResultSet();
            if (resultSet.first()) {
                return new Rhum(resultSet.getInt("pk_rhum"), resultSet.getInt("fk_trademark"), resultSet.getString("name"));
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
            var preparedStatement = dbo.prepareStatement("SELECT * FROM rhums",
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            preparedStatement.execute();
            var resultSet = preparedStatement.getResultSet();
            var rhums = new ArrayList();
            while(resultSet.next()){
                rhums.add(new Trademark(resultSet.getInt("pk_rhum"),resultSet.getInt("fk_trademark"), resultSet.getString("name")));
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
