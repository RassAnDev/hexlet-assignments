package exercise.controller;

import exercise.dto.ArticleDto;
import exercise.model.Article;
import exercise.repository.ArticleRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;


@RestController
@RequestMapping("/articles")
@RequiredArgsConstructor
public class ArticlesController {

    private final ArticleRepository articleRepository;

    @GetMapping(path = "")
    public Iterable<Article> getArticles() {
        return articleRepository.findAll();
    }

    @DeleteMapping(path = "/{id}")
    public void deleteArticle(@PathVariable long id) {
        articleRepository.deleteById(id);
    }

    // BEGIN
    @PostMapping("")
    public Article createArticle(@RequestBody ArticleDto articleDto) {
        Article newArticle = new Article();

        newArticle.setName(articleDto.getName());
        newArticle.setBody(articleDto.getBody());
        newArticle.setCategory(articleDto.getCategory());

        return this.articleRepository.save(newArticle);
    }

    @PatchMapping("/{id}")
    public Article updateArticle(@PathVariable long id, @RequestBody ArticleDto articleDto) {
        Article articleForUpdate = articleRepository.findById(id);

        articleForUpdate.setName(articleDto.getName());
        articleForUpdate.setBody(articleDto.getBody());
        articleForUpdate.setCategory(articleDto.getCategory());

        return this.articleRepository.save(articleForUpdate);
    }

    @GetMapping("/{id}")
    public Article showArticle(@PathVariable long id) {
        return this.articleRepository.findById(id);
    }
    // END
}
