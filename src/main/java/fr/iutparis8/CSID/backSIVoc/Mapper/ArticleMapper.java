package fr.iutparis8.CSID.backSIVoc.Mapper;

import fr.iutparis8.CSID.backSIVoc.DTO.ArticleDTO;
import fr.iutparis8.CSID.backSIVoc.Entités.ArticleEntity;
import fr.iutparis8.CSID.backSIVoc.Objets.Article;

public class ArticleMapper {

	public static Article entityToObject(ArticleEntity a) {
		return new Article(a.getId(), a.getTitle(), a.getContent(), a.getAuthor(), a.getDate(), a.getHour());
	}
	
	public static ArticleDTO objectToDTO(Article a) {
		return new ArticleDTO(a.getId(), a.getTitle(), a.getContent(), a.getAuthor(), a.getDate(), a.getHour());
	}
	
	public static Article DtoToObject(ArticleDTO a) {
		return new Article(a.getId(), a.getTitle(), a.getContent(), a.getAuthor(), a.getDate(), a.getHour());
	}
	
	public static ArticleEntity objectToEntity(Article a) {
		return new ArticleEntity(a.getId(), a.getTitle(), a.getContent(), a.getAuthor(), a.getDate(), a.getHour());
	}
	
}
