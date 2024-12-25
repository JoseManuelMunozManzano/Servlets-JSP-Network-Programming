package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Sender {

	public static void main(String[] args) throws IOException {

		// Datagram socket that binds to any available port in localhost
		DatagramSocket ds = new DatagramSocket();
		
		String message = "Hello Message using UDP";
		InetAddress ip = InetAddress.getByName("localhost");

		//Create Datagram packet and send
		DatagramPacket dp = new DatagramPacket(message.getBytes(), message.length(), ip, 5000);
		ds.send(dp);
		
		//Close the socket
		ds.close();
	}
	
}
