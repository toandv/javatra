package yuck;

public class RouteMatcherFactory {

	private static final RouteMatcher router = new DefaultRouteMatcher();

	private RouteMatcherFactory() {

	}

	public static RouteMatcher get() {
		return router;
	}
}
