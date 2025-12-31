package com.example.be_smartshopai.Service.News;

import com.example.be_smartshopai.Model.News;
import com.example.be_smartshopai.Request.News.NewsCreateRequest;

import com.example.be_smartshopai.Request.News.NewsUpdateRequest;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface NewsService {

    List<News> getAll();

    News getById(Long id);

    News create(NewsCreateRequest request, MultipartFile thumbnail);

    News update(Long id, NewsUpdateRequest request, MultipartFile thumbnail);

    void delete(Long id);
}
