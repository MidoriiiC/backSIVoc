package fr.iutparis8.CSID.backSIVoc.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.iutparis8.CSID.backSIVoc.Entités.EvenementEntite;
import fr.iutparis8.CSID.backSIVoc.Entités.VolunteeringEntity;

@Repository
public interface VolunteeringRepository extends JpaRepository<VolunteeringEntity, Integer>{
	
	 public VolunteeringEntity findByLabel(String label);
	 public List<VolunteeringEntity> findByEvent(EvenementEntite e);

}
