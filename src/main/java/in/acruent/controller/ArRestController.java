package in.acruent.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.acruent.entity.CitizenApp;
import in.acruent.service.CitizenAppService;

@RestController
public class ArRestController {
	
	@Autowired
	private CitizenAppService service;
	
	@PostMapping("/app")
	public ResponseEntity<String> createCitizenApp(@RequestBody CitizenApp app){
		
		Integer appId = service.createApplication(app);
		
		if(appId>0) {
			return new ResponseEntity<>("App created with app Id : "+appId,HttpStatus.OK);
		}else {
			return new ResponseEntity<>("Invalid Ssn",HttpStatus.BAD_REQUEST);
		}
	}
	
	

}
