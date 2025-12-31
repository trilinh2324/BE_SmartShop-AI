package com.example.be_smartshopai.Controller.News;

import com.example.be_smartshopai.Model.News;
import com.example.be_smartshopai.Request.News.NewsCreateRequest;
import com.example.be_smartshopai.Request.News.NewsUpdateRequest;
import com.example.be_smartshopai.Service.News.NewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/news")
@RequiredArgsConstructor
@CrossOrigin("*")
public class NewsController {

    private final NewsService newsService;

    @GetMapping
    public List<News> getAll() {
        return newsService.getAll();
    }

    @GetMapping("/{id}")
    public News getById(@PathVariable Long id) {
        return newsService.getById(id);
    }

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public News create(
            @RequestPart("data") NewsCreateRequest request,
            @RequestPart(value = "thumbnail", required = false) MultipartFile thumbnail
    ) {
        return newsService.create(request, thumbnail);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public News update(
            @PathVariable Long id,
            @RequestPart("data") NewsUpdateRequest request,
            @RequestPart(value = "thumbnail", required = false) MultipartFile thumbnail
    ) {
        return newsService.update(id, request, thumbnail);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        newsService.delete(id);
    }
}
