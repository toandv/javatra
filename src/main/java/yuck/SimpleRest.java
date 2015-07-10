package yuck;

import spark.Spark;

public class SimpleRest {
	public static void main(String[] args) {
		Spark.get("/hello", (req, res) -> "Hello");
	}
}
