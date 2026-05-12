package tw.brad.tutor;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Brad63 {

	public static void main(String[] args) {
		try(ServerSocket server = new ServerSocket(9999);
			Socket socket = server.accept();
			BufferedReader reader = new BufferedReader(
				new InputStreamReader(socket.getInputStream()))
				){
			String line;
			while ((line = reader.readLine()) != null) {
				System.out.print(line);
			}
			
			
		}catch(Exception e) {
			System.out.println(e);
		}
	}

}
