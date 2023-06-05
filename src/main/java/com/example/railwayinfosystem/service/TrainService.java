package com.example.railwayinfosystem.service;

import com.example.railwayinfosystem.model.Train;
import com.example.railwayinfosystem.repository.TrainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class TrainService {

    private final TrainRepository trainRepository;

    @Autowired
    public TrainService(TrainRepository trainRepository) {
        this.trainRepository = trainRepository;
    }

    public List<Train> findAll() {
        return trainRepository.findAll();
    }

    public void save(Train train) {
        trainRepository.save(train);
    }

    public List<Train> findByNumber(String number) {
        return trainRepository.findByNumber(number);
    }

    public List<Train> findByDestination(String destination) {
        return trainRepository.findByDestination(destination);
    }
}


