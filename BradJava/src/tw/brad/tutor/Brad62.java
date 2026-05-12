package tw.brad.tutor;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;

public class Brad62 {

	public static void main(String[] args) {
		String mesg = "Hello, TCP";
		try(Socket socket = new Socket(InetAddress.getByName("10.0.102.74"), 9999);
			BufferedOutputStream out = new BufferedOutputStream(socket.getOutputStream())	
				){
			out.write(mesg.getBytes());
		}catch(Exception e) {
			System.out.println(e);
		}
	}

}
