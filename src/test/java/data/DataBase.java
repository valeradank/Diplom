package data;
import lombok.SneakyThrows;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import java.sql.Connection;
import java.sql.DriverManager;


    public class DataBase {
        private static final QueryRunner runner = new QueryRunner();

        private DataBase() {
        }

        @SneakyThrows
        private static Connection getConnection(String address, String dbName, String password) {
            return DriverManager.getConnection(address, dbName, password);
        }

        public static Connection getMySQLConn() {
            return getConnection(Credentials.mySQLAddress, Credentials.mySqlDBName, Credentials.mySQLPassword);
        }

        public static Connection getPostgreConn() {
            return getConnection(Credentials.postgreAddress, Credentials.postgreDBname, Credentials.postgrePassword);
        }



    @SneakyThrows
    public static String returnStatusOfTransaction(Connection connection) {
        var codeSQL = "SELECT status FROM payment_entity ORDER BY created DESC LIMIT 1";
        var conn = getPostgreConn();
        var status = runner.query(conn, codeSQL, new ScalarHandler<>());
        return String.valueOf(status);
    }
    @SneakyThrows
    public static String returnStatusOfTransactionMysql1(Connection mySQLConn) {
        var transactionId = 1;
        var codeSQL = "SELECT status FROM payment_entity WHERE id = ? ORDER BY id DESC LIMIT 1";
        var conn = getMySQLConn();
        var status = runner.query(conn, codeSQL, new ScalarHandler<>(), transactionId);
        return String.valueOf(status);
    }
    @SneakyThrows
    public static String returnStatusOfTransactionMysql2(Connection mySQLConn) {
        var transactionId = 2;
        var codeSQL = "SELECT status FROM payment_entity WHERE id = ? ORDER BY id DESC LIMIT 1";
        var conn = getMySQLConn();
        var status = runner.query(conn, codeSQL, new ScalarHandler<>(), transactionId);
        return String.valueOf(status);
    }
}