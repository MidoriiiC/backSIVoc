package fr.iutparis8.CSID.backSIVoc.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.iutparis8.CSID.backSIVoc.Entités.UtilisateurEntity;
import fr.iutparis8.CSID.backSIVoc.Objets.Utilisateur;

@Repository
public interface UtilisateurRepository extends JpaRepository<UtilisateurEntity,Integer>{
	 Utilisateur findByUsername(String username);

}