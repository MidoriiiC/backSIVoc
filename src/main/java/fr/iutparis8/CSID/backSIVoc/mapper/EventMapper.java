package fr.iutparis8.CSID.backSIVoc.mapper;

import java.util.ArrayList;
import java.util.List;

import fr.iutparis8.CSID.backSIVoc.domain.EventEntity;
import fr.iutparis8.CSID.backSIVoc.dto.EventDTO;
import fr.iutparis8.CSID.backSIVoc.model.Event;

public class EventMapper {
	public static Event entityToObject(EventEntity event) {
		return new Event(event.getId(), event.getName(), event.getContentArticle(),
				event.getImage(), event.getLinkVideo(), event.getDate(), event.getHour(),
				event.getPlace(), event.getOrganizer(), VolunteeringMapper.listEntityToListObject(event.getVolunteerings()));
	}
	
	public static EventDTO objectToDto(Event event) {
		return new EventDTO(event.getId(), event.getName(), event.getContentArticle(),
				event.getImage(), event.getLinkVideo(), event.getDate(), event.getHour(),
				event.getPlace(), event.getOrganizer(), VolunteeringMapper.listObjectToListDTO(event.getVolunteerings()));
	}
	
	public static EventEntity objectToEntity(Event event) {
		return new EventEntity(event.getId(), event.getName(), event.getContentArticle(),
				event.getImage(), event.getLinkVideo(), event.getDate(), event.getHour(),
				event.getPlace(), event.getOrganizer(), VolunteeringMapper.listObjectToListEntity(event.getVolunteerings()));
	}
	
	public static Event dtoToObject(EventDTO event) {
		return new Event(event.getId(), event.getName(), event.getContentArticle(),
				event.getImage(), event.getLinkVideo(), event.getDate(), event.getHour(),
				event.getPlace(), event.getOrganizer(), VolunteeringMapper.listDTOToListObject(event.getVolunteerings()));
	}

	public static List<Event> listEntityToListObject(List<EventEntity> events) {
		List<Event> eventsObjet = new ArrayList<Event>();
		for(EventEntity event: events) {
			eventsObjet.add(new Event(event.getId(), event.getName(), event.getContentArticle(),
				event.getImage(), event.getLinkVideo(), event.getDate(), event.getHour(),
				event.getPlace(), event.getOrganizer(), VolunteeringMapper.listEntityToListObject(event.getVolunteerings())));
		}
		return eventsObjet;
	}
	
	public static List<EventDTO> listObjectToListDTO(List<Event> events) {
		List<EventDTO> eventsDTO = new ArrayList<EventDTO>();
		for(Event event: events) {
			eventsDTO.add(new EventDTO(event.getId(), event.getName(), event.getContentArticle(),
				event.getImage(), event.getLinkVideo(), event.getDate(), event.getHour(),
				event.getPlace(), event.getOrganizer(), VolunteeringMapper.listObjectToListDTO(event.getVolunteerings())));
		}
		return eventsDTO;
	}
}
