package org.wildcodeschool.myblog.article;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;
import java.util.List;

public class CreateArticleWithIdsDTO {

    @NotBlank(message = "Le titre ne peut pas être vide")
    @Size(min = 10, max = 100, message = "Le titre doit contenir entre 10 et 100 caractères")
    private String title;

    @NotBlank(message = "Le contenu ne peut pas être vide")
    private String content;

    @Positive(message = "L'id de la catégorie doit être positif")
    @NotNull(message = "L'id de la catégorie ne peut pas être vide")
    private Long categoryId;

    @Positive(message = "L'id de la catégorie doit être positif")
    @NotNull(message = "L'id de la catégorie ne peut pas être vide")
    private Long imageId;

    @NotNull(message = "L'id de la catégorie ne peut pas être vide")
    private List<Long> authorIds;

    @Valid
    @NotNull
    private TestDTO testDTO;

    public TestDTO getTestDTO() {
        return testDTO;
    }

    public void setTestDTO(TestDTO testDTO) {
        this.testDTO = testDTO;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Long getImageId() {
        return imageId;
    }

    public void setImageId(Long imageId) {
        this.imageId = imageId;
    }

    public List<Long> getAuthorIds() {
        return authorIds;
    }

    public void setAuthorIds(List<Long> authorIds) {
        this.authorIds = authorIds;
    }

    public static Article toEntity(CreateArticleWithIdsDTO dto) {
        return new Article(
                dto.getTitle(),
                dto.getContent(),
                LocalDateTime.now(),
                LocalDateTime.now()
        );
    }
}
