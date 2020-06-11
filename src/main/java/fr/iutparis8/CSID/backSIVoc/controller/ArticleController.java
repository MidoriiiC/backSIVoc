package fr.iutparis8.CSID.backSIVoc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.iutparis8.CSID.backSIVoc.dto.ArticleDTO;
import fr.iutparis8.CSID.backSIVoc.mapper.ArticleMapper;
import fr.iutparis8.CSID.backSIVoc.model.Article;
import fr.iutparis8.CSID.backSIVoc.service.ArticleService;

@RestController
@RequestMapping("/articles")
public class ArticleController {
	
	private ArticleService service;
	
	@Autowired
	public ArticleController(ArticleService as) {
		this.service = as;
	}
	
	@CrossOrigin(origins = "*")
	@PutMapping("/{id}")
	public ResponseEntity<?> modifyArticle(@PathVariable int id, @RequestBody ArticleDTO article){
        if(id != article.getId()) {
    		return ResponseEntity.badRequest().build();
        }
        Article articleModifie = this.service.modify(ArticleMapper.DtoToObject(article));
        return ResponseEntity.created(null).body(ArticleMapper.objectToDTO(articleModifie));
	}
	
	@CrossOrigin(origins = "*")
	@PostMapping("/create")
	public ResponseEntity<?> createArticle(@RequestBody ArticleDTO a) {
		Article nouveau = this.service.createArticle(ArticleMapper.DtoToObject(a));
		if(nouveau != null) {
			return ResponseEntity.created(null).body(ArticleMapper.objectToDTO(nouveau));
		}
		return ResponseEntity.badRequest().build();
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping("/{id}")
	public ArticleDTO articleById(@PathVariable int id) {
		return ArticleMapper.objectToDTO(this.service.getArticleById(id));
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping
	public List<ArticleDTO> allArticles(){
		List<Article> articles = this.service.getAllArticles();
		return ArticleMapper.listObjectToListDTO(articles);
	}

}
