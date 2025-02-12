package org.wildcodeschool.myblog.author;

import org.wildcodeschool.myblog.article.Article;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;


    @ManyToMany(mappedBy = "authors")
    private List<Article> articles;

    public Author() {
    }

    public Author(String name) {
        this.name = name;
    }


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }


}
