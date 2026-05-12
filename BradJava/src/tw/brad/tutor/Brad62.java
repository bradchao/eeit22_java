package tw.brad.tutor;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.InetAddress;
import java.net.Socket;

public class Brad62 {

	public static void main(String[] args) {
		File source = new File("dir1/coffee.jpg");
		try(BufferedInputStream bin = 
				new BufferedInputStream(new FileInputStream(source));
			//------------------------------------------------------------
				Socket socket = new Socket(InetAddress.getByName("10.0.102.74"), 9999);
			BufferedOutputStream out = new BufferedOutputStream(socket.getOutputStream())	
				){
			
			byte[] buf = bin.readAllBytes();
			System.out.println(buf.length + " bytes");
			
			out.write(buf);
			out.flush();
			System.out.println("TCP Send OK");
		}catch(Exception e) {
			System.out.println(e);
		}
	}

}
