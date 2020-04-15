package fr.iutparis8.CSID.backSIVoc.Controleur;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.iutparis8.CSID.backSIVoc.DTO.EvenementDTO;
import fr.iutparis8.CSID.backSIVoc.Service.EvenementService;

@RestController
@RequestMapping("/evenements")
public class EvenementControlleur {
	
	private EvenementService service;
	
	@Autowired
	public EvenementControlleur(EvenementService es) {
		this.service = es;
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping
	public List<EvenementDTO> index() {
		return this.service.getEvenements();
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping("/{id}")
	public EvenementDTO evenementParId(@PathVariable int id) {
		return this.service.getEvenementParId(id);
	}

}
