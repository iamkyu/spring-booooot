package io.iamkyu.article;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Kj Nam
 * @since 2017-04-08
 */
@Service
public class ArticleService {
    @Autowired private ArticleRepository repository;

    public Article createArticle(ArticleCreateRequest request) {
        Article article = new Article(
                request.getId(), request.getTitle(),
                request.getAuthor(), request.getBody()
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
}
