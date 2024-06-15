package by.itstep.lomachenkov.examdb.dataAccessLayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    public static final String URL = "jdbc:mysql://localhost:3306/exam_task";
    public static final String USER = "root";
    public static final String PASSWORD = "Repa347_cel";

    private Database() {
    }

    public static Connection getConnection() throws SQLException {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException exception) {
            System.out.println(exception);;
        }
        return connection;
    }


}
