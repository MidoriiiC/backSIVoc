package fr.iutparis8.CSID.backSIVoc.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.iutparis8.CSID.backSIVoc.Mapper.ArticleMapper;
import fr.iutparis8.CSID.backSIVoc.Objets.Article;
import fr.iutparis8.CSID.backSIVoc.Repository.ArticleRepository;
import fr.iutparis8.CSID.backSIVoc.domain.ArticleEntity;

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
