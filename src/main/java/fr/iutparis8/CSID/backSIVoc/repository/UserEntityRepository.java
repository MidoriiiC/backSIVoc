package fr.iutparis8.CSID.backSIVoc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.iutparis8.CSID.backSIVoc.domain.UserEntity;

@Repository
public interface UserEntityRepository extends JpaRepository<UserEntity,Integer>{
	
    UserEntity findOneByUsername(String username);

    UserEntity getByUsername(String username); // => throws EntityNotFoundException
    


}
