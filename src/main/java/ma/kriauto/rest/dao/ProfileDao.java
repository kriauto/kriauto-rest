package ma.kriauto.rest.dao;

import ma.kriauto.rest.domain.Profile;

public interface ProfileDao {
	public Profile getProfileByLogin(String login);
	public Profile getProfileByToken(String token);
	public Profile getProfileByMail(String mail);
	public Profile getProfileById(int id);
	public void updateProfile (Profile profile);
}
