package fr.iutparis8.CSID.backSIVoc.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.iutparis8.CSID.backSIVoc.dto.EventDTO;
import fr.iutparis8.CSID.backSIVoc.mapper.EventMapper;
import fr.iutparis8.CSID.backSIVoc.model.Event;
import fr.iutparis8.CSID.backSIVoc.service.EventService;

@Transactional
@RestController
@RequestMapping("/events")
public class EventControlleur {
	
	private EventService service;
	
	@Autowired
	public EventControlleur(EventService es) {
		this.service = es;
	}
	
	@CrossOrigin(origins = "*")
	@PutMapping("/{id}")
	public ResponseEntity<?> modifyEvent(@PathVariable int id, @RequestBody EventDTO event){
        if(id != event.getId()) {
    		return ResponseEntity.badRequest().build();
        }
        Event eventModified = this.service.modify(EventMapper.dtoToObject(event));
        return ResponseEntity.created(null).body(EventMapper.objectToDto(eventModified));
	}
	
	@CrossOrigin(origins = "*")
	@PostMapping("/create")
	public ResponseEntity<?> creerEvent(@RequestBody EventDTO e) {
		Event newEvent = this.service.createEvent(EventMapper.dtoToObject(e));
		if(newEvent != null) {
			return ResponseEntity.created(null).body(EventMapper.objectToDto(newEvent));
		}
		return ResponseEntity.badRequest().build();
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping("/{id}")
	public EventDTO eventParId(@PathVariable int id) {
		return EventMapper.objectToDto(this.service.getEventById(id));
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping
	public List<EventDTO> getAllEvent() {
		List<Event> listE = this.service.getAllEvents();
		List<EventDTO> listDTO = EventMapper.listObjectToListDTO(listE);
		return listDTO;
	}

}
