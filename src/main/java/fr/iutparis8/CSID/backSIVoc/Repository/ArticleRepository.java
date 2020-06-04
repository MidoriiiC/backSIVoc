package fr.iutparis8.CSID.backSIVoc.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.iutparis8.CSID.backSIVoc.domain.ArticleEntity;

@Repository
public interface ArticleRepository extends JpaRepository<ArticleEntity,Integer>{

	ArticleEntity findByTitle(String title);

}