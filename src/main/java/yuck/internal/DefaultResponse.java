package yuck.internal;

import javax.servlet.http.HttpServletResponse;

import yuck.Response;

public class DefaultResponse implements Response {

	private final HttpServletResponse httpResponse;

	public DefaultResponse(HttpServletResponse httpResponse) {
		this.httpResponse = httpResponse;
	}

}
