package example.angularspring.dao;

import java.util.List;

import example.angularspring.dto.ContactCity;

public interface ContactDao {
	public List<ContactCity> getContacts();
}
