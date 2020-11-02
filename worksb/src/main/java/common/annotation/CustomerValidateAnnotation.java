package common.annotation;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD, ElementType.PARAMETER,})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CustomerValidateAnnotation.MyValidate.class)
@Documented
public @interface CustomerValidateAnnotation {
    //至少宣告以下三個？
    String message() default "要偶數才行";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    //第一個參數要annotation，第二個參數要可驗証的類別
    class MyValidate implements ConstraintValidator<CustomerValidateAnnotation, Integer> {
        @Override
        public boolean isValid(Integer value, ConstraintValidatorContext context) {
            return value % 2 == 0;
        }
    }
}
