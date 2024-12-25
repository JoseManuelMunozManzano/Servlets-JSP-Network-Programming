package Examples;

import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) throws Exception {

		// Listen to port
		ServerSocket server = new ServerSocket(8698);

		int count = 0;
		System.out.println("Server Started...");

		while (true) {
			count++;

			// Start accepting requests and wait until client connects
			Socket serverClientSocket = server.accept();

			System.out.println("Serving Client " + count);

			// Handle the client communication
			ServerApp sa = new ServerApp(serverClientSocket, count);
			sa.start();
		}

	}
}
