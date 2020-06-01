package fr.iutparis8.CSID.backSIVoc.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.iutparis8.CSID.backSIVoc.Entités.EvenementEntite;
import fr.iutparis8.CSID.backSIVoc.Entités.VolunteeringEntity;
import fr.iutparis8.CSID.backSIVoc.Mapper.VolunteeringMapper;
import fr.iutparis8.CSID.backSIVoc.Objets.Volunteering;
import fr.iutparis8.CSID.backSIVoc.Repository.VolunteeringRepository;

@Service
public class VolunteeringService {
	
	private VolunteeringRepository vr;
	
	@Autowired
	public VolunteeringService(VolunteeringRepository vr) {
		this.vr = vr;
	}
	
	public List<Volunteering> getVolunteersByEventId(EvenementEntite e) {
		List<VolunteeringEntity> result = this.vr.findByEvent(e); 
		
		return VolunteeringMapper.listEntityToListObject(result);
	}

}
