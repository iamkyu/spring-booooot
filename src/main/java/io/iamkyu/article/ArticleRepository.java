package io.iamkyu.article;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

/**
 * @author Kj Nam
 * @since 2017-04-08
 */
@Repository
public class ArticleRepository {
    @Autowired DataSource dataSource;

    public void add(Article article) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        String sql = "INSERT INTO ARTICLE (ID, TITLE, AUTHOR, BODY, CREATED) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql,
                        article.getId(),
                        article.getTitle(),
                        article.getAuthor(),
                        article.getBody(),
                        article.getCreated());
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
                    article.setCreated(rs.getTimestamp("CREATED"));
                    return article;
                });
    }

    public void deleteAll() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        String sql = "DELETE FROM ARTICLE";
        jdbcTemplate.update(sql);
    }
}
