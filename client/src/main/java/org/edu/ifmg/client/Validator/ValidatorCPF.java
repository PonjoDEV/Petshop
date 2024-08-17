package org.edu.ifmg.client.Validator;
import org.edu.ifmg.client.anotation.IsValidCPF;
import org.edu.ifmg.client.utility.ValidationCPF;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValidatorCPF implements ConstraintValidator<IsValidCPF,String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return ValidationCPF.isValidCPF(value);
    }

}
