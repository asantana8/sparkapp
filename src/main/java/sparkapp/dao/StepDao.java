package sparkapp.dao;

import java.sql.SQLException;
import java.util.List;

import org.sql2o.Connection;
import org.sql2o.Sql2o;

import sparkapp.domain.Step;
import sparkapp.domain.Task;

public class StepDao {

	private Sql2o connection;

	public StepDao(Sql2o connection) throws SQLException {
		this.connection = connection;
	}
	
	public List<Step> list() {
		String sql = "select id, title, isFinally from step";
		String taskSql = "select id, title, description, color, stepId from task where stepId=:id";
		try (Connection con = connection.open()) {
			List<Step> steps = con.createQuery(sql).executeAndFetch(Step.class);
			steps.forEach(step->step.setTasks(con.createQuery(taskSql).addParameter("id", step.getId()).executeAndFetch(Task.class)));
			return steps;
		}

	}

}
