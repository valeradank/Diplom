package data;

import lombok.SneakyThrows;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DataBase {
    public static final QueryRunner runner = new QueryRunner();
    public static final String mySQLAddress = "jdbc:mysql://localhost:3306/app";
    public static final String mySqlDBName = "app";
    public static final String mySQLPassword = "pass";
    public static final String postgreAddress = "jdbc:postgresql://localhost:5432/app";
    public static final String postgreDBname = "app";
    public static final String postgrePassword = "pass";

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
        var conn = getPostgreConn();
        var status = runner.query(conn, codeSQL, new ScalarHandler<>());
        return String.valueOf(status);
    }
    @SneakyThrows
    public static String returnStatusOfTransactionMysql(Connection mySQLConn) {
        var codeSQL = "SELECT status FROM payment_entity ORDER BY created DESC LIMIT 1";
        var conn = getMySQLConn();
        var status = runner.query(conn, codeSQL, new ScalarHandler<>());
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


