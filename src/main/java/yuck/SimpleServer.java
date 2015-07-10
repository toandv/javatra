package yuck;

import java.util.concurrent.TimeUnit;

import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.server.handler.HandlerList;

public class SimpleServer {

	private static final int DEFAUTL_PORT = 8888;

	private static final long DEFAULT_IDLE_TIMEOUT = TimeUnit.HOURS.toMillis(1);

	private int port = DEFAUTL_PORT;

	private Server server;

	private Handler handler;

	private long idleTimeout = DEFAULT_IDLE_TIMEOUT;

	public SimpleServer(Handler handler) {
		this.handler = handler;
	}

	public void go() {
		try {
			server = new Server();
			ServerConnector connector = new ServerConnector(server);
			connector.setPort(port);
			connector.setIdleTimeout(idleTimeout);
			server.setConnectors(new Connector[] { connector });
			HandlerList handlers = new HandlerList();
			handlers.addHandler(handler);
			server.setHandler(handlers);
			server.start();
			server.join();
		} catch (Exception e) {
			System.exit(1);
		}
	}

	public void stop() {

	}

	public static void main(String[] args) {
		SimpleServer server = new SimpleServer(new SimpleHandler());
		server.go();
	}
}
