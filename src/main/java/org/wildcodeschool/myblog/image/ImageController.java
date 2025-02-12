package org.wildcodeschool.myblog.image;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/image")
public class ImageController {

    private final ImageRepo imageRepo;

    public ImageController(ImageRepo imageRepo) {
        this.imageRepo = imageRepo;
    }

    @GetMapping("/all")
    public List<Image> getAllImages() {
        return imageRepo.findAll();
    }
}
