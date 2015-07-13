package yuck;

public interface Request {
	String uri();

	String queryParam(String name);

	String pathParam(String name);

	String body();

	<T> T body(Class<T> type);

}
