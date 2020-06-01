package fr.iutparis8.CSID.backSIVoc.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.iutparis8.CSID.backSIVoc.Entités.EvenementEntite;
import fr.iutparis8.CSID.backSIVoc.Mapper.EvenementMapper;
import fr.iutparis8.CSID.backSIVoc.Objets.Evenement;
import fr.iutparis8.CSID.backSIVoc.Repository.EvenementRepository;

@Service
public class EvenementService {

	private EvenementRepository er;
	
	@Autowired
	public EvenementService(EvenementRepository er) {
		this.er = er;
	}
	
	public Evenement getEvenementParId(Integer id) {
		return EvenementMapper.entiteVersObjet(this.er.getOne(id));
	}
	
	public Evenement creerEvenement(Evenement e) {
		return EvenementMapper.entiteVersObjet(this.er.save(EvenementMapper.objetVersEntite(e)));
	}

	public Evenement modifier(Evenement e) {
		EvenementEntite evenementModifie = this.er.save(EvenementMapper.objetVersEntite((e)));
        return EvenementMapper.entiteVersObjet(evenementModifie);
	}

	public List<Evenement> getAllEvenements() {
		List<EvenementEntite> evenements = this.er.findAll();
		return EvenementMapper.listeEntiteVersListeObjet(evenements);
	}
}
