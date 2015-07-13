package yuck.internal;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import yuck.HttpMethod;
import yuck.Route;
import yuck.RouteMatcher;
import yuck.Target;
import yuck.annotation.Mutable;
import yuck.factory.RouteFactory;
import yuck.utils.Lists;

@Mutable
public class DefaultRouteMatcher implements RouteMatcher {

	private final Set<Route> getRoutes = new HashSet<>();

	private final Set<Route> postRoutes = new HashSet<>();

	private final Set<Route> putRoutes = new HashSet<>();

	@Override
	public Route findRoute(HttpMethod method, String requestUri) {
		List<String> requestUriParts = Lists.splitString(requestUri, "/");
		switch (method) {
		case get:
			return findGetRoute(requestUriParts);
		case post:
			return findPostRoute(requestUriParts);
		case put:
			return findPutRoute(requestUriParts);
		case delete:
			break;
		default:
			break;
		}

		return null;
	}

	private Route findPutRoute(List<String> requestUriParts) {
		return findRoute(putRoutes, requestUriParts);
	}

	private Route findPostRoute(List<String> requestUriParts) {
		return findRoute(postRoutes, requestUriParts);
	}

	private Route findGetRoute(List<String> requestUriParts) {
		return findRoute(getRoutes, requestUriParts);
	}

	private Route findRoute(Set<Route> routes, List<String> requestUriParts) {
		for (Route route : routes) {
			if (route.match(requestUriParts)) {
				return route;
			}
		}
		return notFound();
	}

	private Route notFound() {
		// TODO return error route
		return null;
	}

	@Override
	public void addRoute(HttpMethod method, String uri, Target target) {
		Route route = RouteFactory.create(method, uri, target);
		switch (method) {
		case get:
			addRoute(getRoutes, route);
			return;
		case post:
			addRoute(getRoutes, route);
			return;
		case put:
			addRoute(getRoutes, route);
			return;
		case delete:
			break;
		default:
			break;
		}
	}

	private void addRoute(Set<Route> routes, Route route) {
		if (routes.contains(route)) {
			// TODO : log warring, route overwritten
		}
		routes.add(route);
	}

}
