package bg.softuni.project.linkedout.model.validation.annotations;

import bg.softuni.project.linkedout.model.validation.validators.BirthdateValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = BirthdateValidator.class)
public @interface NotMinorPerson {

    String message() default "";

    Class <?> [] groups() default {};
    Class <? extends Payload> [] payload() default {};
}
