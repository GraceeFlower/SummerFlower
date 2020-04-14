package com.summerflower.movie.services;

import com.summerflower.movie.entities.Detail;
import com.summerflower.movie.repositories.DetailRepository;
import org.springframework.stereotype.Service;

@Service
public class DetailService {

    private final DetailRepository detailRepository;

    public DetailService(DetailRepository detailRepository) {
        this.detailRepository = detailRepository;
    }

    public void saveDetails(Detail detailList) {
        detailRepository.save(detailList);
    }

    public Detail getInfo(int id) {
        return detailRepository.findById(id).orElse(null);
    }
}
