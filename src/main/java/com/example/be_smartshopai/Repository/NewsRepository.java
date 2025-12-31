package com.example.be_smartshopai.Repository;

import com.example.be_smartshopai.Model.News;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewsRepository extends JpaRepository<News, Long> {
}
