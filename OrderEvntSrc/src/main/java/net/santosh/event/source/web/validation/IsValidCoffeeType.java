package net.santosh.event.source.web.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

/**
 * @author santosh
 *
 */
@Documented
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy=ValidateCoffeeType.class)
public @interface IsValidCoffeeType {

	String message() default "CoffeeType should be either  ESPRESSO, POUR_OVER, FRENCH_PRESS;";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
