package yuck;

import java.util.List;

public interface Route {
	String getUri();

	Target target();

	HttpMethod method();

	boolean match(List<String> uriParts);
}
