package data;

import lombok.SneakyThrows;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.jupiter.api.BeforeEach;


import java.sql.Connection;
import java.sql.DriverManager;


public class DataBase {
    private static final QueryRunner runner = new QueryRunner();
    private static final String mySQLAddress = "jdbc:mysql://localhost:3306/app";
    private static final String mySqlDBName = "app";
    private static final String mySQLPassword = "pass";
    private static final String postgreAddress = "jdbc:postgresql://localhost:5432/app";
    private static final String postgreDBname = "app";
    private static final String postgrePassword = "pass";

    private DataBase() {
    }

    @SneakyThrows
    private static Connection getConnection(String address, String dbName, String password) {
        return DriverManager.getConnection(address, dbName, password);
    }

    public static Connection getMySQLConn() {
        return getConnection(mySQLAddress, mySqlDBName, mySQLPassword);
    }

    public static Connection getPostgreConn() {
        return getConnection(postgreAddress, postgreDBname, postgrePassword);
    }

    @SneakyThrows
    public static String returnStatusOfTransaction(Connection connection) {
        var codeSQL = "SELECT status FROM payment_entity ORDER BY created DESC LIMIT 1";
        var status = runner.query(connection, codeSQL, new ScalarHandler<>());
        return String.valueOf(status);
    }

    @BeforeEach
    @SneakyThrows
    public void cleanDataBase() {
        cleanTables(getMySQLConn());
        cleanTables(getPostgreConn());
    }

    @SneakyThrows
    private static void cleanTables(Connection connection) {
        try (connection) {
            runner.update(connection, "DELETE FROM order_entity");
            runner.update(connection, "DELETE FROM payment_entity");
            runner.update(connection, "DELETE FROM credit_request_entity");
        }
    }
}


