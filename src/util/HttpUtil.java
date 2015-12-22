package util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import android.print.PrinterCapabilitiesInfo;

public class HttpUtil {
	public static void sendHttpRequest(final String address,final HttpCallbackListener listener){
		new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
/*				HttpURLConnection connection = null;
				try {
					URL url = new URL(address);
					connection = (HttpURLConnection)url.openConnection();
					connection.setRequestMethod("GET");
					connection.setConnectTimeout(5000);
					connection.setReadTimeout(5000);
					InputStream inputStream = connection.getInputStream();
					BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
					String line;
					StringBuffer response = new StringBuffer();
					if((line = reader.readLine()) != null){
						response.append(line);
					}
					if(listener != null){
						listener.onFinish(response.toString());
					}
				} catch (Exception e) {
					// TODO: handle exception
					if(listener != null){
						listener.onError(e);
					}
				} finally {
					if(connection != null){
						connection.disconnect();
					}
				}*/
				
				HttpClient httpClient = new DefaultHttpClient();
				try {
					URI uri = new URI(address);
					HttpGet httpGet = new HttpGet(uri);
					HttpResponse httpResponse = httpClient.execute(httpGet);
					if(httpResponse.getStatusLine().getStatusCode() == 200){
						HttpEntity entity = httpResponse.getEntity();
						String response = EntityUtils.toString(entity,"utf-8");
						if(listener != null){
							listener.onFinish(response);
						}
					}
				} catch (Exception e) {
					// TODO: handle exception
					if(listener != null){
						listener.onError(e);
					}
				} finally {
					if(httpClient != null){
						httpClient = null;
					}
				}
			}
			
		}).start();
	}
}
