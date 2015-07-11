package yuck;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;

import yuck.utils.JsonUtils;

public class DefaultHandler extends AbstractHandler {

	private RouteMatcher routeMatcher;

	public DefaultHandler(RouteMatcher handler) {
		this.routeMatcher = handler;
	}

	@Override
	public void handle(String uri, Request baseRequest, HttpServletRequest httpRequest,
			HttpServletResponse httpResponse) throws IOException, ServletException {
		HttpMethod method = HttpMethod.valueOf(httpRequest.getMethod());
		Route route = routeMatcher.findRoute(method, uri);
		yuck.Request request = wrapRequest(httpRequest);
		yuck.Response response = wrapReponse(httpResponse);

		// violate law of Demeter
		Object result = route.target().handle(request, response);
		httpResponse.setContentType("text/html; charset=utf-8");
		httpResponse.getWriter().print(JsonUtils.toJson(result));
		httpResponse.getWriter().flush();
	}

	private yuck.Response wrapReponse(HttpServletResponse response) {
		return null;
	}

	private yuck.Request wrapRequest(HttpServletRequest request) {
		return null;
	}
}
