package com.buyogo.Backend_Traini8_saurav.apis;
import com.buyogo.Backend_Traini8_saurav.entities.TrainingCenter;
import com.buyogo.Backend_Traini8_saurav.service.TrainingCenterService;
import com.buyogo.Backend_Traini8_saurav.utilities.ApiOutput;
import com.buyogo.Backend_Traini8_saurav.utilities.ValidationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;


@Service
public class CreateTrainingCenterApi {
    @Autowired
    TrainingCenterService trainingCenterService;
    @Autowired
    ValidationUtils validationUtils;

    public ApiOutput<?> createTrainingCenter(TrainingCenter trainingCenter) {
        try {
            validationUtils.validation(trainingCenter,"trainingCenter");
            return trainingCenterService.createTrainingCenter(trainingCenter);
        } catch (Exception e) {
            return new ApiOutput<>(HttpStatus.BAD_REQUEST.value(), e.getMessage());
        }
    }
}
