package fr.iutparis8.CSID.backSIVoc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.iutparis8.CSID.backSIVoc.domain.EventEntity;

@Repository
public interface EventRepository extends JpaRepository<EventEntity,Integer>{

	EventEntity findByName(String name);

}
