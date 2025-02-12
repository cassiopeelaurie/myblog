package org.wildcodeschool.myblog.article;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepo extends JpaRepository<Article, Long> {
}
