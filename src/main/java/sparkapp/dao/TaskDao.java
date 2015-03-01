package sparkapp.dao;

import org.sql2o.Connection;
import org.sql2o.Sql2o;

import sparkapp.domain.Task;

public class TaskDao {

	private Sql2o connection;
	private String insertSql = "insert into task(title, description, color, stepId) values (:title, :description, :color, :stepId)";
	private String updateSql = "update task set title = :title, description = :description, color = :color, stepId = :stepId where id = :id";
	private String deleteSql = "delete from task where id = :id";

	public TaskDao(Sql2o connection) {
		this.connection = connection;
	}

	public void save(Task task) {
		if (task.getId() == null) {
			insert(task);
		} else {
			update(task);
		}
	}

	private void update(Task task) {
		try (Connection con = connection.open()) {
		    con.createQuery(updateSql).bind(task).executeUpdate();
		}		
	}

	private void insert(Task task) {
		try (Connection con = connection.open()) {
		    con.createQuery(insertSql).bind(task).executeUpdate();
		}				
	}

	public void deleteById(Long id) {
		try (Connection con = connection.open()) {
		    con.createQuery(deleteSql).addParameter("id", id).executeUpdate();
		}		
	}
	
}
