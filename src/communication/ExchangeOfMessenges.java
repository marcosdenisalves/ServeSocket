package communication;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ExchangeOfMessenges {

	// Send a message (type of parameter: Socket and String)
	public static void send(Socket client, String text) throws IOException {
		ObjectOutputStream input = new ObjectOutputStream(client.getOutputStream());
		input.writeObject(text);
	}

	// Receive a message (type of parameter: Socket)
	public static String receive(Socket client) throws Exception {
		ObjectInputStream output = new ObjectInputStream(client.getInputStream());
		return (String) output.readObject();
	}
	
	// Ends a streams (type of parameter: Socket)
	public static void close(Socket client) throws IOException {
		client.close();
	}
}
