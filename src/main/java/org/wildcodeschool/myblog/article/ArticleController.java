package org.wildcodeschool.myblog.article;

import org.wildcodeschool.myblog.category.*;
import org.wildcodeschool.myblog.exceptions.*;
import org.wildcodeschool.myblog.image.ImageRepo;
import org.wildcodeschool.myblog.author.AuthorRepo;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/articles")
public class ArticleController {

    private final ArticleRepo articleRepo;
    private final ArticleService articleService;


    public ArticleController(ArticleRepo articleRepo, CategoryRepo categoryRepo, ImageRepo imageRepo, AuthorRepo authorRepo, ArticleService service) {
        this.articleRepo = articleRepo;
        this.articleService = service;
    }

    @GetMapping("/all")
    public List<Article> getAll() {
        return articleRepo.findAll();
    }


    @GetMapping("/{id}")
    public ResponseEntity<Article> getOne(@PathVariable Long id) {
        Article article = articleRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Article not found"));
        return ResponseEntity.ok(article);
    }


    @PostMapping
    public ResponseEntity<String> addArticle(@RequestBody CreateArticleDTO dto) {
        Article article = CreateArticleDTO.toEntity(dto);
        articleRepo.save(article);
        return ResponseEntity.ok("Article added");
    }


    @PostMapping("/add-with-ids")
    public ResponseEntity<String> addArticleWithIds(@Valid @RequestBody CreateArticleWithIdsDTO dto) {
        articleService.addArticle(dto);
        return ResponseEntity.ok("Article with ids added");
    }

}
