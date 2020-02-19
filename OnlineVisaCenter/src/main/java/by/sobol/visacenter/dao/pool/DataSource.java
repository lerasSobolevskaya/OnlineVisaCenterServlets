package by.sobol.visacenter.dao.pool;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import static by.sobol.visacenter.dao.pool.PoolConstants.*;

public class DataSource {

	private static HikariConfig config = new HikariConfig();
	private static HikariDataSource dataSource;

	private static final ResourceBundle RB = ResourceBundle.getBundle(DB_CONFIG);
	private static final String URL = RB.getString(DB_URL);
	private static final String DRIVER = RB.getString(DB_DRIVER);
	private static final String LOGIN = RB.getString(DB_LOGIN);
	private static final String PASS = RB.getString(DB_PASSWORD);

	static {
		config.setJdbcUrl(URL);
		config.setDriverClassName(DRIVER);
		config.setUsername(LOGIN);
		config.setPassword(PASS);
		config.addDataSourceProperty(CACHE_PREP_ST, CACHE_PREP_ST_VALUE);
		config.addDataSourceProperty(CACHE_SIZE, SIZE_VALUE);
		config.addDataSourceProperty(CACHE_LIMIT, LIMIT_VALUE);
		dataSource = new HikariDataSource(config);
	}

	private DataSource() {
	}

	public static Connection getConnection() throws SQLException {
		return dataSource.getConnection();
	}

}
