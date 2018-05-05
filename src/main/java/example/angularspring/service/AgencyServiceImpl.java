package example.angularspring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import example.angularspring.dao.AgencyDao;
import example.angularspring.dto.Agency;

@Service("agencyService")
public class AgencyServiceImpl implements AgencyService {
	
	@Autowired
	AgencyDao agencydao;

	@Override
	public void updateAgency(Agency agency) {
		agencydao.updateAgency(agency);
	}

	@Override
	public Agency getAgencyByToken(String token) {
		// TODO Auto-generated method stub
		return agencydao.getAgencyByToken(token);
	}

}
