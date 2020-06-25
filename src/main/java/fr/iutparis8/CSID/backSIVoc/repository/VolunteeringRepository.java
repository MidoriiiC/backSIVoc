package fr.iutparis8.CSID.backSIVoc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.iutparis8.CSID.backSIVoc.domain.EventEntity;
import fr.iutparis8.CSID.backSIVoc.domain.VolunteeringEntity;

@Repository
public interface VolunteeringRepository extends JpaRepository<VolunteeringEntity, Integer> {

	public VolunteeringEntity findByLabel(String label);

	public List<VolunteeringEntity> findByEvent(EventEntity e);

}
