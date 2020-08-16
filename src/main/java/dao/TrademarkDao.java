package dao;

import beans.Origin;
import beans.Trademark;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TrademarkDao extends Dao<Trademark> {
    private boolean results;

    @Override
    public void create(Trademark trademark) {
        try {
            var preparedStatement = dbo.prepareStatement("INSERT INTO trademarks (name, fk_origin) VALUES (?, ?)");
            preparedStatement.setString(1, trademark.getName());
            preparedStatement.setInt(2, trademark.getFk_origin());
            preparedStatement.execute();
            var generatedKeys = preparedStatement.getGeneratedKeys();
            dbo.close();
            if (generatedKeys.next()) {
                trademark.setPk(generatedKeys.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean delete(int id) {
        try {
            var preparedStatement = dbo.prepareStatement("DELETE FROM trademarks WHERE pk_trademark = ? ");
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
    public void update(Trademark trademark) {
        try {
            var preparedStatement = dbo.prepareStatement("UPDATE trademarks SET name = ? WHERE pk_trademark =  ?");
            preparedStatement.setString(1, trademark.getName());
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
    public Trademark find(int id) {
        try {
            var preparedStatement = dbo.prepareStatement("SELECT * FROM trademarks WHERE pk_trademark = ?",
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            var resultSet = preparedStatement.getResultSet();
            if (resultSet.first()) {
                return new Trademark(resultSet.getInt("pk_trademark"), resultSet.getInt("fk_origin"), resultSet.getString("name"));
            }
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Trademark> findAll() {
        try {
            var preparedStatement = dbo.prepareStatement("SELECT * FROM trademarks",
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            preparedStatement.execute();
            var resultSet = preparedStatement.getResultSet();
            var trademarks = new ArrayList();
            while(resultSet.next()){
                var trademark = new Trademark(resultSet.getInt("pk_trademark"),resultSet.getInt("fk_origin"), resultSet.getString("name"));
                trademark.setCanDelete(this.canDelete(resultSet.getInt("pk_trademark")));
                trademarks.add(trademark);
            }
            return trademarks;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Trademark findByName(String name) {
        try {
            var preparedStatement = dbo.prepareStatement("SELECT * FROM origins WHERE name LIKE %?%",
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            preparedStatement.setString(1, name);
            preparedStatement.execute();
            var resultSet = preparedStatement.getResultSet();
            if (resultSet.first()) {
                return new Trademark(resultSet.getInt("pk_trademark"),resultSet.getInt("fk_origin"), resultSet.getString("name"));
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
            var preparedStatement = dbo.prepareStatement("SELECT r.pk_rhum FROM trademarks inner join rhums r on trademarks.pk_trademark = r.fk_trademark WHERE pk_trademark = r.fk_trademark AND pk_trademark = ?",
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
