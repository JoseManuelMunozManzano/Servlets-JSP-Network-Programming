package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class MulticastingReceiver {

	public static void main(String[] args) throws IOException {

		String group = args[0];
		
		//Opens a Multicast socket on the specified port
		MulticastSocket ms = new MulticastSocket(5000);
		ms.joinGroup(InetAddress.getByName(group));
		
		byte[] buf = new byte[1024];
		
		//Constructs a datagram packet for receiving the packets of specified length
		DatagramPacket dp = new DatagramPacket(buf, 1024);
		
		ms.receive(dp);
		String str = new String(dp.getData(), 0, dp.getLength());
		
		System.out.println(str);
		
		//leave the group
		ms.leaveGroup(InetAddress.getByName(group));
		//Closing the Datagram socket
		ms.close();

	}

}
