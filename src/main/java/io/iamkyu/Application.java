package io.iamkyu;

import io.iamkyu.article.Article;
import io.iamkyu.article.ArticleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    CommandLineRunner runner(ArticleRepository repository) {
        return args ->
                Arrays.asList(
                    new Article(1L,  "title1",  "author", "body"),
                    new Article(2L,  "title2",  "author", "body"),
                    new Article(3L,  "title3",  "author", "body"),
                    new Article(4L,  "title4",  "author", "body"),
                    new Article(5L,  "title5",  "author", "body"),
                    new Article(6L,  "title6",  "author", "body"),
                    new Article(7L,  "title7",  "author", "body"),
                    new Article(8L,  "title8",  "author", "body"),
                    new Article(9L,  "title9",  "author", "body"),
                    new Article(10L, "title10", "author", "body"),
                    new Article(11L, "title11", "author", "body"),
                    new Article(12L, "title12", "author", "body")
                ).forEach(x -> repository.add(x));
    }
}
