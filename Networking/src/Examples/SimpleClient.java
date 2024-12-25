package Examples;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

// El protocolo que se usa es TCP.
public class SimpleClient {
	public static void main(String[] args) throws Exception {
		// Create connection to server socket
		try (Socket socket = new Socket("localhost", 8798)) {

			// Create streams to read/write data
			DataInputStream inStream = new DataInputStream(socket.getInputStream());
			DataOutputStream outStream = new DataOutputStream(socket.getOutputStream());

			Scanner scanner = new Scanner(System.in);
			String clientMessage = "";
			String serverMessage = "";

			// Prompt user to enter some number or 'end'
			System.out.println("Enter something :");
			clientMessage = scanner.nextLine();

			// Send the entered number to server
			outStream.writeUTF(clientMessage);
			outStream.flush();

			// Read data from socket input stream
			serverMessage = inStream.readUTF();
			System.out.println(serverMessage);

			// Close resources
			scanner.close();
			outStream.close();
			outStream.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
