package com.buyogo.Backend_Traini8_saurav.repositories;
import com.buyogo.Backend_Traini8_saurav.entities.TrainingCenter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


public interface TrainingCenterRepository extends JpaRepository<TrainingCenter, Long>,
        JpaSpecificationExecutor<TrainingCenter> {

}
