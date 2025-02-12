package org.wildcodeschool.myblog.article;

import org.wildcodeschool.myblog.category.CategoryRepo;
import org.wildcodeschool.myblog.image.ImageRepo;
import org.wildcodeschool.myblog.author.AuthorRepo;
import org.wildcodeschool.myblog.category.Category;
import org.wildcodeschool.myblog.image.Image;
import org.wildcodeschool.myblog.author.Author;
import org.wildcodeschool.myblog.exceptions.ResourceNotFoundException;

import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ArticleService {

    private final CategoryRepo categoryRepo;
    private final ImageRepo imageRepo;
    private final AuthorRepo authorRepo;
    private final ArticleRepo articleRepo;

    public ArticleService(CategoryRepo categoryRepo, ImageRepo imageRepo, AuthorRepo authorRepo, ArticleRepo articleRepo) {
        this.categoryRepo = categoryRepo;
        this.imageRepo = imageRepo;
        this.authorRepo = authorRepo;
        this.articleRepo = articleRepo;
    }

    public Article addArticle(CreateArticleWithIdsDTO dto) {
        Article article = CreateArticleWithIdsDTO.toEntity(dto);
        Category category = categoryRepo.findById(dto.getCategoryId()).orElseThrow(() -> new ResourceNotFoundException("Category not found"));
        Image image = imageRepo.findById(dto.getImageId()).orElseThrow(() -> new ResourceNotFoundException("Image not found"));
        List<Author> authorIds = authorRepo.findAllById(dto.getAuthorIds());
        article.setCategory(category);
        article.setImage(image);
        article.setAuthors(authorIds);
        return articleRepo.save(article);
    }
}
