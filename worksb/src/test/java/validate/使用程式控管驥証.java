package validate;

import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.InputStream;
import java.util.Set;

public class 使用程式控管驥証 {

    private static ValidatorFactory factory = Validation.buildDefaultValidatorFactory();

    @Test
    public void test() {
        //注意：可修改annotation的message，來達成更動顯示的錯誤值
        //另外把hibernate中的ValidationMessages copy到resource下，改名為zh_TW，鍋是直接蓋過英文預設也行
        //debug的話，可由violation.message什麼時候被設定找到AbstractMessageInterpolator，並發現Locale.getDefault()
        //要客製I18N的話，就要解決使用預設的ResourceBundle不然都會跑上一行的程式去

        Input input = new Input();
        input.name = null;
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<Input>> violations = validator.validate(input);
        for(ConstraintViolation<Input> violation:violations){
            System.out.println("主幹類別："+violation.getRootBean().getClass());
            System.out.println("枝葉類別：" + violation.getLeafBean().getClass());
            System.out.println("欄位：" + violation.getPropertyPath());
            System.out.println("錯誤的值：" + violation.getInvalidValue());
            System.out.println("錯誤原因：" + violation.getMessage());
            System.out.println("============================================");
        }

    }


    private static class Input {
        @Min(1)
        @Max(100)
        private int age;
        //如果是null就不會跳騙証，所以要加一下notNull
        @Pattern(regexp = "^[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}$")
        @NotNull
        private String ip;
        @NotBlank//會trime string，如果是null的話也會出錯
        private String name;


    }
}
