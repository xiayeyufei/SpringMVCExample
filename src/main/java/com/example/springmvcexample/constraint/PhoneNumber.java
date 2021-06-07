package com.example.springmvcexample.constraint;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Constraint(validatedBy = { PhoneNumberValidator.class })
@Target({ ElementType.ANNOTATION_TYPE, ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface PhoneNumber {
    String message() default "手机号应符合xxx.xxx.xxxx";

    String value() default "000.000.0000";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
