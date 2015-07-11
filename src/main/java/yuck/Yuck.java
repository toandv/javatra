package yuck;

import yuck.annotation.GuardedBy;

public class Yuck {

	private Yuck() {

	}
	// use eager initialization for safety and simplicity

	@GuardedBy("Yuck.class")
	private static YuckServer yuckServer = YuckServerFactory.get();

	@GuardedBy("Yuck.class")
	private static RouteMatcher router = RouteMatcherFactory.get();

	public static synchronized void addRoute(HttpMethod method, String uri, Target target) {
		router.addRoute(method, uri, target);
	}

	public static synchronized void yuck() {
		// thread waiting yuckServer to die/join
		new Thread(new Runnable() {
			@Override
			public void run() {
				yuckServer.start();
			}
		}).start();
	}
}
