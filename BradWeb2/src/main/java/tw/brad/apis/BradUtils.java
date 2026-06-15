package tw.brad.apis;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Random;
import java.util.SortedMap;
import java.util.TreeMap;

import org.json.JSONArray;
import org.json.JSONObject;

public class BradUtils {
	public static String calc(String x, String y) {
		try {
			int intX = Integer.parseInt(x);
			int intY = Integer.parseInt(y);
			return (intX + intY) + "";
		}catch(Exception e) {
			return "";
		}
	}
	
	public static int createScore() {
		return new Random().nextInt(101);
	}
	
	public static SortedMap[] parseGift(String json) {
		JSONArray root = new JSONArray(json);
		TreeMap<String, String>[] gifts = new TreeMap[root.length()];
		
		for (int i=0; i<root.length(); i++) {
			JSONObject gift = root.getJSONObject(i);
			TreeMap<String, String> map = new TreeMap<>();
			map.put("name", gift.getString("Name"));
			map.put("city", gift.getString("County"));
			map.put("town", gift.getString("Township"));
			map.put("addr", gift.getString("SalePlace"));
			map.put("tel", gift.getString("ContactTel"));
			map.put("picurl", gift.getString("Column1"));
			gifts[i] = map;
		}
		
		
		return gifts;
	}
	
	public static String loadView() throws Exception {
		String source = "C:\\Users\\User\\git\\repository\\BradWeb2\\src\\main\\webapp\\views\\view1.html";
		File html = new File(source);
		BufferedInputStream bin = new BufferedInputStream(new FileInputStream(html));
		byte[] data = bin.readAllBytes();
		bin.close();
		return new String(data);
	}

	public static String loadView(String view) throws Exception {
		String source = 
			String.format("C:\\Users\\User\\git\\repository\\BradWeb2\\src\\main\\webapp\\views\\%s.html", view);
		Path path = Path.of(source);
		return  Files.readString(path);
	}
	
	
}
