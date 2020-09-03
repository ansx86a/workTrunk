package hello.rest;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;

/**
 * 另外有SessionAttribute和RequestAttribute
 * 他的好像是可以拿掉HttpSession和HttpRequest
 * <p>
 * 使用情境：在modalAttribute中init了session或是request後，在requestMapping method中使用
 * 使用情境2：在aop中init了session或是request後，在requestMapping method中使用
 * 使用情境3：forward的請求
 *
 * 另外有SessionAttributes，多一個s要注意，他可以指定把model中的name轉成sessionScope
 * 我覺得request scope應該也要可以，要用的時候再試一下
 *
 *
 */
@RestController
public class ModelAttributeController {

    private static int count = 0;

    //    http://127.0.0.1:8080/modelAttr/ex01
    @GetMapping("modelAttr/ex01")
    public String ex01(Model model) {
        /**
         * ModelAttribute在method上面，等於進requestMapping先init model，而init model就是執行該method，順序應該沒辦法控制
         * 也可用void method，在該method中直接model.setAtt...
         */
        System.out.println(model.asMap());
        return "ok-";
    }

    //    http://127.0.0.1:8080/modelAttr/ex02?type=cat&age=100&color=black
    @GetMapping("modelAttr/ex02")
    public String ex02(Model model, @ModelAttribute("ppp") Pet pet) {
        /**
         * 在參數的用在 form Submit之後，要把值帶回去的時候，直接設在參數可以少寫一次model.addAttribute，或是model變數可以拔掉
         */

        System.out.println(model.asMap());
        return "ok-";
    }

    //name會等於int，使用model.addAttribute(obj)，名字會是class的shortName，使用spring的ClassUtils.getShortNameAsProperty
    @ModelAttribute
    public int model01() {
        return count++;
    }

    //有重覆的name，仍會執行，但model的值只會有一筆，我測試的結果是留較先執行的
    @ModelAttribute
    public int model03() {
        return count++;
    }

    @ModelAttribute(name = "model02Name")
    public int model02() {
        return count++;
    }

    static class Pet {
        private String type;
        private String color;
        private int age;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "Pet{" +
                    "type='" + type + '\'' +
                    ", color='" + color + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}
