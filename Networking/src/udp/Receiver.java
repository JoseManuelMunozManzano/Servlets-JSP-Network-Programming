package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Receiver {

	public static void main(String[] args) throws IOException {
		
		//Opens a datagram socket on the specified port
		DatagramSocket ds = new DatagramSocket(5000);
		
		
		byte[] buf = new byte[1024];
		
		//Constructs a datagram packet for receiving the packets of specified length
		DatagramPacket dp = new DatagramPacket(buf, 1024);
		
		ds.receive(dp);
		String str = new String(dp.getData(), 0, dp.getLength());
		
		System.out.println(str);
		
		//Closing the Datagram socket
		ds.close();
	}

}
