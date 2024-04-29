package com.buyogo.Backend_Traini8_saurav.repositories.specification;
import com.buyogo.Backend_Traini8_saurav.entities.TrainingCenter;
import com.buyogo.Backend_Traini8_saurav.model.searchCriteria.TrainingCenterSearchCriteria;
import com.buyogo.Backend_Traini8_saurav.utilities.StringUtil;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import org.springframework.data.jpa.domain.Specification;
import static com.buyogo.Backend_Traini8_saurav.constant.TrainingCenterConstant.*;



public class TrainingCanterSpecifications {

    public static Specification<TrainingCenter> buildSearchCriteria(final TrainingCenterSearchCriteria searchCriteria){
        var retVal = Specification.<TrainingCenter>where(null);

        if (!StringUtil.isNullOrEmpty(searchCriteria.getCenterName())){
            retVal = retVal.and(filterByCenterName(searchCriteria.getCenterName()));
        }
        if (!StringUtil.isNullOrEmpty(searchCriteria.getCity())){
            retVal = retVal.and(filterByCity(searchCriteria.getCity()));
        }
        if (!StringUtil.isNullOrEmpty(searchCriteria.getState())){
            retVal = retVal.and(filterByState(searchCriteria.getState()));
        }
        if (!StringUtil.isNullOrEmpty(searchCriteria.getStudentCapacity())){
            retVal = retVal.and(filterByStudentCapacity(searchCriteria.getStudentCapacity()));
        }
        if (!StringUtil.isNullOrEmpty(searchCriteria.getCourseName())){
            retVal = retVal.and(filterByCoursesOffered(searchCriteria.getCourseName()));
        }

        if (!StringUtil.isNullOrEmpty(searchCriteria.getCenterCode())){
            retVal = retVal.and(filterByCenterCode(searchCriteria.getCenterCode()));
        }

        return retVal;
    }

    private static Specification<TrainingCenter> filterByCenterName(final String centerName){
        return ((root, query, criteriaBuilder) ->
                criteriaBuilder.like(root.get(CENTER_NAME), withLikePattern(centerName))
        );
    }

    private static Specification<TrainingCenter> filterByCity(final String city){
        return ((root, query, criteriaBuilder) ->
                criteriaBuilder.like(criteriaBuilder.lower(root.get(ADDRESS).get(CITY)), withLikePattern(city).toLowerCase())
        );
    }

    private static Specification<TrainingCenter> filterByState(final String state){
        return ((root, query, criteriaBuilder) ->
                criteriaBuilder.like(criteriaBuilder.lower(root.get(ADDRESS).get(STATE)), withLikePattern(state))
        );
    }

    private static Specification<TrainingCenter> filterByStudentCapacity(final String capacity){
        return ((root, query, criteriaBuilder) ->
                criteriaBuilder.greaterThanOrEqualTo(root.get(STUDENT_CAPACITY), Integer.valueOf(capacity))
        );
    }

    private static Specification<TrainingCenter> filterByCoursesOffered(final String courseName){
        return (root, query, criteriaBuilder) -> {
            // Create a join between TrainingCenter and the table storing coursesOffered
            Join<TrainingCenter,String> coureseJoin = root.join(COURSE_OFFERED, JoinType.INNER);
            // Add the condition to match the course name
            return criteriaBuilder.like(coureseJoin,withLikePattern(courseName));
        };
    }

    private static Specification<TrainingCenter> filterByCenterCode(final String centerCode){
        return ((root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get(CENTER_CODE), centerCode)
        );
    }

    private static String withLikePattern(String str){
        return "%" + str + "%";
    }
}
