package 驗証;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.internal.engine.path.NodeImpl;
import org.hibernate.validator.internal.engine.path.PathImpl;

/**
 * <pre>
 * 要載入pom檔，可去官網找一下  http://hibernate.org/validator/documentation/getting-started/
 * <!-- java 驗証要綁validator，例如hibernate-validator -->
 * <!-- hibernate-validator 要綁javax.el -->
 * hibernate-validator-cdi 不知道是？？？
 * </pre>
 *
 * @author ai
 */
public class JavaBean驗證 {
    /**
     * <pre>
     * 表 1. Bean Validation 規範內嵌的約束註解定義
     * @Null 驗證對象是否為空
     * @NotNull 驗證對象是否為非空
     * @AssertTrue 驗證 Boolean 對象是否為 true
     * @AssertFalse 驗證 Boolean 對象是否為 false
     * @Min 驗證 Number 和 String 對象是否大等於指定的值
     * @Max 驗證 Number 和 String 對象是否小等於指定的值
     * @DecimalMin 驗證 Number 和 String 對象是否大等於指定的值，小數存在精度
     * @DecimalMax 驗證 Number 和 String 對象是否小等於指定的值，小數存在精度
     * @Size 驗證對象（Array,Collection,Map,String）長度是否在給定的範圍之內
     * @Digits 驗證 Number 和 String 的構成是否合法
     * @Past 驗證 Date 和 Calendar 對象是否在當前時間之前
     * @Future 驗證 Date 和 Calendar 對象是否在當前時間之後
     * @Pattern 驗證 String 對象是否符合正則表達式的規則
     *
     * 補充  @Valid是對物件做inner bean 驗証使用
     * </pre>
     */
    private Validator validator;

    public JavaBean驗證() {
        // https://www.ibm.com/developerworks/cn/java/j-lo-jsr303/index.html
        ValidatorFactory vf = Validation.buildDefaultValidatorFactory();
        this.validator = vf.getValidator();
        // The generated ValidatorFactory and Validator instances are thread-safe and can be cached.

        // 使用hibernateValidator，如果有多個實作的話應該就是用這個來指定
        // vf = Validation.byProvider(HibernateValidator.class).configure().buildValidatorFactory();
    }

    public static void main(String[] args) {
        // http://docs.jboss.org/hibernate/stable/validator/reference/en-US/html_single/#validator-metadata-api
        JavaBean驗證 jb = new JavaBean驗證();

        // jb.$1基本驗證();
        jb.$2Method的驗證();
    }

    public void $1基本驗證() {
        Employee e = new Employee();
        e.name = "名字不能超過10個字,,,,,";
        this.驗証和輸出LOG(e);
    }

    /**
     * 可用假method，他會把前面的is或是get拿掉當你的path
     */
    public void $2Method的驗證() {
        Car c = new Car(null, false);
        this.驗証和輸出LOG(c);
    }

    public <T> void 驗証和輸出LOG(T t) {
        Set<ConstraintViolation<T>> set = validator.validate(t);

        //如果沒有的驗証全部的值，只要驗一個property的話，可以用下面的方式試試，但還沒有實際驗証過
        //Set<ConstraintViolation<T>> constraintViolations = validator.validateProperty(t, "manufacturer");
        //如果還沒有instance的時候使用，和validateProperty相同吧，但還沒有實際驗証過
        //Set<ConstraintViolation<Car>> constraintViolations3 = validator.validateValue(Car.class, "manufacturer", null);

        System.out.println("共有錯誤筆數：" + set.size());
        for (ConstraintViolation<T> c : set) {
            System.out.println(c.getMessage());
            PathImpl p = (PathImpl) c.getPropertyPath();
            NodeImpl currentNode = p.getLeafNode();
            System.out.println(String.format("%s的值不能為%s", currentNode.getName(), currentNode.getValue()));
        }
    }

    // 順序？用處？
    // @GroupSequence({ Employee.class })
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

    static class Car {

        private String manufacturer;

        private boolean isRegistered;

        public Car(String manufacturer, boolean isRegistered) {
            this.manufacturer = manufacturer;
            this.isRegistered = isRegistered;
        }

        @NotNull
        public String getManufacturer() {
            return manufacturer;
        }

        public void setManufacturer(String manufacturer) {
            this.manufacturer = manufacturer;
        }

        @AssertTrue
        public boolean isRegistered() {
            return isRegistered;
        }

        public void setRegistered(boolean isRegistered) {
            this.isRegistered = isRegistered;
        }

        @NotNull
        public Boolean get我會回傳false的函式() {
            return null;
        }

    }
}
