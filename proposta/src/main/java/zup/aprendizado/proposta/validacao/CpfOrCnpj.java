package zup.aprendizado.proposta.validacao;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

/*
 * Anotação que verificará Se é CPF ou CNPJ 
 */

@Documented
@Constraint(validatedBy = { ValidadorCpfCnpj.class })
@Target({ ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface CpfOrCnpj {

	String message() default "Erro: Verifique se o documento é válido!";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
