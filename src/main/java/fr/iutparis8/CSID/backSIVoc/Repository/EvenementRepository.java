package fr.iutparis8.CSID.backSIVoc.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.iutparis8.CSID.backSIVoc.Entités.EvenementEntite;

@Repository
public interface EvenementRepository extends JpaRepository<EvenementEntite,Integer>{

	EvenementEntite findByNom(String nom);

}
