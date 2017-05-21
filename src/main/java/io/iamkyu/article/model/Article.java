package io.iamkyu.article.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

/**
 * @author Kj Nam
 * @since 2017-05-20
 */
@Entity
@Data
@NoArgsConstructor
public class Article {
    @Id @GeneratedValue  private Long id;
    private String title;
    private String author;
    private String body;
    private LocalDateTime created;

    public Article(String title, String author, String body) {
        this.title = title;
        this.author = author;
        this.body = body;
        this.created = LocalDateTime.now();
    }
}
