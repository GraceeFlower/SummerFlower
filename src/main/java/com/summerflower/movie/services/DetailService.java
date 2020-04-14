package com.summerflower.movie.services;

import com.summerflower.movie.entities.Detail;
import com.summerflower.movie.repositories.DetailRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetailService {

    private final DetailRepository detailRepository;

    public DetailService(DetailRepository detailRepository) {
        this.detailRepository = detailRepository;
    }

    public void saveDetails(List<Detail> detailList) {
        detailRepository.saveAll(detailList);
    }
}
