package example.angularspring.service;

import example.angularspring.dto.Profile;

public interface ProfileService {
	public Profile getProfileByLogin(String login);
	public Profile getProfileByToken(String token);
	public Profile getProfileByMail(String mail);
	public Profile getProfileById(int id);
	public void updateProfile (Profile profile);
	public String sendPassword(String to, String from, String subject, String content);
	public String hash256Profile(Profile profile);
	public String getKeyMap();
}
