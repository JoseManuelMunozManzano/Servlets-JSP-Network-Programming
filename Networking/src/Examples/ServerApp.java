package Examples;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

class ServerApp extends Thread{
	Socket serverClientSocket;
	int clientNo;
	boolean prime = false;

	ServerApp(Socket inSocket, int ClientNo) {
		serverClientSocket = inSocket;
		clientNo = ClientNo;
	}

	public void run() {
		try {

			// Streams to read and write the data to socket streams
			DataInputStream inStream = new DataInputStream(serverClientSocket.getInputStream());
			DataOutputStream outStream = new DataOutputStream(serverClientSocket.getOutputStream());

			String clientMessage = "";
			String serverMessage = "";

			while (!clientMessage.equals("end")) {

				clientMessage = inStream.readUTF();
				System.out.println("Checking \"" + clientMessage + "\" From Client :" + clientNo);
				
				//Check for prime and put it in output stream
				try {
					prime = checkPrime(Integer.parseInt(clientMessage));
				} catch (Exception e) {
					prime = false;
				}
				
				serverMessage = clientMessage+" is " +  ((prime == true) ? "Prime" : "not prime");
				outStream.writeUTF(serverMessage);
				outStream.flush();
			}
			inStream.close();
			outStream.close();
			serverClientSocket.close();

		} catch (Exception ex) {
			System.out.println(ex);
		} finally {
			System.out.println("Client -" + clientNo + " exit!! ");
		}
	}

	boolean checkPrime(int n) {
		boolean result = false;

		int i, m = 0, flag = 0;
		m = n / 2;
		if (n == 0 || n == 1) {
			result = false;
		} else {
			for (i = 2; i <= m; i++) {
				if (n % i == 0) {
					result = false;
					flag = 1;
					break;
				}
			}
			if (flag == 0) {
				result = true;
			}
		} // end of else
		return result;
	}

}
