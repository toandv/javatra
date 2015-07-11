package yuck;

import static spark.Spark.*;

public class SparkJava {
	public static void main(String[] args) {
		Hello.start();
	}
}

class Hello {
	public static void start() {
		get("/hello/:name", (req, res) -> {
			String name = req.params("name");
			return "Hi " + name;
		});

		get("/hello/:name", (req, res) -> {
			String name = req.params("name");
			return "Hi ddd" + name;
		});

		post("/post", (req, res) -> {
			String body = req.body();
			return body;
		});
	}
}
