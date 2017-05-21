package io.iamkyu.article.infrastructure;

import io.iamkyu.article.model.Article;
import io.iamkyu.paging.Page;
import io.iamkyu.paging.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Timestamp;
import java.util.List;

/**
 * @author Kj Nam
 * @since 2017-04-08
 */
@Repository
public class ArticleJdbcRepository<T> {
    @Autowired DataSource dataSource;

    public void add(Article article) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        String sql = "INSERT INTO ARTICLE (ID, TITLE, AUTHOR, BODY, CREATED) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql,
                        article.getId(),
                        article.getTitle(),
                        article.getAuthor(),
                        article.getBody(),
                        Timestamp.valueOf(article.getCreated()));
    }

    public Article get(Long id) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        String sql = "SELECT ID, TITLE, AUTHOR, BODY, CREATED FROM ARTICLE WHERE ID = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, (rs, i) -> {
                    Article article = new Article();
                    article.setId(rs.getLong("ID"));
                    article.setTitle(rs.getString("TITLE"));
                    article.setAuthor(rs.getString("AUTHOR"));
                    article.setBody(rs.getString("BODY"));
                    article.setCreated(rs.getTimestamp("CREATED").toLocalDateTime());
                    return article;
                });
    }

    public void deleteAll() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        String sql = "DELETE FROM ARTICLE";
        jdbcTemplate.update(sql);
    }

    private int findAll() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        String sql = "SELECT count(*) FROM ARTICLE";
        int total = jdbcTemplate.queryForObject(sql, Integer.class);

        return total;
    }

    public Page<T> findAll(Pageable pageable) {
        int first = pageable.getPageNumber() * pageable.getPageSize();
        int max = pageable.getPageSize();

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        String sql = "SELECT ID, TITLE, AUTHOR, BODY, CREATED FROM ARTICLE LIMIT ? OFFSET ?";

        List<Article> articles = jdbcTemplate.query(
                sql, new Object[]{max, first}, (rs, rowNum) -> {
                    Article article = new Article();
                    article.setId(rs.getLong("id"));
                    article.setTitle(rs.getString("title"));
                    article.setAuthor(rs.getString("author"));
                    article.setBody(rs.getString("body"));
                    article.setCreated(rs.getTimestamp("created").toLocalDateTime());
                    return article;
                });

        int total = findAll();
        Page list = new Page<>(articles, total, pageable);

        return list;
    }
}
