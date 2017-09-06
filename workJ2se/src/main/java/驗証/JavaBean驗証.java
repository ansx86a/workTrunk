package 驗証;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.GroupSequence;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * <pre>
 * 要載入pom檔，可去官網找一下  http://hibernate.org/validator/documentation/getting-started/
 * <!-- java 驗証要綁validator，例如hibernate-validator -->
 * <!-- hibernate-validator 要綁javax.el -->
 * hibernate-validator-cdi 不知道是？？？
 * </pre>
 * 
 * @author ai
 *
 */
public class JavaBean驗証 {
	private Validator validator;

	public JavaBean驗証() {
		ValidatorFactory vf = Validation.buildDefaultValidatorFactory();
		this.validator = vf.getValidator();
	}

	public static void main(String[] args) {
		JavaBean驗証 jb = new JavaBean驗証();

		jb.$1基本驗証();

	}

	public void $1基本驗証() {
		Employee e = new Employee();

		e.name = "名字不能超過10個字,,,,,";
		Set<ConstraintViolation<Employee>> set = validator.validate(e);
		System.out.println(set.size());
		for (ConstraintViolation<Employee> constraintViolation : set) {
			System.out.println(constraintViolation.getMessage());
		}
	}

	public void 驗証和輸出LOG() {
	}

	// 順序？用處？
	// @GroupSequence({ Employee.class })
	static class Employee {
		@NotNull(message = "The id of employee can not be null")
		private Integer id;

		@NotNull(message = "The name of employee can not be null")
		@Size(min = 1, max = 10, message = "The size of employee's name must between 1 and 10")
		private String name;

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
	}

}
