package com.example.railwayinfosystem.repository;

import com.example.railwayinfosystem.model.Train;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrainRepository extends JpaRepository<Train, Long> {

    List<Train> findByNumber(String number);

    List<Train> findByDestination(String destination);
}
