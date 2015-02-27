package sparkapp;

import static spark.Spark.get;
import static spark.SparkBase.port;

import java.sql.SQLException;

import persist.StepDao;
import sparkapp.domain.Step;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;

public class Application {

	private static ConnectionSource connection;
	private static Dao<Step, Long> stepDao;

	public static void main(String[] args) throws SQLException {
		setupBD();

		port(1234);
		get("/hello", "application/json", (request, response) -> {
		    return stepDao.queryForAll();
		}, new JsonTransformer());

	}

	private static void setupBD() throws SQLException {
		stepDao = new StepDao(getConnection(), Step.class);
	}

	private static  ConnectionSource getConnection() throws SQLException {
        if (connection == null) {
            String databaseName = Application.class.getResource("/app.db").getPath().substring(1);
            String url = "jdbc:h2:file:" + databaseName;
            String user = "sa";
            connection = new JdbcConnectionSource(url, user, "");
        }
        return connection;
    }

}
