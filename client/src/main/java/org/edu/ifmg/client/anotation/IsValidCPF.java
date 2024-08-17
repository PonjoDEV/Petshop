package org.edu.ifmg.client.anotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import org.edu.ifmg.client.Validator.ValidatorCPF;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy =ValidatorCPF.class)
public @interface IsValidCPF {
    String message () default "Invalid CPF";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
