package sparkapp.domain;

import java.util.List;

public class Step {

	private Long id;
	private String title;
	private boolean isFinally;
	private List<Task> tasks;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public boolean isFinally() {
		return isFinally;
	}

	public void setFinally(boolean isFinally) {
		this.isFinally = isFinally;
	}

	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

}
