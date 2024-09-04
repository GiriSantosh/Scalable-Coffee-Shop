package net.santosh.event.source.web.validation;

import java.util.Objects;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import net.santosh.event.source.backend.entity.CoffeeType;

/**
 * @author santosh
 *
 */
public class ValidateCoffeeType implements ConstraintValidator<IsValidCoffeeType, String>{

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		return Objects.nonNull(CoffeeType.fromString(value));
	}

}
