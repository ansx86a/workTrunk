package hello.rest;

import common.annotation.CustomerValidateAnnotation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.Validator;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@RestController
@Validated
public class Validateion的實作 {

    /**
     * spring boot有直接整合validator，可直接使用即可實現程式驗證
     */

    @Autowired
    private Validator validator;

    /**
     * http://localhost:8080/validate1?name=User&age=150
     *
     * @param input
     * @return
     */
    @GetMapping("/validate1")
    public Input 預設的沒有驗証的部分(Input input) {
        return input;
    }

    /**
     * http://localhost:8080/validate2?name=User&age=150
     * 會丟到error page，並沒有handler成rest response
     *
     * @param input
     * @return
     */
    @GetMapping("/validate2")
    public Input 如果傳入錯誤的age(@Valid Input input, @Valid Input input2) {
        return input;
    }

    /**
     * http://localhost:8080/validate3?name=&age=150
     * 要在controller上加入@Validated才會生效
     * <p>
     * 此例可加入handle驗証錯誤的Ex如下下個method有用，但上例validate2無此作用
     *
     * @param age
     * @param name
     * @return
     */
    @GetMapping("/validate3")
    public Input 如意傳入錯誤的age(@Max(100) int age, @NotBlank String name) {
        Input input = new Input();
        input.age = age;
        input.name = name;
        return input;
    }

    @GetMapping("/validate4")
    public void 使用service驗証() {
        //只要在service的class加上Validated即可
        //其它和在controller相同，無須再寫範例
        //出錯就會丟出ConstraintViolationException
    }

    /**
     * http://localhost:8080/validate5?age=21
     *
     * @param age
     * @return
     */
    @GetMapping("/validate5")
    public Integer 使用service驗証(@CustomerValidateAnnotation Integer age) {
        return age;
    }

    /**
     * http://localhost:8080/validate6?name=11&age=11&validByGroup=1
     * 注意，會先驗証沒有group的部分，有錯就會先丟ex
     * 之後才會驗group 的部分，要注意要全部一起驥証就要全加或全不加group
     *
     * @param input
     * @return
     */
    @GetMapping("/validate6")
    @Validated(Group.OnCreate.class)
    public Input 使用Group驗証(@Valid Input input) {
        return input;
    }

    /**
     * http://localhost:8080/validate7?name=11&age=11&validByGroup=2
     *
     * @param input
     * @return
     */
    @GetMapping("/validate7")
    @Validated(Group.OnUpdate.class)
    public Input 使用Group驗証2(@Valid Input input) {
        return input;
    }

    /**
     * http://localhost:8080/validate8?name=11&age=11&validByGroup=2
     *
     * @param input
     * @return
     */
    @GetMapping("/validate8")
    public Input 用程式驗証模擬Group的部分(Input input) {
        //只使用group的話，沒有group的部分就不會被使用
        Set<ConstraintViolation<Input>> result = validator.validate(input, Group.OnUpdate.class);
        if (!result.isEmpty()) {
            throw new ConstraintViolationException(result);
        }
        //所以增加沒有group的部分
        result = validator.validate(input);
        if (!result.isEmpty()) {
            throw new ConstraintViolationException(result);
        }
        return input;
    }


    /**
     * ExceptionHandler可寫到@ControllerAdvice裡面，就會變成對多個controller有用
     * <p>
     * 看起來可以處理多個參數，要明砣表示參數的話，要subString不然會有controller method文字
     *
     * @param e
     * @return
     */
    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handle驗証錯誤的Ex(ConstraintViolationException e) {
        List<String> errors = e.getConstraintViolations().stream().map(o ->
                StringUtils.substringAfterLast(o.getPropertyPath().toString(), ".")
                        + ":" + o.getMessage())
                .collect(Collectors.toList());
        return "錯誤參數為原生型別的部分：" + errors;
    }


    /**
     * 看起來會對第一個物件就丟出bindException，後面的物件就不會被檢查到
     *
     * @param e
     * @return
     */
    @ExceptionHandler(BindException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handle驗証錯誤的for物件型別(BindException e) {
        List<String> errors = e.getAllErrors().stream().map(o -> o.getDefaultMessage()).collect(toList());
        return "錯誤參數為物件的部分：" + errors;
    }

    public static class Input {
        @Min(value = 1, message = "我跟你說要大於{value}才可以")
        @Max(100)
        private int age;
        @NotBlank//會trime string，如果是null的話也會出錯
        private String name;
        @Pattern(regexp = "1.+", groups = Group.OnCreate.class)
        @Pattern(regexp = "2.+", groups = Group.OnUpdate.class)
        private String validByGroup;

        /**
         * 記錄一下如果遇到List裡麼使用
         */
        private List<@Min(0) Integer> list = Arrays.asList(1, 2, 3, 4, 5);

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getValidByGroup() {
            return validByGroup;
        }

        public void setValidByGroup(String validByGroup) {
            this.validByGroup = validByGroup;
        }
    }

    interface Group {
        interface OnCreate {
        }

        interface OnUpdate {
        }
    }

}

