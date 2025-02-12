package org.wildcodeschool.myblog.article;

import jakarta.validation.constraints.NotBlank;

public class TestDTO {

    @NotBlank(message = "Le titre de TEST DTO ne peut pas être vide")
    private String title;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
