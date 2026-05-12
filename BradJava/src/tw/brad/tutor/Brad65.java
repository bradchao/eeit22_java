package tw.brad.tutor;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Brad65 {
	public static void main(String[] args) {
		try {
			URL url = new URL("https://w6.pchome.com.tw/img/index_2019/img_212_0_0.jpg?t=1778565661");
			HttpURLConnection conn =  (HttpURLConnection)url.openConnection();
			
			BufferedInputStream bin = new BufferedInputStream(conn.getInputStream());
			
			byte[] buf = bin.readAllBytes();
			
			
			BufferedOutputStream bout = new BufferedOutputStream(
					new FileOutputStream("dir2/cowcup.jpg"));
			bout.write(buf);
			
			bin.close();
			bout.close();
			System.out.println("OK");
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
