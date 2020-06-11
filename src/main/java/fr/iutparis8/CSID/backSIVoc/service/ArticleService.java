package fr.iutparis8.CSID.backSIVoc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.iutparis8.CSID.backSIVoc.domain.ArticleEntity;
import fr.iutparis8.CSID.backSIVoc.mapper.ArticleMapper;
import fr.iutparis8.CSID.backSIVoc.model.Article;
import fr.iutparis8.CSID.backSIVoc.repository.ArticleRepository;

@Service
public class ArticleService {

	private ArticleRepository ar;
	
	@Autowired
	public ArticleService(ArticleRepository ar) {
		this.ar = ar;
	}
	
	public Article getArticleById(Integer id) {
		return ArticleMapper.entityToObject(this.ar.getOne(id));
	}
	
	public Article createArticle(Article a) {
		return ArticleMapper.entityToObject(this.ar.save(ArticleMapper.objectToEntity(a)));
	}

	public Article modify(Article a) {
		ArticleEntity articleModified = this.ar.save(ArticleMapper.objectToEntity((a)));
        return ArticleMapper.entityToObject(articleModified);
	}

	public List<Article> getAllArticles() {
		List<ArticleEntity> articles = this.ar.findAll();
		return ArticleMapper.listEntityToListObject(articles);
	}
	
}
