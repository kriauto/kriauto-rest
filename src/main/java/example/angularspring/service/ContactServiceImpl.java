package example.angularspring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import example.angularspring.dao.ContactDao;
import example.angularspring.dto.ContactCity;

@Service("contactService")
public class ContactServiceImpl implements ContactService {
	
	@Autowired
	ContactDao contactdao;

	@Override
	public List<ContactCity> getContacts() {
		// TODO Auto-generated method stub
		return contactdao.getContacts();
	}
}
