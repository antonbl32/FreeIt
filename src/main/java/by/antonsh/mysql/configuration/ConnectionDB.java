package by.antonsh.mysql.configuration;

import com.mysql.cj.jdbc.MysqlDataSource;
import lombok.Data;

@Data
public class ConnectionDB {
    private static MysqlDataSource dataSource = new MysqlDataSource();

    static {
        dataSource.setUser("root");
        dataSource.setPassword("321000");
        dataSource.setServerName("localhost");
        dataSource.setDatabaseName("myorder");
    }

    private ConnectionDB() {
    }

    public static MysqlDataSource getDataSource() {
        return dataSource;
    }

    public static void setDataSource(MysqlDataSource dataSource) {
        ConnectionDB.dataSource = dataSource;
    }
}
