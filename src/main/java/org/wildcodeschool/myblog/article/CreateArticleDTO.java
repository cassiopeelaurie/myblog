package org.wildcodeschool.myblog.article;

import java.time.LocalDateTime;

public class CreateArticleDTO {
    private String title;
    private String content;

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

    public static Article toEntity(CreateArticleDTO dto) {
        return new Article(
                dto.getTitle(),
                dto.getContent(),
                LocalDateTime.now(),
                LocalDateTime.now()
        );
    }
}
