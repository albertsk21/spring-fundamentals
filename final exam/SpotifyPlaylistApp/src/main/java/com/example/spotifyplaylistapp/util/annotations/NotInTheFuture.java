package com.example.spotifyplaylistapp.util.annotations;


import com.example.spotifyplaylistapp.util.validator.DateValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = DateValidator.class)
public @interface NotInTheFuture {

    String message() default "Invalid Date";

    Class <?> [] groups() default {};

    Class <? extends Payload> [] payload() default {};

}
