package sparkapp.util;

import java.sql.SQLException;

import org.sql2o.Sql2o;

import sparkapp.dao.StepDao;
import sparkapp.dao.TaskDao;

public class DbUtil {

	private Sql2o connection;
	private StepDao stepDao;
	private TaskDao taskDao;
	
	public static final DbUtil INSTANCE = new DbUtil();

	private DbUtil(){
	}
	
	public StepDao getStepDao() throws SQLException {
		if (stepDao == null) {
			stepDao = new StepDao(getConnection());
		}
		return stepDao;
	}
	
	public TaskDao getTaskDao() throws SQLException {
		if (taskDao == null) {
			taskDao = new TaskDao(getConnection());
		}
		return taskDao;
	}

	private Sql2o getConnection() throws SQLException {
        if (connection == null) {
            String dbpath = "./resources/app.db";
            String url = "jdbc:h2:" + dbpath;
            String user = "sa";
            connection = new Sql2o(url, user, "");
        }
        return connection;
    }

}
