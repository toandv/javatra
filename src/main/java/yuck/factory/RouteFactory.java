package yuck.factory;

import yuck.HttpMethod;
import yuck.Route;
import yuck.Target;
import yuck.internal.DefaultRoute;

public class RouteFactory {

	private RouteFactory() {

	}

	public static Route create(HttpMethod method, String uri, Target target) {
		return new DefaultRoute(method, uri, target);
	}

}
