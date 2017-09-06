package 驗証;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

//前面放註解，後面是指要驗証的class type吧
public class 我的驗証註解實作 implements ConstraintValidator<我的驗証註解, String> {

	@Override
	public boolean isValid(String arg0, ConstraintValidatorContext arg1) {
		if (arg0 == null || arg0.length() == 0)
			return false;
		return true;
	}
}
