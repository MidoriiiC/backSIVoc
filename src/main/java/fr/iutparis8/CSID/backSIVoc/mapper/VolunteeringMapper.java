package fr.iutparis8.CSID.backSIVoc.mapper;

import java.util.ArrayList;
import java.util.List;

import fr.iutparis8.CSID.backSIVoc.domain.EventEntity;
import fr.iutparis8.CSID.backSIVoc.domain.VolunteeringEntity;
import fr.iutparis8.CSID.backSIVoc.dto.VolunteeringDTO;
import fr.iutparis8.CSID.backSIVoc.model.Volunteering;

public class VolunteeringMapper {

	public static List<Volunteering> listEntityToListObject(List<VolunteeringEntity> toConvert) {
		if (toConvert == null)
			return null;
		List<Volunteering> converted = new ArrayList<Volunteering>();
		for (VolunteeringEntity v : toConvert) {
			converted.add(VolunteeringMapper.entityToObject(v));
		}
		return converted;
	}

	public static List<VolunteeringDTO> listObjectToListDTO(List<Volunteering> toConvert) {
		if (toConvert == null)
			return null;
		List<VolunteeringDTO> converted = new ArrayList<VolunteeringDTO>();
		for (Volunteering v : toConvert) {
			converted.add(VolunteeringMapper.objectToDTO(v));
		}
		return converted;
	}

	public static List<Volunteering> listDTOToListObject(List<VolunteeringDTO> toConvert) {
		if (toConvert == null)
			return null;
		List<Volunteering> converted = new ArrayList<Volunteering>();
		for (VolunteeringDTO v : toConvert) {
			converted.add(VolunteeringMapper.DTOToObject(v));
		}
		return converted;
	}

	public static List<VolunteeringEntity> listObjectToListEntity(List<Volunteering> toConvert) {
		if (toConvert == null)
			return null;
		List<VolunteeringEntity> converted = new ArrayList<VolunteeringEntity>();
		for (Volunteering v : toConvert) {
			converted.add(VolunteeringMapper.objectToEntity(v));
		}
		return converted;
	}

	public static Volunteering entityToObject(VolunteeringEntity v) {
		return new Volunteering(v.getIdVolunteering(), v.getLabel(), UserMapper.userEntityToUser(v.getVolunteer()),
				v.getDescription(), v.getScheldule(), v.getEvent().getId());
	}

	public static VolunteeringDTO objectToDTO(Volunteering v) {
		return new VolunteeringDTO(v.getIdVolunteering(), v.getLabel(), UserMapper.userToUserDTO(v.getVolunteer()),
				v.getDescription(), v.getScheldule(), v.getEventId());
	}

	public static Volunteering DTOToObject(VolunteeringDTO v) {
		return new Volunteering(v.getIdVolunteering(), v.getLabel(), UserMapper.userDTOtoUser(v.getVolunteer()),
				v.getDescription(), v.getScheldule(), v.getEventId());
	}

	public static VolunteeringEntity objectToEntity(Volunteering v) {
		EventEntity e = new EventEntity();
		e.setId(v.getEventId());
		return new VolunteeringEntity(v.getIdVolunteering(), v.getLabel(),
				UserMapper.userToUserEntity(v.getVolunteer()), v.getDescription(), v.getScheldule(), e);
	}

}
