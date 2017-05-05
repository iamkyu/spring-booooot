package io.iamkyu.article;

import io.iamkyu.paging.Page;
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
//        articleService.deleteAll();
    }

    @Test
    public void 게시물을_작성한다() {
        //given
        ArticleCreateRequest request = new ArticleCreateRequest(
                100L, "my-title", "my-author", "my-body"
        );

        //when
        Article article = articleService.createArticle(request);

        //then
        assertThat(article.getId(), is(100L));
        assertThat(article.getTitle(), is("my-title"));
        assertThat(article.getAuthor(), is("my-author"));
        assertThat(article.getBody(), is("my-body"));
        assertThat(article.getCreated(), notNullValue());
    }

    @Test
    public void 게시물을_조회한다() {
        //given
        ArticleCreateRequest request = new ArticleCreateRequest(
                101L, "my-title", "my-author", "my-body"
        );
        articleService.createArticle(request);

        //when
        Article article = articleService.getArticle(101L);

        //then
        assertThat(article.getId(), is(101L));
        assertThat(article.getTitle(), is("my-title"));
        assertThat(article.getAuthor(), is("my-author"));
        assertThat(article.getBody(), is("my-body"));
        assertThat(article.getCreated(), notNullValue());
    }

    @Test
    public void 게시물을_조회한다_assert_j() {
        //given
        ArticleCreateRequest request = new ArticleCreateRequest(
                101L, "my-title", "my-author", "my-body"
        );
        articleService.createArticle(request);

        //when
        Article article = articleService.getArticle(101L);

        //then
        //generate command: mvn assertj:generate-assertions
        ArticleAssert.assertThat(article)
                .hasAuthor("my-author")
                .hasTitle("my-title")
                .hasBody("my-body");
    }

    @Test
    public void 한_페이지에는_10개의_게시글이_있다() {
        //given
        final int PAGE_NUMBER = 1;

        //when
        Page<Article> page = articleService.findAll(PAGE_NUMBER);

        //then
        assertThat(page.getNumber()+1, is(1));
        assertThat(page.getSize(), is(10));
    }
}