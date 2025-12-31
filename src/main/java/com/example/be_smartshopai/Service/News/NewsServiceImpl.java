package com.example.be_smartshopai.Service.News;

import com.example.be_smartshopai.Model.News;
import com.example.be_smartshopai.Repository.NewsRepository;
import com.example.be_smartshopai.Request.News.NewsCreateRequest;
import com.example.be_smartshopai.Request.News.NewsUpdateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class NewsServiceImpl implements NewsService {

    private final NewsRepository newsRepository;

    private static final String UPLOAD_DIR =
            System.getProperty("user.dir") + "/uploads/news/";

    private String saveFile(MultipartFile file) {
        try {
            if (file == null || file.isEmpty()) return null;

            File dir = new File(UPLOAD_DIR);
            if (!dir.exists()) dir.mkdirs();

            String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
            file.transferTo(new File(UPLOAD_DIR + fileName));

            return fileName;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Upload file failed");
        }
    }


    @Override
    public List<News> getAll() {
        return newsRepository.findAll();
    }

    @Override
    public News getById(Long id) {
        return newsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("News not found"));
    }

    @Override
    public News create(NewsCreateRequest request, MultipartFile thumbnail) {

        News news = News.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .createdAt(LocalDateTime.now())
                .build();

        if (thumbnail != null && !thumbnail.isEmpty()) {
            news.setThumbnail(saveFile(thumbnail));
        }

        return newsRepository.save(news);
    }

    @Override
    public News update(Long id, NewsUpdateRequest request, MultipartFile thumbnail) {

        News news = getById(id);

        news.setTitle(request.getTitle());
        news.setContent(request.getContent());

        if (thumbnail != null && !thumbnail.isEmpty()) {
            news.setThumbnail(saveFile(thumbnail));
        }

        return newsRepository.save(news);
    }

    @Override
    public void delete(Long id) {
        newsRepository.deleteById(id);
    }
}
