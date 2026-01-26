package com.onyxperseus.common.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class EnumValidator implements ConstraintValidator<EnumConstraint, String> {
    private Class<? extends Enum<?>> enumClass;
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return true; // Consider using @NotNull for null checks
        }

        for (Enum<?> enumConstant : enumClass.getEnumConstants()) {
            if (enumConstant.name().equals(value)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public void initialize(EnumConstraint constraintAnnotation) {
        this.enumClass = constraintAnnotation.enumClass();
        ConstraintValidator.super.initialize(constraintAnnotation);
    }
    
}
