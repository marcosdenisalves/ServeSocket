package application;

import java.net.Socket;

import communication.ExchangeOfMessenges;
import connection.ConnectionServer;

public class Main {

	public static void main(String[] args) {

		try {

			ConnectionServer.createServer(3322);
			System.out.println("=========================");
			System.out.println("Port: "+ ConnectionServer.port());
			System.out.println("Waiting for connection...");
			System.out.println("=========================");
			Socket client = ConnectionServer.waitingCliente();
			System.out.println("Client IP: " + client.getInetAddress());

			String msg = ExchangeOfMessenges.receive(client);
			System.out.println(msg);

			ExchangeOfMessenges.send(client, "Menssage received");
			
			ExchangeOfMessenges.close(client);
			ConnectionServer.close(client);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}finally {
			System.out.println("=========================");
			System.out.println("Connection terminated!!!");
		}
	}
}
