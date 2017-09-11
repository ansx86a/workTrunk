package 驗証;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Test {

	/**
	 * <pre>
	 * 表 1. Bean Validation 規範內嵌的約束註解定義
	 * @Null	驗證對象是否為空
	 * @NotNull	驗證對象是否為非空
	 * @AssertTrue	驗證 Boolean 對象是否為 true
	 * @AssertFalse	驗證 Boolean 對象是否為 false
	 * @Min	驗證 Number 和 String 對象是否大等於指定的值
	 * @Max	驗證 Number 和 String 對象是否小等於指定的值
	 * @DecimalMin	驗證 Number 和 String 對象是否大等於指定的值，小數存在精度
	 * @DecimalMax	驗證 Number 和 String 對象是否小等於指定的值，小數存在精度
	 * @Size	驗證對象（Array,Collection,Map,String）長度是否在給定的範圍之內
	 * @Digits	驗證 Number 和 String 的構成是否合法
	 * @Past	驗證 Date 和 Calendar 對象是否在當前時間之前
	 * @Future	驗證 Date 和 Calendar 對象是否在當前時間之後
	 * @Pattern	驗證 String 對象是否符合正則表達式的規則
	 * 
	 * 補充  @Valid是對物件做inner bean 驗証使用
	 * </pre>
	 */
	private Validator validator;

	public Test() {
		ValidatorFactory vf = Validation.buildDefaultValidatorFactory();
		this.validator = vf.getValidator();
	}

	public static void main(String[] args) {
		Test jb = new Test();

		jb.$1基本驗証();

	}

	public void $1基本驗証() {
		Employee e = new Employee();

		Set<ConstraintViolation<Employee>> set = validator.validate(e);
		for (ConstraintViolation<Employee> constraintViolation : set) {
			System.out.println(constraintViolation.getMessage());
		}
	}

	public void 驗証和輸出LOG() {
	}

	static class Employee {
		@NotNull(message = "The id of employee can not be null")
		private Integer id;

		@NotNull(message = "The name of employee can not be null")
		@Size(min = 1, max = 10, message = "The size of employee's name must between 1 and 10")
		private String name;

		@我的驗証註解(message = "自已實作，不可以空值或是null")
		private String mytest;

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
