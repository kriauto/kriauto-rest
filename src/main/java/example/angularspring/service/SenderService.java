package example.angularspring.service;


public interface SenderService {
	public int sendSms(String from, String to, String message);
	public int sendMail(String from, String to, String subject, String content);
}
