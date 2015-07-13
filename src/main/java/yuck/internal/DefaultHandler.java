package yuck.internal;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;

import yuck.HttpMethod;
import yuck.Response;
import yuck.Route;
import yuck.RouteMatcher;
import yuck.factory.RequestFactory;
import yuck.factory.ResponseFactory;
import yuck.utils.JsonUtils;

public class DefaultHandler extends AbstractHandler {

	private RouteMatcher routeMatcher;

	public DefaultHandler(RouteMatcher handler) {
		this.routeMatcher = handler;
	}

	@Override
	public void handle(String uri, Request baseRequest, HttpServletRequest httpRequest,
			HttpServletResponse httpResponse) throws IOException, ServletException {
		HttpMethod method = HttpMethod.valueOf(httpRequest.getMethod().toLowerCase());
		Route route = routeMatcher.findRoute(method, uri);
		yuck.Request request = wrapRequest(httpRequest, route.getUri());
		Response response = wrapReponse(httpResponse);

		// violate law of Demeter
		Object result = route.target().handle(request, response);
		httpResponse.setContentType("text/html; charset=utf-8");
		httpResponse.getWriter().print(JsonUtils.toJson(result));
		httpResponse.getWriter().flush();
	}

	private yuck.Response wrapReponse(HttpServletResponse httpResponse) {
		return ResponseFactory.create(httpResponse);
	}

	private yuck.Request wrapRequest(HttpServletRequest httpRequest, String routeUri) {
		return RequestFactory.create(httpRequest, routeUri);
	}
}
