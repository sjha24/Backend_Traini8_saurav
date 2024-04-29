package com.buyogo.Backend_Traini8_saurav.controller;
import com.buyogo.Backend_Traini8_saurav.apis.FetchTrainingCenterApi;
import com.buyogo.Backend_Traini8_saurav.entities.TrainingCenter;
import com.buyogo.Backend_Traini8_saurav.model.searchCriteria.TrainingCenterSearchCriteria;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import com.buyogo.Backend_Traini8_saurav.apis.CreateTrainingCenterApi;
import com.buyogo.Backend_Traini8_saurav.utilities.ApiOutput;



@RestController
@RequestMapping("/training-center")
@RequiredArgsConstructor
public class TrainingCenterController {

	private final CreateTrainingCenterApi createTrainingCenterApi;
	private final FetchTrainingCenterApi fetchTrainingCenterApi;
	
	@PostMapping("/register")
	public ApiOutput<?> createTrainingCenter(@RequestBody TrainingCenter trainingCenter){
		return createTrainingCenterApi.createTrainingCenter(trainingCenter);
	}

	@GetMapping("/all")
	public ApiOutput<?> fetchTrainingCenter(final TrainingCenterSearchCriteria searchCriteria){
		return fetchTrainingCenterApi.process(searchCriteria);
	}
}
