package com.buyogo.Backend_Traini8_saurav.model.searchCriteria;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Sort.Direction;



@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class TrainingCenterSearchCriteria extends PageableSearchCriteria{
    /**
     * filter by Training center name
     */
    private String centerName;

    /**
     * filter by Training center city
     */
    private String city;

    /**
     * filter by Training center state
     */
    private String state;

    /**
     * filter by Training center course offered
     */
    private String courseName;

    /**
     * filter by Training center student capacity range
     */
    private String studentCapacity;

    /**
     * filter by Training center code
     */
    private String centerCode;


    @Builder(builderMethodName = "trainingCenterSearchCriteriaBuilder")
    public TrainingCenterSearchCriteria(
            final String centerName,
            final String city,
            final String state,
            final String courseName,
            final String studentCapacity,
            final int perPage,
            final int pageNo,
            final String sortBy,
            final Direction sortDirection
    ){
        super(perPage, pageNo, sortBy, sortDirection);
        this.centerName = centerName;
        this.city = city;
        this.state = state;
        this.courseName = courseName;
        this.studentCapacity = studentCapacity;
    }

}
