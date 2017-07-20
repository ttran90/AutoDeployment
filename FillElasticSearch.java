import java.net.*;
import java.lang.*;
import java.io.*;

public class FillElasticSearch {
	public static void main(String[] args) {
		String[] ips = {
			"535.717.262.84",
			"362.747.217.94",
			"123.456.763.86",
			"783.943.236.34",
			"765.245.826.34",
			"733.626.246.13"
		};

		String[] names = {
			"Tom",
			"Alex",
			"Katie",
			"Healther",
			"Kayley",
			"John"
		};

		String[] codes = {
			"200",
			"201",
			"404",
			"500",
			"300",
			"115"
		};

		URL url;
		try {
			String uri = "http://localhost:9200/entry/entry/";
			for(int index = 0; index < 1000; index++) {
				url = new URL(uri + index);
				HttpURLConnection hurl = (HttpURLConnection) url.openConnection();
				hurl.setRequestMethod("PUT");
				hurl.setDoOutput(true);
				hurl.setRequestProperty("Content-Type", "application/json");
				hurl.setRequestProperty("Accept", "application/json");
				int int1 = (int)(Math.random() * 6);
				int int2 = (int)(Math.random() * 6);
				int int3 = (int)(Math.random() * 6);
				String payload = "{\"ip\":\"" + ips[int1] + "\",\"name\":\"" + names[int2] + "\",\"code\":\"" + codes[int3] + "\"}";
				OutputStreamWriter osw = new OutputStreamWriter(hurl.getOutputStream());
				osw.write(payload);
				osw.flush();
				if(hurl.getResponseCode() == 201) {
					System.out.println(index);
				}
				osw.close();
			} 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
