package br.com.logap.financeiro2.model;

import javax.validation.Constraint;
import javax.validation.OverridesAttribute;
import javax.validation.Payload;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;


@Constraint(validatedBy = {})
@NotNull
@DecimalMin("0")
public @interface DecimalPositivo {
	@OverridesAttribute(constraint = DecimalMin.class, name = "message")
	String message() default "{com.algaworks.NumeroDecimal.message}";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
}
