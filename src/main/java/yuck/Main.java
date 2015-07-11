package yuck;

public class Main {
	public static void main(String[] args) {

		Yuck.addRoute(HttpMethod.get, "/hello/:name", (req, res) -> {
			return "Hello";
		});

	}
}
