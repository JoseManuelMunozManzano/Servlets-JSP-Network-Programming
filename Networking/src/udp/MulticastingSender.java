package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class MulticastingSender {

	public static void main(String[] args) throws InterruptedException, IOException {

		//Pick any multicast address within the range 224.0.0.0 to 239.255.255.255
		String group = "226.4.5.6";

		// Multicast socket that binds to any available port in localhost
		MulticastSocket ms = new MulticastSocket();

		String message = "Hello Message using Multicast";

		// Create Datagram packet and send
		DatagramPacket dp = new DatagramPacket(message.getBytes(), message.length(), InetAddress.getByName(group),
				5000);
		
		ms.send(dp);

		// Close the socket
		ms.close();

	}
}
