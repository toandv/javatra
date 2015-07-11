package yuck;

public class YuckServerFactory {

	private static final YuckServer yuckServer = new YuckServer(new DefaultHandler(RouteMatcherFactory.get()));

	private YuckServerFactory() {
	}

	public static YuckServer get() {
		return yuckServer;
	}
}
