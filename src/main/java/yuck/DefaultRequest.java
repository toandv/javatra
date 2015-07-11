package yuck;

import javax.servlet.http.HttpServletRequest;

public class DefaultRequest implements Request {

	private final HttpServletRequest httpRequest;

	public DefaultRequest(HttpServletRequest httpRequest) {
		this.httpRequest = httpRequest;
	}

	@Override
	public String uri() {
		return httpRequest.getRequestURI();
	}

	@Override
	public String body() {
		return null;
	}

	@Override
	public <T> T body(Class<T> type) {
		return null;
	}

	@Override
	public String queryParam(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String pathParam(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
