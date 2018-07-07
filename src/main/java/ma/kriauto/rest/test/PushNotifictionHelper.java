package ma.kriauto.rest.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONObject;

public class PushNotifictionHelper {
	 
public final static String AUTH_KEY_FCM = "AAAAGCh6u8g:APA91bGM-jPzZI1BIasa0IdW6SUNCXAa78mWXI0mACvYXmawU5ptyT3iCIjcEhS1_b7V6XaEwsuL-rppJ_AgH_O1Q_XBXttUYoVIlwVamJEr6grmo4qxWGWPMELZar1bRsXCpJCaEaFq";
public final static String API_URL_FCM = "https://fcm.googleapis.com/fcm/send";
 
    public static String sendPushNotification(String deviceToken)
            throws IOException {
        String result = "";
        URL url = new URL(API_URL_FCM);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
 
        conn.setUseCaches(false);
        conn.setDoInput(true);
        conn.setDoOutput(true);
 
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Authorization", "key=" + AUTH_KEY_FCM);
        conn.setRequestProperty("Content-Type", "application/json");
 
        
        try {
        	JSONObject json = new JSONObject();
        	 
            json.put("to", deviceToken.trim());
            JSONObject info = new JSONObject();
            //info.put("title", "notification title"); // Notification title
            info.put("body", "ceci est un test de notifications toto titiceci est un test de notifications toto titiceci est un test de notifications toto titiceci est un test de notifications toto titi"); // Notification
                                                                    // body
            json.put("notification", info);
            OutputStreamWriter wr = new OutputStreamWriter(
                    conn.getOutputStream());
            wr.write(json.toString());
            wr.flush();
 
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));
 
            String output;
            System.out.println("Output from Server .... \n");
            while ((output = br.readLine()) != null) {
                System.out.println(output);
            }
            result = "SUCCESS";
        } catch (Exception e) {
            e.printStackTrace();
            result = "FAILURE";
        }
        System.out.println("GCM Notification is sent successfully");
 
        return result;
}
    public static void main(String[] args){
    	String token = "dhUF18ynK_U:APA91bF-7O1HmueduVCl3HWIIW7yKXGW7z5DfM4z7Er698zTdgd0cWT_Q3newSCCWV_WHVOVQeOmiH0b9E8uCBm9G58z2pq2L6jKS4BKZu3SI9xKoqvPaouIEPt-Y7xd3Jxdxpxj"
                       +"yLVxPJaCQ4qVh0l29TSjw-PNvg";
//    	String token = "8e44805c397a33b88b340730361b9bd674fd64a582219ee78cc57d597ba4a625";
    	try {
			sendPushNotification(token);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
