package io.iamkyu.article;

import io.iamkyu.paging.Page;
import io.iamkyu.paging.PageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Kj Nam
 * @since 2017-04-08
 */
@Service
class ArticleService {
    @Autowired private ArticleRepository repository;
    
    private final int SIZE_EACH_PAGE = 10;

    Article createArticle(ArticleCreateRequest request) {
        Article article = new Article(
                request.getId(), request.getTitle(),
                request.getAuthor(), request.getBody()
        );
        repository.add(article);
        return article;
    }

    Article getArticle(long articleId) {
        return repository.get(articleId);
    }

    void deleteAll() {
        repository.deleteAll();
    }

    Page<Article> findAll(Integer pageNumber) {
        PageRequest request = new PageRequest(pageNumber - 1, SIZE_EACH_PAGE);
        Page<Article> page = repository.findAll(request);

        return page;
    }
}
