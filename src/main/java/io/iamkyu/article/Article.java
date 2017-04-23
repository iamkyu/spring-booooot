package io.iamkyu.article;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author Kj Nam
 * @since 2017-04-08
 */
@Data
@NoArgsConstructor
public class Article {
    private Long id;
    private String title;
    private String author;
    private String body;
    private LocalDateTime created;

    public Article(Long id, String title, String author, String body) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.body = body;
        this.created = LocalDateTime.now();
    }
}
