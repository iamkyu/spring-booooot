package io.iamkyu;

import io.iamkyu.article.infrastructure.ArticleRepository;
import io.iamkyu.article.model.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.List;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Autowired ArticleRepository repository;

    @PostConstruct
    public void testCrud() {
        repository.save(new Article("title1", "iamkyu", "body"));
        repository.save(new Article("title2", "iamkyu", "body"));
        repository.save(new Article("title3", "iamkyu", "body"));
        repository.save(new Article("title4", "iamkyu", "body"));
        repository.save(new Article("title5", "iamkyu", "body"));

        List<Article> list = repository.findAll();
        for (Article each : list) {
            System.out.println(each);
        }
    }
}
