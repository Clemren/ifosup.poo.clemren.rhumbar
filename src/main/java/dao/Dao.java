package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

public abstract class Dao<T> {
    protected Connection dbo = null;

    public Dao() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String url = "jdbc:mysql://localhost:3306/rhumbar?useTimezone=true&serverTimezone=UTC";
        try {

            Properties info = new Properties();
            info.put("user", "root");
            info.put("password", "pass");
            dbo = DriverManager.getConnection(url, info);

            if (dbo != null) {
            }

        } catch (SQLException ex) {
            System.out.println("An error occurred while connecting MySQL databse");
            ex.printStackTrace();
        }
    }

    public Dao(Connection conn) {
        this.dbo = conn;
    }

    public abstract void create(T obj);

    public abstract boolean delete(int obj);

    public abstract void update(T obj);

    public abstract T find(int id);

    public abstract List<T> findAll();

    public abstract T findByName(String id);
    public abstract boolean canDelete(int id);
}