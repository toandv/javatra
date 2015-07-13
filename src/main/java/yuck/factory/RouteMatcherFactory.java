package yuck.factory;

import yuck.RouteMatcher;
import yuck.internal.DefaultRouteMatcher;

public class RouteMatcherFactory {

	private static final RouteMatcher matcher = new DefaultRouteMatcher();

	private RouteMatcherFactory() {

	}

	public static RouteMatcher get() {
		return matcher;
	}
}
