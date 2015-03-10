package sparkapp;

import spark.Spark;
import sparkapp.domain.Task;
import sparkapp.util.DbUtil;

public class Application {


	public static void main(String[] args) {
		Spark.port(8080);
		Spark.staticFileLocation("/public");

		JsonTransformer jsonTransformer = new JsonTransformer();
		Spark.get("/api/steps", (request, response) -> {
			response.type("application/json");
		    return DbUtil.INSTANCE.getStepDao().list();
		}, jsonTransformer);

		Spark.post("/api/tasks", "application/json", (request, response) -> {
			Task task = jsonTransformer.parse(request.body(), Task.class);
			DbUtil.INSTANCE.getTaskDao().save(task);	
		    return "";
		});

		Spark.delete("/api/tasks/:task_id", (request, response) -> {
			Long id = Long.valueOf(request.params(":task_id"));
			DbUtil.INSTANCE.getTaskDao().deleteById(id);			
		    return "";
		});

	}

}
