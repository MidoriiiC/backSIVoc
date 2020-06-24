package fr.iutparis8.CSID.backSIVoc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.iutparis8.CSID.backSIVoc.domain.EventEntity;
import fr.iutparis8.CSID.backSIVoc.mapper.EventMapper;
import fr.iutparis8.CSID.backSIVoc.model.Event;
import fr.iutparis8.CSID.backSIVoc.model.Volunteering;
import fr.iutparis8.CSID.backSIVoc.repository.EventRepository;

@Service
public class EventService {

	private EventRepository er;
	private VolunteeringService vs;

	@Autowired
	public EventService(EventRepository er, VolunteeringService vs) {
		this.er = er;
		this.vs = vs;
	}

	public Event getEventById(Integer id) {
		return EventMapper.entityToObject(this.er.getOne(id));
	}

	public Event createEvent(Event e) {
		return EventMapper.entityToObject(this.er.save(EventMapper.objectToEntity(e)));
	}

	public Event modify(Event e) {
		EventEntity eventModified = this.er.save(EventMapper.objectToEntity((e)));
		return EventMapper.entityToObject(eventModified);
	}

	public List<Event> getAllEvents() {
		List<EventEntity> events = this.er.findAllByOrderByIdAsc();
		return EventMapper.listEntityToListObject(events);
	}

	public boolean saveVolunteer(Volunteering v) {
		this.vs.modify(v);
		return true;
	}
}
