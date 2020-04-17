package fr.iutparis8.CSID.backSIVoc.Controleur;

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

import fr.iutparis8.CSID.backSIVoc.DTO.EvenementDTO;
import fr.iutparis8.CSID.backSIVoc.Mapper.EvenementMapper;
import fr.iutparis8.CSID.backSIVoc.Objets.Evenement;
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
	@PutMapping("/{id}")
	public ResponseEntity<?> modifierEvenement(@PathVariable int id, @RequestBody EvenementDTO evenement){
        if(id != evenement.getId()) {
    		return ResponseEntity.badRequest().build();
        }
        Evenement evenementModifie = this.service.modifier(EvenementMapper.DtoVersObjet(evenement));
        return ResponseEntity.created(null).body(EvenementMapper.objetVersDto(evenementModifie));
	}
	
	@CrossOrigin(origins = "*")
	@PostMapping("/creer")
	public ResponseEntity<?> creerEvenement(@RequestBody EvenementDTO e) {
		Evenement nouveau = this.service.creerEvenement(EvenementMapper.DtoVersObjet(e));
		if(nouveau != null) {
			return ResponseEntity.created(null).body(EvenementMapper.objetVersDto(nouveau));
		}
		return ResponseEntity.badRequest().build();
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping("/{id}")
	public EvenementDTO evenementParId(@PathVariable int id) {
		return EvenementMapper.objetVersDto(this.service.getEvenementParId(id));
	}

}
