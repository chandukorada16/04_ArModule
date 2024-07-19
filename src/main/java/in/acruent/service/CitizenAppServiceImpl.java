package in.acruent.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import in.acruent.entity.CitizenApp;
import in.acruent.repo.CitizenAppRepo;

@Service
public class CitizenAppServiceImpl implements CitizenAppService{
	
	@Autowired
	private CitizenAppRepo repo;

	@Override
	public Integer createApplication(CitizenApp app) {
		
		String url="http://localhost:8787/state/{ssn}";
		
		RestTemplate rt=new RestTemplate();
		  ResponseEntity<String> responseEntity = rt.getForEntity(url, String.class,app.getSsn());
		  String stateName = responseEntity.getBody();
		  
		  if("New York".equals(stateName)) {
			  
			  CitizenApp entity=new CitizenApp();
			  BeanUtils.copyProperties(app, entity);
			  entity.setStateName(stateName);
			  CitizenApp save = repo.save(entity);
			  
			  return save.getAppID();
			  
			  
			  
		  }
		
		return 0;
	}

}
