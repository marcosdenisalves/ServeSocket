package connection;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ConnectionServer {

	private static ServerSocket server;

	// Create a server (type of parameter: int)
	public static void createServer(int port) throws IOException {
		server = new ServerSocket(port);
	}

	// Awaits a connection with the client
	public static Socket waitingCliente() throws IOException {
		return server.accept();
	}
	
	// Ends a connection (type of parameter: Socket)
	public static void close(Socket client) throws IOException {
		client.close();
	}
	
	// Returns the used port
	public static int port() {
		return server.getLocalPort();
	}
}
