package io.iamkyu.article;

import lombok.Data;

import java.sql.Timestamp;
import java.time.OffsetDateTime;

/**
 * @author Kj Nam
 * @since 2017-04-08
 */
@Data
public class Article {
    private Long id;
    private String title;
    private String author;
    private String body;
    private Timestamp created;

    public Article() {
    }

    public Article(Long id, String title, String author, String body) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.body = body;

        // http://stackoverflow.com/questions/30651210/convert-offsetdatetime-to-utc-timestamp
        this.created = new Timestamp(1000 * OffsetDateTime.now().toEpochSecond());
    }
}
