package fr.iutparis8.CSID.backSIVoc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.iutparis8.CSID.backSIVoc.domain.UtilisateurEntity;
import fr.iutparis8.CSID.backSIVoc.model.Utilisateur;

@Repository
public interface UtilisateurRepository extends JpaRepository<UtilisateurEntity,Integer>{
	
	 Utilisateur findByUsername(String username);

}
