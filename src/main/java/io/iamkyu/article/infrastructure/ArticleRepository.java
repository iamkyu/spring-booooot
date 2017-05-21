package io.iamkyu.article.infrastructure;

import io.iamkyu.article.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Kj Nam
 * @since 2017-05-20
 */
@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {
}
