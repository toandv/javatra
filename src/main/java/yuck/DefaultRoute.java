package yuck;

import java.util.List;
import java.util.Objects;

import yuck.annotation.Immutable;
import yuck.utils.Lists;
import yuck.utils.ParamUtils;
import yuck.utils.Strings;

@Immutable
public final class DefaultRoute implements Route {

	private final List<String> uriParts;

	private final String uri;

	private final Target target;

	private final HttpMethod method;

	public DefaultRoute(HttpMethod method, String uri, Target target) {
		this.method = method;
		this.uri = Strings.requireNonNullAndEmpty(uri, "uri cannot be null.");
		this.target = Objects.requireNonNull(target, "Target object cannot be null.");
		this.uriParts = Lists.splitString(uri, "/");
	}

	@Override
	public String getUri() {
		return uri;
	}

	@Override
	public Target target() {
		return target;
	}

	@Override
	public HttpMethod method() {
		return method;
	}

	@Override
	public boolean match(List<String> requestUriParts) {
		if (this.uriParts.size() != requestUriParts.size()) {
			return false;
		}
		for (int i = 0; i < this.uriParts.size(); i++) {
			String thisPart = this.uriParts.get(i);
			String requestUriPart = requestUriParts.get(i);
			// if uri part is not a path parameter
			if (!ParamUtils.isPathParam(thisPart)) {
				// then it must exactly equals to request part,
				// otherwise, return false, not match
				if (!thisPart.equals(requestUriPart)) {
					return false;
				}
			}
		}
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((method == null) ? 0 : method.hashCode());
		result = prime * result + ((uri == null) ? 0 : uri.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DefaultRoute other = (DefaultRoute) obj;
		if (method != other.method)
			return false;
		if (uri == null) {
			if (other.uri != null)
				return false;
		} else if (!uri.equals(other.uri))
			return false;
		return true;
	}

}
