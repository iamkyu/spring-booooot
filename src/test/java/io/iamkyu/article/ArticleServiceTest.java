package io.iamkyu.article;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.*;

/**
 * @author Kj Nam
 * @since 2017-04-08
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class ArticleServiceTest {

    @Autowired
    ArticleService articleService;

    @Before
    public void setUp() {
        articleService.deleteAll();
    }

    @Test
    public void 게시물을_작성한다() {
        //given
        ArticleCreateRequest request = new ArticleCreateRequest(
                1L, "my-title", "my-author", "my-body"
        );

        //when
        Article article = articleService.createArticle(request);

        //then
        assertThat(article.getId(), is(1L));
        assertThat(article.getTitle(), is("my-title"));
        assertThat(article.getAuthor(), is("my-author"));
        assertThat(article.getBody(), is("my-body"));
        assertThat(article.getCreated(), notNullValue());
    }

    @Test
    public void 게시물을_조회한다() {
        //given
        ArticleCreateRequest request = new ArticleCreateRequest(
                1L, "my-title", "my-author", "my-body"
        );
        articleService.createArticle(request);

        //when
        Article article = articleService.getArticle(1L);

        //then
        assertThat(article.getId(), is(1L));
        assertThat(article.getTitle(), is("my-title"));
        assertThat(article.getAuthor(), is("my-author"));
        assertThat(article.getBody(), is("my-body"));
        assertThat(article.getCreated(), notNullValue());
    }
}