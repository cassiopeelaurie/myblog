package org.wildcodeschool.myblog.author;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthorController {

    private final AuthorRepo authorRepo;

    public AuthorController(AuthorRepo authorRepo) {
        this.authorRepo = authorRepo;
    }

    @GetMapping("/all")
    public List<Author> getAll() {
        return authorRepo.findAll();
    }
}
