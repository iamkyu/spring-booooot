package io.iamkyu.article.service;

import io.iamkyu.article.infrastructure.ArticleJdbcRepository;
import io.iamkyu.article.model.Article;
import io.iamkyu.article.dto.ArticleCreateRequest;
import io.iamkyu.paging.Page;
import io.iamkyu.paging.PageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Kj Nam
 * @since 2017-04-08
 */
@Service
public class ArticleService {
    @Autowired private ArticleJdbcRepository repository;
    
    private final int SIZE_EACH_PAGE = 10;

    public Article createArticle(ArticleCreateRequest request) {
        Article article = new Article(
                request.getTitle(), request.getAuthor(), request.getBody()
        );
        repository.add(article);
        return article;
    }

    public Article getArticle(long articleId) {
        return repository.get(articleId);
    }

    public void deleteAll() {
        repository.deleteAll();
    }

    public Page<Article> findAll(Integer pageNumber) {
        PageRequest request = new PageRequest(pageNumber - 1, SIZE_EACH_PAGE);
        Page<Article> page = repository.findAll(request);

        return page;
    }
}
