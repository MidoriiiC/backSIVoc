package fr.iutparis8.CSID.backSIVoc.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.iutparis8.CSID.backSIVoc.Entités.UtilisateurEntity;

@Repository
public interface UtilisateurEntityRepository extends JpaRepository<UtilisateurEntity,Integer>{
	
    UtilisateurEntity findOneByUsername(String username);

    UtilisateurEntity getByUsername(String username); // => throws EntityNotFoundException

}
