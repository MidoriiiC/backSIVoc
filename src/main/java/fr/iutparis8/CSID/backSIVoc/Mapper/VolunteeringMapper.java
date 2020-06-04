package fr.iutparis8.CSID.backSIVoc.Mapper;

import java.util.ArrayList;
import java.util.List;

import fr.iutparis8.CSID.backSIVoc.Objets.Volunteering;
import fr.iutparis8.CSID.backSIVoc.domain.VolunteeringEntity;

public class VolunteeringMapper {

	public static List<Volunteering> listEntityToListObject(List<VolunteeringEntity> toConvert) {
		List<Volunteering> converted = new ArrayList<Volunteering>();
		for(VolunteeringEntity v : toConvert) {
			converted.add(new Volunteering());
		}
		return converted;
	}
	
}
