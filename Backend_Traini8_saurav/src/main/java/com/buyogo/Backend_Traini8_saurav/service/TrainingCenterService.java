package com.buyogo.Backend_Traini8_saurav.service;
import com.buyogo.Backend_Traini8_saurav.entities.TrainingCenter;
import com.buyogo.Backend_Traini8_saurav.model.responses.PageableResponse;
import com.buyogo.Backend_Traini8_saurav.model.searchCriteria.TrainingCenterSearchCriteria;
import com.buyogo.Backend_Traini8_saurav.repositories.specification.TrainingCanterSpecifications;
import com.buyogo.Backend_Traini8_saurav.utilities.PageableUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.buyogo.Backend_Traini8_saurav.repositories.TrainingCenterRepository;
import com.buyogo.Backend_Traini8_saurav.utilities.ApiOutput;

import java.util.Objects;


@Service
public class TrainingCenterService {
	
	@Autowired
	TrainingCenterRepository trainingCenterRepository;
	
	public ApiOutput<?> createTrainingCenter(TrainingCenter trainingCenter) {
		
		var trainingCenter1 = trainingCenterRepository.save(trainingCenter);
		return new ApiOutput<>(HttpStatus.OK.value(), "Training Center Created Successfully",trainingCenter1);
	}


	public PageableResponse<TrainingCenter> fetchTrainingCenters(final TrainingCenterSearchCriteria searchCriteria){
		var pageable = PageableUtils.createPageable(searchCriteria);
		Page<TrainingCenter> trainingCenters = trainingCenterRepository.findAll(
				TrainingCanterSpecifications.buildSearchCriteria(searchCriteria),
				pageable
		);
		var reslutList = trainingCenters.getContent().stream()
				.map(TrainingCenterService::getTrainingCenter)
				.filter(Objects::nonNull)
				.toList();
		return new PageableResponse<>(reslutList, searchCriteria);
	}

	private static TrainingCenter getTrainingCenter(TrainingCenter trainingCenter){
		TrainingCenter retVal = null;
		retVal = trainingCenter;
		return retVal;
	}

}
