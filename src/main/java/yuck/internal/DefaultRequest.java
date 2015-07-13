package yuck.internal;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import yuck.Request;
import yuck.utils.Lists;
import yuck.utils.ParamUtils;

public class DefaultRequest implements Request {

	private final HttpServletRequest httpRequest;

	private final Map<String, String> pathParams;

	public DefaultRequest(HttpServletRequest httpRequest, String routeUri) {
		this.httpRequest = httpRequest;
		pathParams = parse(Lists.splitString(routeUri, "/"), Lists.splitString(httpRequest.getRequestURI(), "/"));
	}

	private Map<String, String> parse(List<String> uriParts, List<String> requestUriParts) {

		Map<String, String> result = new HashMap<>(uriParts.size());
		for (int i = 0; i < uriParts.size(); i++) {
			if (ParamUtils.isPathParam(uriParts.get(i))) {
				result.put(uriParts.get(i), requestUriParts.get(i));
			}
		}
		return result;
	}

	@Override
	public String uri() {
		return httpRequest.getRequestURI();
	}

	@Override
	public String body() {
		// TODO
		return null;
	}

	@Override
	public <T> T body(Class<T> type) {
		// TODO
		return null;
	}

	@Override
	public String queryParam(String name) {
		return httpRequest.getParameter(name);
	}

	@Override
	public String pathParam(String name) {
		return pathParams.get(name);
	}
}
