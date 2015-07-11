package yuck;

public interface RouteMatcher {
	Route findRoute(HttpMethod method, String requestUri);

	void addRoute(HttpMethod method, String uri, Target target);
}
