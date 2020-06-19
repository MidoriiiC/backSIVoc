package fr.iutparis8.CSID.backSIVoc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.iutparis8.CSID.backSIVoc.domain.UserEntity;
import fr.iutparis8.CSID.backSIVoc.model.User;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Integer>{
	
	 User findByUsername(String username);

}
