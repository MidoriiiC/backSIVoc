package fr.iutparis8.CSID.backSIVoc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.iutparis8.CSID.backSIVoc.domain.ArticleEntity;
import fr.iutparis8.CSID.backSIVoc.domain.EventEntity;

@Repository
public interface ArticleRepository extends JpaRepository<ArticleEntity,Integer>{

	ArticleEntity findByTitle(String title);
	public List<ArticleEntity> findAllByOrderByIdAsc();

}