package Examples;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
	public static void main(String[] args) throws Exception {

		// Listen to port
		try (ServerSocket server = new ServerSocket(8698)) {
			Socket serverClientSocket = server.accept();
			
			DataInputStream inStream = new DataInputStream(serverClientSocket.getInputStream());
			DataOutputStream outStream = new DataOutputStream(serverClientSocket.getOutputStream());
			
			String clientMessage = "";
			
			while(!clientMessage.equals("end")) {
		    clientMessage = inStream.readUTF();
				outStream.writeUTF("Echo from server : " + clientMessage);
				outStream.flush();
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
