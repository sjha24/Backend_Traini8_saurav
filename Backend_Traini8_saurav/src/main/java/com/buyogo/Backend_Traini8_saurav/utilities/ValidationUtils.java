package com.buyogo.Backend_Traini8_saurav.utilities;
import org.springframework.stereotype.Component;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.stream.Collectors;


@Component
public class ValidationUtils {
	private final Validator validator;

    public ValidationUtils(Validator validator) {
        this.validator = validator;
    }

    // validate any object type
    public <T> void validation(T object, String objectName) throws Exception {
        Errors errors = new BeanPropertyBindingResult(object, objectName);
        validator.validate(object, errors);
        if (errors.hasErrors()) {
            throw new Exception(formatErrors(errors));
        }
    }

    private static String formatErrors(Errors errors) {
        return errors.getAllErrors()
                .stream()
                .map(error -> error.getDefaultMessage())
                .collect(Collectors.joining(", "));
    }
}
