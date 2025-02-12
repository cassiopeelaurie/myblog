package org.wildcodeschool.myblog.category;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    private final CategoryRepo categoryRepo;

    public CategoryController(CategoryRepo categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

    @GetMapping("/all")
    public List<Category> getAll() {
        return categoryRepo.findAll();
    }


}

