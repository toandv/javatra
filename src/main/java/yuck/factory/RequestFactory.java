package yuck.factory;

import javax.servlet.http.HttpServletRequest;

import yuck.Request;
import yuck.internal.DefaultRequest;

public class RequestFactory {
	private RequestFactory() {

	}

	public static Request create(HttpServletRequest httpRequest, String routeUri) {
		return new DefaultRequest(httpRequest, routeUri);
	}
}
