package io.iamkyu.article;

import io.iamkyu.paging.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * The type Article controller.
 *
 * @author Kj Nam
 * @since 2017 -04-15
 */
@Controller
public class ArticleController {
    @Autowired ArticleService service;

    @GetMapping("/article")
    public String index() {
        return "index";
    }

    /**
     * 게시글을 조회한다
     */
    @GetMapping("/article/{id}")
    public String getArticle(Model model, @PathVariable Long id) {
        Article article = service.getArticle(id);
        model.addAttribute("article", article);

        return "article";
    }

    /**
     * 게시글 생성 페이지를 호출한다
     */
    @GetMapping("/article/create")
    public String createArticleView() {
        return "createArticle";
    }

    /**
     * 게시글을 생성한다
     */
    @PostMapping("/article/create")
    public String createArticle(@ModelAttribute ArticleCreateRequest request) {
        service.createArticle(request);

        return "redirect:/article/" + request.getId();
    }

    /**
     * 게시글 목록을 조회한다
     */
    @GetMapping("/article/list")
    public String listArticle(Model model,
                              @RequestParam(required = false, defaultValue = "1") int page) {
        Page<Article> pages = service.findAll(page);
        List<Article> articles = pages.getContent();
        calculatePagination(model, pages);

        model.addAttribute("articles", articles);

        return "listArticle";
    }

    private void calculatePagination(Model model, Page pages) {
        int current = pages.getNumber() + 1;
        int begin = Math.max(1, current - 5);
        int end = Math.min(begin + 10, pages.getTotalPages());

        model.addAttribute("currentIndex", current);
        model.addAttribute("beginIndex", begin);
        model.addAttribute("endIndex", end);
    }
}
