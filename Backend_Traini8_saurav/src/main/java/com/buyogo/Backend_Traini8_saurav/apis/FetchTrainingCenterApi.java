package com.buyogo.Backend_Traini8_saurav.apis;
import com.buyogo.Backend_Traini8_saurav.model.responses.PageableResponse;
import com.buyogo.Backend_Traini8_saurav.model.searchCriteria.TrainingCenterSearchCriteria;
import com.buyogo.Backend_Traini8_saurav.service.TrainingCenterService;
import com.buyogo.Backend_Traini8_saurav.utilities.ApiOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;



@Service
public class FetchTrainingCenterApi {
    @Autowired
    TrainingCenterService trainingCenterService;

    public ApiOutput<?> process(TrainingCenterSearchCriteria searchCriteria) {
        try {
            return new ApiOutput<>(HttpStatus.OK.value(), null,trainingCenterService.fetchTrainingCenters(searchCriteria));
        }catch (Exception e){
            throw  new RuntimeException(e.getMessage());
        }
    }
}
