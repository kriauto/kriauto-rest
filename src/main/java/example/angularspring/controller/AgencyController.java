package example.angularspring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import example.angularspring.dto.Agency;
import example.angularspring.dto.Profile;
import example.angularspring.dto.ResponseMessage;
import example.angularspring.service.AgencyService;
import example.angularspring.service.ProfileService;

/**
 * Controller for agency actions.
 */
@Controller
public class AgencyController {
	
	@Autowired
    private AgencyService agencyService;
	
	@Autowired
    private ProfileService profileService;
	
	@RequestMapping(value = "/getAgency", method = RequestMethod.GET)
    @ResponseBody
    public Agency getAgency(@RequestHeader(value="Authorization") String authorization) {
    	System.out.println("Begin getAgency -->"+authorization);
    	String token = authorization.replaceAll("Basic", "");
    	Profile profile = profileService.getProfileByToken(token);
    	if(null == profile){
    		throw new IllegalArgumentException("ACTION_FAILED");
    	}
    	Agency agency = agencyService.getAgencyByToken(token);
    	return agency;
    }
	
	@RequestMapping(value = "/updateAgency", method = RequestMethod.POST)
    @ResponseBody
    public ResponseMessage updateAgency(@RequestHeader(value="Authorization") String authorization, @RequestBody Agency agency) {
    	System.out.println("Begin updateAgency -->"+agency);
    	String token = authorization.replaceAll("Basic", "");
    	Profile profile = profileService.getProfileByToken(token);
    	if(null == profile){
    		throw new IllegalArgumentException("ACTION_FAILED");
    	}
    	agencyService.updateAgency(agency);
    	return new ResponseMessage(ResponseMessage.Type.success, null,null);
    }

}
