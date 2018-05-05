package example.angularspring.dao;

import example.angularspring.dto.Agency;

public interface AgencyDao {
	public Agency getAgencyByToken(String token);
	public void updateAgency(Agency agency);

}
