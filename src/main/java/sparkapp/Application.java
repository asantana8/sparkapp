package sparkapp;

import static spark.Spark.*;

public class Application {

	public static void main(String[] args) {
		port(1234);
		get("/hello", "application/json", (request, response) -> {
		    return new MyMessage();
		}, new JsonTransformer());

	}

}

class MyMessage {
	private String message = "Hello Word";
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
