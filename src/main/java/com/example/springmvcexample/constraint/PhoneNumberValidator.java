package com.example.springmvcexample.constraint;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneNumberValidator implements ConstraintValidator<PhoneNumber, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        String pattern = "^\\d{3}\\.\\d{3}\\.\\d{4}$";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(value);
        return m.matches();
    }
}
