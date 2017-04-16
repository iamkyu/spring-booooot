package io.iamkyu.article;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Kj Nam
 * @since 2017-04-15
 */
@Controller
public class ArticleController {

    @Autowired ArticleService service;

    @GetMapping(value = "/article/{id}")
    public String getArticle(Model model, @PathVariable Long id) {
        Article article = service.getArticle(id);
        model.addAttribute("article", article);

        return "article";
    }

    @PostMapping("/article")
    public String createArticle(@ModelAttribute ArticleCreateRequest request) {
        service.createArticle(request);
        return "redirect:/article/" + request.getId();
    }

    @RequestMapping("/article/create")
    public String createArticleView() {
        return "createArticle";
    }
}
