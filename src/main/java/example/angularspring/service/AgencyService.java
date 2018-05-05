package example.angularspring.service;

import example.angularspring.dto.Agency;

public interface AgencyService {

	public Agency getAgencyByToken(String token);
	public void updateAgency(Agency agency);

}
