package yuck.factory;

import javax.servlet.http.HttpServletResponse;

import yuck.Response;
import yuck.internal.DefaultResponse;

public class ResponseFactory {

	public static Response create(HttpServletResponse httpResponse) {
		return new DefaultResponse(httpResponse);
	}

}
