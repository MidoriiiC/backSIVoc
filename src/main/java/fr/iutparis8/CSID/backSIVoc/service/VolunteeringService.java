package fr.iutparis8.CSID.backSIVoc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.iutparis8.CSID.backSIVoc.domain.EventEntity;
import fr.iutparis8.CSID.backSIVoc.domain.VolunteeringEntity;
import fr.iutparis8.CSID.backSIVoc.mapper.VolunteeringMapper;
import fr.iutparis8.CSID.backSIVoc.model.Volunteering;
import fr.iutparis8.CSID.backSIVoc.repository.VolunteeringRepository;

@Service
public class VolunteeringService {
	
	private VolunteeringRepository vr;
	
	@Autowired
	public VolunteeringService(VolunteeringRepository vr) {
		this.vr = vr;
	}
	
	public List<Volunteering> getVolunteersByEventId(EventEntity e) {
		List<VolunteeringEntity> result = this.vr.findByEvent(e); 
		
		return VolunteeringMapper.listEntityToListObject(result);
	}

}
