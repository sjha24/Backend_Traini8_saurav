package com.buyogo.Backend_Traini8_saurav.model.searchCriteria;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Sort.Direction;

import static com.buyogo.Backend_Traini8_saurav.constant.TrainingCenterConstant.CREATED_ON;


@Data
@NoArgsConstructor
public class PageableSearchCriteria {

    private int perPage = 10;
    private int pageNo = 1;
    private String sortBy = CREATED_ON;
    private Direction sortDirection = Direction.DESC;

    @Builder
    public PageableSearchCriteria(
            final int perPage,
            final int pageNo,
            final String sortBy,
            final Direction sortDirection
    ){
        this.perPage = perPage;
        this.pageNo = pageNo;
        this.sortBy = sortBy;
        this.sortDirection = sortDirection;
    } 

}
