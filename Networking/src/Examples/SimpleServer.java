package Examples;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleServer {
	public static void main(String[] args) throws Exception {

		// Listen to port
		// Un Socket es una IP y un puerto.
		try (ServerSocket server = new ServerSocket(8798)) {
			System.out.println("Server started..");

			// Espera a que alguien se conecte a ese puerto.
			// Devuelve un Socket que es la conexión con el cliente.
			try (Socket serverClientSocket = server.accept()) {

				DataInputStream inStream = new DataInputStream(serverClientSocket.getInputStream());
				DataOutputStream outStream = new DataOutputStream(serverClientSocket.getOutputStream());

				outStream.writeUTF("Echo from server : " + inStream.readUTF());
				outStream.flush();

				inStream.close();
				outStream.close();
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
