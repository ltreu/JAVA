package com.LTreu.Swingy.annotations;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = {TypeValidator.class})
public @interface ValidateType
{
    String[] types();

    String message() default "Invalid character type";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
