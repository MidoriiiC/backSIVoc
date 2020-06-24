package fr.iutparis8.CSID.backSIVoc.mapper;

import java.util.ArrayList;
import java.util.List;

import fr.iutparis8.CSID.backSIVoc.domain.ArticleEntity;
import fr.iutparis8.CSID.backSIVoc.dto.ArticleDTO;
import fr.iutparis8.CSID.backSIVoc.model.Article;

public class ArticleMapper {

	public static Article entityToObject(ArticleEntity a) {
		return new Article(a.getId(), a.getTitle(), a.getContent(), a.getAuthor(), a.getDate(), a.getHour(),
				a.getIllustration());
	}

	public static ArticleDTO objectToDTO(Article a) {
		return new ArticleDTO(a.getId(), a.getTitle(), a.getContent(), a.getAuthor(), a.getDate(), a.getHour(),
				a.getIllustration());
	}

	public static Article DtoToObject(ArticleDTO a) {
		return new Article(a.getId(), a.getTitle(), a.getContent(), a.getAuthor(), a.getDate(), a.getHour(),
				a.getIllustration());
	}

	public static ArticleEntity objectToEntity(Article a) {
		return new ArticleEntity(a.getId(), a.getTitle(), a.getContent(), a.getAuthor(), a.getDate(), a.getHour(),
				a.getIllustration());
	}

	public static List<Article> listEntityToListObject(List<ArticleEntity> articles) {
		List<Article> articlesObject = new ArrayList<Article>();
		for (ArticleEntity a : articles) {
			articlesObject.add(new Article(a.getId(), a.getTitle(), a.getContent(), a.getAuthor(), a.getDate(),
					a.getHour(), a.getIllustration()));
		}
		return articlesObject;
	}

	public static List<ArticleDTO> listObjectToListDTO(List<Article> articles) {
		List<ArticleDTO> articlesDTO = new ArrayList<ArticleDTO>();
		for (Article a : articles) {
			articlesDTO.add(new ArticleDTO(a.getId(), a.getTitle(), a.getContent(), a.getAuthor(), a.getDate(),
					a.getHour(), a.getIllustration()));
		}
		return articlesDTO;
	}

}
