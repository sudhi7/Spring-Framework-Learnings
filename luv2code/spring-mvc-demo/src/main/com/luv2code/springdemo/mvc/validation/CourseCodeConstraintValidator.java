package com.luv2code.springdemo.mvc.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String> {

    private String CoursePrefix;

    @Override
    public void initialize(CourseCode constraintAnnotation) {
        CoursePrefix = constraintAnnotation.value();
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {

        boolean result = true;

        if(s!=null)
            result = s.startsWith(CoursePrefix);

        return result;
    }
}
