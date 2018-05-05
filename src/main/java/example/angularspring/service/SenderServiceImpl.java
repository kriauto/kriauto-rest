package example.angularspring.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.stereotype.Service;

import test.Mailin;

@Service("senderService")
public class SenderServiceImpl implements SenderService {

	@Override
	public int sendSms(String from, String to, String message) {
		System.out.println("from -> "+from+"to -> "+to+"message -> "+message);
		HttpClient httpClient = HttpClientBuilder.create().build(); //Use this instead 
		HttpPost request ;
		HttpResponse response;
		int status = 0 ;

		try {
		    request = new HttpPost("http://panel.smspm.com/gateway/c9ecee9259af98dccfef3603371fea26e267739a/api.v1/send?phone="+to+"&sender="+from+"&message="+message+"&output=json");
		    response = httpClient.execute(request);
		    status = response.getStatusLine().getStatusCode();
		    System.out.println("status -> "+response.getStatusLine().getStatusCode());
		    // handle response here...
		}catch (Exception ex) {
		    // handle exception here
		} finally {
		    httpClient.getConnectionManager().shutdown(); //Deprecated
		}
		if(status == 200){
		   return 0;
		}else{
		   return 1;
		}
	}

	@Override
	public int sendMail(String _from, String _to, String _subject, String _content) {
		
		Mailin http = new Mailin("https://api.sendinblue.com/v2.0","UfsbL9W8tCO3FQA0");
		Map < String, String > to = new HashMap < String, String > ();
			to.put(_to, _to);
//			Map < String, String > cc = new HashMap < String, String > ();
//				cc.put("contact@kriauto.ma", "contact@kriauto.ma");
//			Map < String, String > bcc = new HashMap < String, String > ();
//				bcc.put("contact@kriauto.ma", "contact@kriauto.ma");
//			Map < String, String > attachment = new HashMap < String, String > ();
//	    		attachment.put("myfilename.pdf", "your_pdf_files_base64_encoded_chunk_data");
		Map < String, String > headers = new HashMap < String, String > ();
			headers.put("Content-Type", "text/html; charset=iso-8859-1");
			headers.put("X-param1", "value1");
			headers.put("X-param2", "value2");
			headers.put("X-Mailin-custom", "my custom value");
			headers.put("X-Mailin-IP", "102.102.1.2");
			headers.put("X-Mailin-Tag", "My tag");
//			Map < String, String > inline_image = new HashMap < String, String > ();
//					inline_image.put("myinlineimage1.png", "your_png_files_base64_encoded_chunk_data");
//					inline_image.put("myinlineimage2.jpg", "your_jpg_files_base64_encoded_chunk_data");
		Map < String, Object > data = new HashMap < String, Object > ();
			data.put("to", to);
//				data.put("cc", cc);
//				data.put("bcc", bcc);
			data.put("replyto", new String [] {_from,_from});
			data.put("from", new String [] {_from,_from});
			data.put("subject", _subject);
			data.put("html", _content);
//					" This is inline image 1.<br/>"
//					<img src=\"{myinlineimage1.png}\" alt=\"image1\" border=\"0\"><br/>
//					Some text<br/>
//					This is inline image 2.<br/>
//					<img src=\"{myinlineimage2.jpg}\" alt=\"image2\" border=\"0\"><br/>
//					Some more text<br/>
//					Re-used inline image 1.<br/>
//					<img src=\"{myinlineimage1.png}\" alt=\"image3\" border=\"0\">");
//				data.put("text", "This is text");
			//data.put("attachment", attachment);
			//data.put("headers", headers);
			//data.put("inline_image", inline_image);
 
		String str = http.send_email(data);
		System.out.println(str);
		return 1;
	}

}
