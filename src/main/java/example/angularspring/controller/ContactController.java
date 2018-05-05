package example.angularspring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import example.angularspring.dto.ContactCity;
import example.angularspring.dto.Profile;
import example.angularspring.service.ContactService;
import example.angularspring.service.ProfileService;

/**
 * Controller for contact actions.
 */
@Controller
public class ContactController {
	
	@Autowired
    private ContactService contactService;
	
	@Autowired
    private ProfileService profileService;
	
	@RequestMapping(value = "/getContacts", method = RequestMethod.GET)
    @ResponseBody
    public List<ContactCity> getContacts(){
       System.out.println("getContacts -->");
       return contactService.getContacts();
    }
}
