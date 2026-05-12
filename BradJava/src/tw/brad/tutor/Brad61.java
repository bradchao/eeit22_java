package tw.brad.tutor;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Brad61 {

	public static void main(String[] args) {
		while(true) {
			byte[] buf = new byte[1024];
			try(DatagramSocket socket = new DatagramSocket(8888)){
				DatagramPacket packet = new DatagramPacket(buf, buf.length);
				socket.receive(packet);
				System.out.println("UDP Receive OK");
				
				String urIp = packet.getAddress().getHostAddress();
				byte[] data = packet.getData();
				int len = packet.getLength();
				String mesg = new String(data,0,len);
				System.out.printf("%s : %s\n", urIp, mesg);
				if (mesg.equals("bye")) {
					break;
				}
			}catch(Exception e) {
				System.out.println(e);
			}
		}
		
	}

}
